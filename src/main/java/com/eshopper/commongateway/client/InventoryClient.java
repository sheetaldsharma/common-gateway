package com.eshopper.commongateway.client;

import com.eshopper.commongateway.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "inventory-service1", path = "/inventory")
public interface InventoryClient {

    @PutMapping(value = "/{id}/updateQuantity")
    //@PutMapping(path = "/inventory/{id}/updateQuantity")
    public ProductDTO updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO product);
}
