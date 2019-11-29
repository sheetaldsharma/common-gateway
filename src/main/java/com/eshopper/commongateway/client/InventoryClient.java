package com.eshopper.commongateway.client;

import com.eshopper.commongateway.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "inventory-service1", path = "/inventory")
public interface InventoryClient {

    @PutMapping(value = "/{id}/updateQuantity")
    //@PutMapping(path = "/inventory/{id}/updateQuantity")
    public ProductDTO updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO product);

    @PutMapping(path = "/multiple/updateQuantity")
    public List<ProductDTO> updateProductQuantity(@RequestBody  List<ProductDTO> productList);
}
