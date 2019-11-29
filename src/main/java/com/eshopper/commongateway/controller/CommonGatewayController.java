package com.eshopper.commongateway.controller;

import ch.lambdaj.Lambda;
import com.eshopper.commongateway.dto.*;

import com.eshopper.commongateway.repository.CommonGatewayRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/gateway")
public class CommonGatewayController {
    @Autowired
    CommonGatewayRepository commonGatewayRepository;



    /****************** CUSTOMER END POINTS - START ******************/
    @PostMapping(value = "/customer/register")
    public UserDTO registerCustomer(@RequestBody UserDTO user)
    {
        return commonGatewayRepository.registerCustomer(user);
    }

    /* Get CUtomer personal details */
    @GetMapping(value = "/customer/{customerId}/personalDetails")
    public Optional<UserDTO> getCustomerDetails(@PathVariable("customerId") Integer customerId)
    {
        return commonGatewayRepository.getCustomerDetails(customerId);
    }

    /* Get details of all registered Customer */
    @GetMapping(value = "/customer/all", produces = "application/json")
    public List<UserDTO> getAllCustomer()
    {
        return commonGatewayRepository.getAllCustomer();
    }
    /****************** CUSTOMER END POINTS - END ******************/

    /****************** ORDER END POINTS - START ******************/
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
    public Order createOrder(@PathVariable("customerId") Integer customerId, @RequestBody Order order) {
        System.out.println("==========================================================>" +order.getOrderProductsList().toString());

//
//        List<Integer> ids = new ArrayList<>();
//        List<OrderProducts> orderProductsList = new ArrayList<>();
//        ids = Lambda.extract(order.getOrderProductsList(), Lambda.on(OrderProducts.class).getProductId());
//        System.out.println("===================== "+ ids.size());
//        commonGatewayRepository.updateProduct(order.getCustomerId(), o);
        return commonGatewayRepository.createOrder(customerId, order);
        //commonGatewayRepository.updateProduct(id, product);

    }
    /****************** ORDER END POINTS - END ******************/

    /****************** INVENTORY END POINTS - START ******************/
    @PutMapping(path = "/inventory/{id}/updateQuantity")
    public ProductDTO updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO product)
    {
        System.out.println("========================= "+product.toString());
        return commonGatewayRepository.updateProduct(id, product);
    }

    @PutMapping(path = "/inventory/multiple/updateQuantity")
    public List<ProductDTO> updateProduct(@RequestBody  List<ProductDTO> productList)
    {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return commonGatewayRepository.updateProductQuantity(productList);
    }

    /****************** INVENTORY END POINTS - END ******************/

}
