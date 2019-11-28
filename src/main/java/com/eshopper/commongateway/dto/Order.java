package com.eshopper.commongateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "customerid")
    @NotNull
    private Integer customerId;

    @Column(name = "orderstatusid")
    @NotNull
    private Integer orderStatusId;

    @Column(name = "shippingaddress")
    @NotNull
    private String shippingAddress;

    @Column(name = "billingaddress")
    @NotNull
    private String billingAddress;

    @Column(name = "invoicedate")
    @NotNull
    private Date invoiceDate;

    @Column(name = "deliverydate")
    @NotNull
    private Date deliveryDate;

    @Column(name = "paymentid")
    @NotNull
    private Integer paymentId;

    @Column(name = "paymentstatus")
    @NotNull
    private Integer paymentStatus;

    @Column(name = "paymentdate")
    @NotNull
    private Date paymentDate;

    @Column(name = "shippmentcompanyid")
    @NotNull
    private Integer shippmentCompanyId;

    @Column(name = "total")
    @NotNull
    private Float total;

    @Column(name = "discount")
    @NotNull
    private Float discount;

    @Column(name = "tax")
    @NotNull
    private Float tax;

    @OneToMany(mappedBy = "orderNumber", cascade = CascadeType.ALL)
    List<OrderProducts> orderProductsList;
}


