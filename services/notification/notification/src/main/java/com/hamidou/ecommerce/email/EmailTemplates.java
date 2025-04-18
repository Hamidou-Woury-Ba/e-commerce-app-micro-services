package com.hamidou.ecommerce.email;

import lombok.Getter;

//Enumération qui permet de centraliser les informations des templates d'email.
public enum EmailTemplates {

    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),

    ORDER_CONFIRMATION("order-confirmation.html", "Order successfully processed");

    @Getter
    private final String template;

    @Getter
    private final String subject;

    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
