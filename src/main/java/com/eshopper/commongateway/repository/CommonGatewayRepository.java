package com.eshopper.commongateway.repository;

import com.eshopper.commongateway.client.CustomerClient;
import com.eshopper.commongateway.client.InventoryClient;
import com.eshopper.commongateway.client.OrderClient;
import com.eshopper.commongateway.dto.*;
import com.eshopper.commongateway.exception.CustomerServiceException;
import com.eshopper.commongateway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
public class CommonGatewayRepository {
    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private InventoryClient inventoryClient;


//    public List<OrderDTO> getCustomerAllOrdersDetails(Integer customerId)
//    {
//        return orderClient.getCustomerAllOrderDetails(customerId);
//    }

//    public OrderProductDTO getCustomerOrderDetails(Integer customerId, Integer orderId )
//    {
//        return orderClient.getSpecificOrderDetailsForACustomer(customerId, orderId);
//
//    }
    /****************** CUSTOMER END POINTS - START ******************/
    public User registerCustomer(User user)
    {
        return customerClient.registerCustomer(user);
    }

    public Optional<User> getCustomerDetails(Integer customerId) throws CustomerServiceException
    {
        System.out.println("------------> before customerClient.getCustomerDetails");
        Optional<User> user = Optional.empty();
        try {
            user = customerClient.getCustomerDetails(customerId);
            throw new CustomerServiceException();

        }catch(CustomerServiceException e)
        {
            System.out.println(e.getErrorMessage());
        }
//
//
//        if(user.isEmpty())
//        {
//            throw new CustomerServiceException("Customer Not found repository");
//        }

        System.out.println("------------> after customerClient.getCustomerDetails");
        return user;
    }

    public List<User> getAllCustomer() {
        return customerClient.getAllCustomer();
    }
    /****************** CUSTOMER END POINTS - END ******************/

    /****************** ORDER END POINTS - START ******************/
    public List<Order> getAllOrdersDetails() {

        return orderClient.getAllOrdersDetails();
    }

    //Get order details from order table
    public Optional<OrderDTO> getOrderDetails(Integer orderId) {
        return orderClient.getOrderDetails(orderId);
    }

    //get all orders for a customer
    public List<OrderDTO> getCustomerAllOrderDetails(Integer customerId) {
        return orderClient.getCustomerAllOrderDetails(customerId);
    }

    //Get specific order details including products
    public List<OrderProductDTO> getSpecificOrderDetailsForACustomer(Integer orderNumber) {
        return orderClient.getSpecificOrderDetailsForACustomer(orderNumber);
    }

    public Order createOrder(@PathVariable("customerId") Integer customerId, @RequestBody Order order) {
        System.out.println("############################# "+order.getOrderProductsList().toString());
        return orderClient.createOrder(customerId, order);
    }
    /****************** ORDER END POINTS - END ******************/

    /****************** INVENTORY END POINTS - START ******************/
    public ProductDTO updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO product)
    {
        System.out.println("========================= updateProduct ----"+product.toString());
        return inventoryClient.updateProduct(id, product);
    }

    public String updateProductQuantity(List<ProductQuantity> productQuantityList)
    {
        return inventoryClient.updateProductQuantity(productQuantityList);
    }
    /****************** INVENTORY END POINTS - END ******************/
}
