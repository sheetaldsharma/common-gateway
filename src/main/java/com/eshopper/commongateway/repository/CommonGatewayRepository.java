package com.eshopper.commongateway.repository;

import com.eshopper.commongateway.client.CustomerClient;
import com.eshopper.commongateway.client.OrderClient;
import com.eshopper.commongateway.client.PaymentClient;
import com.eshopper.commongateway.dto.OrderDTO;
import com.eshopper.commongateway.dto.OrderProductDTO;
import com.eshopper.commongateway.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Repository
public class CommonGatewayRepository {
    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private OrderClient orderClient;


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
    public UserDTO registerCustomer(UserDTO user)
    {
        return customerClient.registerCustomer(user);
    }

    public Optional<UserDTO> getCustomerDetails(Integer customerId)
    {
        return customerClient.getCustomerDetails(customerId);
    }

    public List<UserDTO> getAllCustomer() {
        return customerClient.getAllCustomer();
    }
    /****************** CUSTOMER END POINTS - END ******************/

    /****************** ORDER END POINTS - START ******************/
    public List<OrderDTO> getAllOrdersDetails() {

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
    /****************** ORDER END POINTS - END ******************/
}
