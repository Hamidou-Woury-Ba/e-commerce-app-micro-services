package com.hamidou.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record CustomerRequest(

        String id,

        @NotNull(message = "Customer firstname is required")
        String firstname,

        @NotNull(message = "Customer lastname is required")
        String lastname,

        @Email(message = "Customer email is not a valid email address")
        String email,

        Address address
) {


}
