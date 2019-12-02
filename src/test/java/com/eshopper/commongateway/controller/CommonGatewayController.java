package com.eshopper.commongateway.controller;

import com.eshopper.commongateway.dto.Order;
import com.eshopper.commongateway.dto.OrderProducts;
import com.eshopper.commongateway.dto.ProductQuantity;
import com.eshopper.commongateway.repository.CommonGatewayRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

public class CommonGatewayController {
    @Mock
    CommonGatewayRepository commonGatewayRepository;

    @InjectMocks
    CommonGatewayController commonGatewayController;

    @Test
    public void shouldReturnProductQuantityList() {
        Order order = new Order();

        order.setId(25);
        order.setCustomerId(1);
        order.setOrderStatusId(1);
        order.setShippingAddress("Add1");
        order.setBillingAddress("Add1");
        order.setInvoiceDate(new Date());
        order.setDeliveryDate(new Date());
        order.setPaymentId(1);
        order.setPaymentStatus(1);
        order.setPaymentDate(new Date());
        order.setShippmentCompanyId(1);
        order.setTotal(100f);
        order.setDiscount(10f);
        order.setTax(1f);
        List<OrderProducts> orderProductsList = new ArrayList<>();

        OrderProducts orderProduct1 = new OrderProducts();
        OrderProducts orderProduct2 = new OrderProducts();
        orderProduct1.setOrderId(8);
        orderProduct1.setProductId(1);
        orderProduct1.setOrderNumber(25);
        orderProduct1.setCategoryId(1);
        orderProduct1.setPrice(100f);
        orderProduct1.setQuantity(50);
        orderProduct1.setDiscount(1f);
        orderProduct1.setTotal(10);
        orderProduct1.setSkuid("AA");
        orderProduct1.setSize("M");
        orderProduct1.setColor("Red");

        orderProduct2.setOrderId(8);
        orderProduct2.setProductId(1);
        orderProduct2.setOrderNumber(25);
        orderProduct2.setCategoryId(1);
        orderProduct2.setPrice(100f);
        orderProduct2.setQuantity(50);
        orderProduct2.setDiscount(1f);
        orderProduct2.setTotal(10);
        orderProduct2.setSkuid("AA");
        orderProduct2.setSize("M");
        orderProduct2.setColor("Red");
        orderProductsList.add(orderProduct1);
        orderProductsList.add(orderProduct2);
        order.setOrderProductsList(orderProductsList);

        List<ProductQuantity> productQuantityList = new ArrayList<>();
        ProductQuantity productQuantity1 = new ProductQuantity();
        ProductQuantity productQuantity2 = new ProductQuantity();

        productQuantity1.setId(1);
        productQuantity1.setProductId(1);
        productQuantity1.setQuantity(5);

        productQuantity2.setId(1);
        productQuantity2.setProductId(1);
        productQuantity2.setQuantity(5);

        productQuantityList.add(productQuantity1);
        productQuantityList.add(productQuantity2);

        given(commonGatewayRepository.createOrder(order.getCustomerId(), order)).willReturn(order);

        //given(commonGatewayRepository.updateProductQuantity(productQuantityList)).willReturn("UpdatedProductQuantity");
        assertEquals("UpdatedProductQuantity",given(commonGatewayRepository.updateProductQuantity(productQuantityList)).willReturn("UpdatedProductQuantity"));



    }
}
