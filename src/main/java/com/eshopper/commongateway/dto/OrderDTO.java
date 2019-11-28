package com.eshopper.commongateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class OrderDTO {

    private Integer id;
    private Integer customerId;
    private Integer orderStatusId;
    private String shippingAddress;
    private String billingAddress;
    private Date invoiceDate;
    private Date deliveryDate;
    private Integer paymentId;
    private Integer paymentStatus;
    private Date paymentDate;
    private Integer shippmentCompanyId;
    private Float total;
    private Float discount;
    private Float tax;
    List<OrderProductDTO> orderProductsList;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderStatusId=" + orderStatusId +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", deliveryDate=" + deliveryDate +
                ", paymentId=" + paymentId +
                ", paymentStatus=" + paymentStatus +
                ", paymentDate=" + paymentDate +
                ", shippmentCompanyId=" + shippmentCompanyId +
                ", total=" + total +
                ", discount=" + discount +
                ", tax=" + tax +
                ", orderProductsList=" + orderProductsList +
                '}';
    }
}