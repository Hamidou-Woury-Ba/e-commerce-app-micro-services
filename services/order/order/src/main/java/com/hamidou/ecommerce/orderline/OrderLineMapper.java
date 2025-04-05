package com.hamidou.ecommerce.orderline;

import com.hamidou.ecommerce.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {


    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {

        return OrderLine.builder()
                .id(orderLineRequest.id())
                .order(
                        Order.builder()
                                .id(orderLineRequest.orderId())
                                .build()
                )
                .poductId(orderLineRequest.productId())
                .quantity(orderLineRequest.quantity())
                .build();

    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {

        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );

    }
}
