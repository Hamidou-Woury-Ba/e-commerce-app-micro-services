package com.hamidou.ecommerce.payment;

import com.hamidou.ecommerce.customer.CustomerResponse;
import com.hamidou.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,

        PaymentMethod paymentMethod,

        Integer orderId,

        String orderReference,

        CustomerResponse customer

) {
}
