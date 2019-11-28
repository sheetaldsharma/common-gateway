package com.eshopper.commongateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orderproducts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProducts {

    @Id
    @GeneratedValue
    @Column(name = "orderid")
    private Integer orderId;

    @Column(name = "productid")
    @NotNull
    private Integer productId;

    @Column(name = "ordernumber")
    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
    private Integer orderNumber;

    @Column(name = "categoryid")
    @NotNull
    private Integer categoryId;

    @Column(name = "price")
    @NotNull
    private Float price;

    @Column(name = "quantity")
    @NotNull
    private Integer quantity;

    @Column(name = "discount")
    @NotNull
    private Float discount;

    @Column(name = "total")
    @NotNull
    private Integer total;

    @Column(name = "skuid")
    @NotNull
    private String skuid;

    @Column(name = "size")
    @NotNull
    private String size;

    @Column(name = "color")
    @NotNull
    private String color;
}

