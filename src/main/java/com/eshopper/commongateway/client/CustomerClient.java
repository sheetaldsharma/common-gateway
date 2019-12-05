package com.eshopper.commongateway.client;

import com.eshopper.commongateway.dto.OrderDTO;
import com.eshopper.commongateway.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient("customer-service1")
public interface CustomerClient {

    /****************** CUSTOMER END POINTS - START ******************/
    /* Add new customer */
    @PostMapping("/customer/register")
    public UserDTO registerCustomer(@RequestBody UserDTO user);

    /* Get Customer personal details */
    @GetMapping("/customer/{customerId}/personalDetails")
    public Optional<UserDTO> getCustomerDetails(@PathVariable("customerId") Integer customerId);

    /* Get details of all registered Customer */
    @GetMapping(value = "/customer/all", produces = "application/json")
    public List<UserDTO> getAllCustomer();

    /****************** CUSTOMER END POINTS - END ******************/
}

