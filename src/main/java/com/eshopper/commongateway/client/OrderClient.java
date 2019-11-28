package com.eshopper.commongateway.client;


import com.eshopper.commongateway.dto.OrderDTO;
import com.eshopper.commongateway.dto.OrderProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient("order-service1")
public interface OrderClient {

    @GetMapping(path = "/order/all", produces = APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrdersDetails();

    //Get order details from order table
    @GetMapping(path = "/order/{orderId}/details", produces = APPLICATION_JSON_VALUE)
    public Optional<OrderDTO> getOrderDetails(@PathVariable("orderId") Integer orderId);

    @GetMapping(path = "/order/{customerId}/orderDetails", produces = APPLICATION_JSON_VALUE)
    public List<OrderDTO> getCustomerAllOrderDetails(@PathVariable("customerId") Integer customerId);

    @GetMapping(path = "/order/{orderNumber}/product/details", produces = APPLICATION_JSON_VALUE)
    public List<OrderProductDTO> getSpecificOrderDetailsForACustomer(@PathVariable("orderId") Integer orderId);

}

