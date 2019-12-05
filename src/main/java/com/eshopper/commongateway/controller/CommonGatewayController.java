package com.eshopper.commongateway.controller;

import ch.lambdaj.Lambda;
import com.eshopper.commongateway.client.InventoryClient;
import com.eshopper.commongateway.dto.*;

import com.eshopper.commongateway.exception.CustomerServiceException;
import com.eshopper.commongateway.model.User;
import com.eshopper.commongateway.repository.CommonGatewayRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.hamcrest.core.IsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/gateway")

public class CommonGatewayController {
    @Autowired
    CommonGatewayRepository commonGatewayRepository;

    @Autowired
    InventoryClient inventoryClient;

    /************************************ CUSTOMER END POINTS - START *************************************/
    @PostMapping(value = "/customer/register")
    @HystrixCommand(defaultFallback = "getCustomerDetailsFallback")
    public User registerCustomer(@RequestBody User user)
    {
        return commonGatewayRepository.registerCustomer(user);
    }

    /* Get Customer personal details */
    @GetMapping(value = "/customer/{customerId}/personalDetails")
//    @HystrixCommand(defaultFallback = "getCustomerDetailsFallback")
    public Optional<User> getCustomerDetails(@PathVariable("customerId") Integer customerId) throws CustomerServiceException
    {
        System.out.println("ResponseEntity.errorcode =====");
        System.out.println("------------> before commonGatewayRepository.getCustomerDetails");
        Optional<User> user = commonGatewayRepository.getCustomerDetails(customerId);

        System.out.println("------------> after commonGatewayRepository.getCustomerDetails");
        System.out.println("------------>"+user.toString());
//
//        if (user.isEmpty()) {
//            throw new CustomerServiceException("Customer Not found Controller");
//        } else {
//            System.out.println("In else ++++++");
//        }

        return user;
    }

    public Optional<User> getCustomerDetailsFallback()
    {
        Optional<User> user = Optional.empty();
        return user;
    }

    /* Get details of all registered Customer */
    @GetMapping(value = "/customer/all", produces = "application/json")
    @HystrixCommand(defaultFallback = "getAllCustomerFallback")
    public List<User> getAllCustomer()
    {
        return commonGatewayRepository.getAllCustomer();
    }

    public List<User> getAllCustomerFallback()
    {
        List<User> userList = new ArrayList<>();
        return userList;
    }
    /************************************ CUSTOMER END POINTS - END *************************************/

    /************************************ ORDER END POINTS - START *************************************/
//    @HystrixCommand(fallbackMethod = "orderGetAll")
    @GetMapping(path = "/order/all", produces = APPLICATION_JSON_VALUE)
    public List<Order> getAllOrdersDetails() {
        return commonGatewayRepository.getAllOrdersDetails();
    }

    //Get order details from order table
    @GetMapping(path = "/order/{orderId}/details", produces = APPLICATION_JSON_VALUE)
    public Optional<OrderDTO> getOrderDetails(@PathVariable("orderId") Integer orderId) {
        return commonGatewayRepository.getOrderDetails(orderId);
    }

    //get all orders for a customer
    @GetMapping(path = "/order/{customerId}/orderDetails", produces = APPLICATION_JSON_VALUE)
    public List<OrderDTO> getCustomerAllOrderDetails(@PathVariable("customerId") Integer customerId) {
        return commonGatewayRepository.getCustomerAllOrderDetails(customerId);
    }

    //Get specific order details including products
    @GetMapping(path = "/order/{orderNumber}/product/details", produces = APPLICATION_JSON_VALUE)
    public List<OrderProductDTO> getSpecificOrderDetailsForACustomer(@PathVariable("orderNumber") Integer orderNumber){
        return commonGatewayRepository.getSpecificOrderDetailsForACustomer(orderNumber);
    }

    @PostMapping(path = "/order/customer/{customerId}/orderPlaced")
    @HystrixCommand(defaultFallback = "orderPlacedFallBack")
    public Order createOrder(@PathVariable("customerId") Integer customerId, @RequestBody Order order) {
        System.out.println("==========================================================>" +order.getOrderProductsList().toString());
        Order placedOrder = commonGatewayRepository.createOrder(customerId, order);

        Map<Integer, Integer> productOrderList = new HashMap<>();

        List<ProductQuantity> temp = new ArrayList<>();
        for (OrderProducts orderProducts: order.getOrderProductsList()) {
            ProductQuantity productQuantity1  = new ProductQuantity();
            productQuantity1.setProductId(orderProducts.getProductId());
            productQuantity1.setQuantity(orderProducts.getQuantity());
            temp.add(productQuantity1);
        }
        System.out.println("temp ==> "+temp.toString());
        inventoryClient.updateProductQuantity(temp);
        return placedOrder;

    }
    public Order orderPlacedFallBack()
    {
        System.out.println("Fallback");
        return new Order();
    }

    public List<Order> orderGetAll()
    {
        System.out.println("Fallback orderGetAll");
        List<Order> orders = new ArrayList<>();
        return orders;
    }
    /************************************ CUSTOMER END POINTS - END *************************************/

    /************************************ INVENTORY END POINTS - START **********************************/
    @PutMapping(path = "/inventory/{id}/updateQuantity")
    public ProductDTO updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO product)
    {
        System.out.println("========================= "+product.toString());
        return commonGatewayRepository.updateProduct(id, product);
    }

    @PutMapping(path = "/inventory/multiple/updateQuantity")
    public String updateProduct(@RequestBody  List<ProductQuantity> productQuantityList)
    {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        commonGatewayRepository.updateProductQuantity(productQuantityList);
        return "UpdatedProductQuantity";
    }

    /************************************ INVENTORY END POINTS - END *************************************/

}
