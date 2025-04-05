package com.hamidou.ecommerce.kafka;

import com.hamidou.ecommerce.customer.CustomerResponse;
import com.hamidou.ecommerce.order.PaymentMethod;
import com.hamidou.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(

        String orderReference,

        BigDecimal totalAmount,

        PaymentMethod paymentMethod,

        CustomerResponse customer,

        List<PurchaseResponse> products

) {
}
