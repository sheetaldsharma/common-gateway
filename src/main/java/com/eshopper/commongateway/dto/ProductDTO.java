package com.eshopper.commongateway.dto;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String sku;
    private String name;
    private String description;
    private String brandName;
    private Integer supplierId;
    private Integer categoryId;
    private Integer quantityPerUnit;
    private Float unitPrice;
    private String color;
    private Float discount;
    private Boolean discountAvailable;
    private String picture;
}
