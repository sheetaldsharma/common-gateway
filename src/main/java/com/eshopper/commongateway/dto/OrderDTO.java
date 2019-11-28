package com.eshopper.commongateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class OrderDTO {

    Integer orderId;
    Integer customerId;
    Integer orderStatusId;
    String shippingAddress;
    String billingAddress;
    Date invoiceDate;
    Date deliveryDate;
    Integer paymentId ;
    String paymentStatus;
    Date paymentDate ;
    Integer shippmentCompanyId;
    Float total;
    Float discount;
    Float tax;

}