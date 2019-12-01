package com.eshopper.commongateway.dto;



import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="productquantity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "productid")
    @NonNull
    private Integer productId;

    @Column(name = "quantity")
    @NonNull
    private Integer quantity;

    @Override
    public String toString() {
        return "ProductQuantity{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}

