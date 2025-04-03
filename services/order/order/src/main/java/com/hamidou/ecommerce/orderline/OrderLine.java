package com.hamidou.ecommerce.orderline;

import com.hamidou.ecommerce.order.Order;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Builder
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer poductId;

    private double quantity;

}
