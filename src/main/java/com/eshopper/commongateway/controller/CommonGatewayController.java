package com.eshopper.commongateway.controller;

import com.eshopper.commongateway.dto.OrderDTO;
import com.eshopper.commongateway.dto.OrderProductDTO;

import com.eshopper.commongateway.dto.UserDTO;
import com.eshopper.commongateway.repository.CommonGatewayRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<OrderDTO> getAllOrdersDetails() {
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
    /****************** ORDER END POINTS - END ******************/




    //    @GetMapping("/customer/{customerId}/orderDetails")
//    public List<OrderDTO> getCustomerAllOrdersDetails(@PathVariable("customerId") Integer customerId)
//    {
//        return commonGatewayRepository.getCustomerAllOrdersDetails(customerId);
//    }
//
//    @GetMapping("/customer/{customerId}/order/{orderId}/details")
//    public List<OrderProductDTO> getCustomerOrderDetails(@PathVariable("customerId") Integer customerId, @PathVariable("orderId") Integer orderId)
//    {
//        return commonGatewayRepository.getCustomerOrderDetails(customerId, orderId);
//
//    }

}
