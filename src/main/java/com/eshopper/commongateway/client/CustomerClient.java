package com.eshopper.commongateway.client;

import com.eshopper.commongateway.exception.CustomerServiceException;
import com.eshopper.commongateway.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "customer-service1")
public interface CustomerClient {

    /****************** CUSTOMER END POINTS - START ******************/
    /* Add new customer */
    @PostMapping("/customer/register")
    public User registerCustomer(@RequestBody User user);

    /* Get Customer personal details */
    @GetMapping("/customer/{customerId}/personalDetails")
    public Optional<User> getCustomerDetails(@PathVariable("customerId") Integer customerId) throws CustomerServiceException;

    /* Get details of all registered Customer */
    @GetMapping(value = "/customer/all", produces = "application/json")
    public List<User> getAllCustomer();

    /****************** CUSTOMER END POINTS - END ******************/
}


