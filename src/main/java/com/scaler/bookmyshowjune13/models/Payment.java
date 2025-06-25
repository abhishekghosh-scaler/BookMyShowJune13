package com.scaler.bookmyshowjune13.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel
{
    @ManyToOne
    private Booking booking;
    private double amount;
    private String refNumber;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentGateway gateway;
}

/*
* Payment: Booking = M : 1
* Booking   Payment
* 1            M
* 1            1
*
* */
