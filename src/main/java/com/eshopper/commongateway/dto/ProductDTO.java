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
    private String size;
    private String color;
    private Float discount;
    private Boolean discountAvailable;
    private String picture;


    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brandName='" + brandName + '\'' +
                ", supplierId=" + supplierId +
                ", categoryId=" + categoryId +
                ", quantityPerUnit=" + quantityPerUnit +
                ", unitPrice=" + unitPrice +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", discount=" + discount +
                ", discountAvailable=" + discountAvailable +
                ", picture='" + picture + '\'' +
                '}';
    }
}
