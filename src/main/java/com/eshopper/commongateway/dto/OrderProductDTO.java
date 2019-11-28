package com.eshopper.commongateway.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderProductDTO {
    private Integer orderId;
    private Integer productId;
    private Integer orderNumber;
    private Integer categoryId;
    private Float price;
    private Integer quantity;
    private Float discount;
    private Integer total;
    private String skuid;
    private String size;
    private String color;

}
