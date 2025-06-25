package com.scaler.bookmyshowjune13.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel
{
    @ManyToOne
    private User user;
    private Date bookedAt;
    private double amount;

    @ManyToMany
    private List<ShowSeat> seats;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;

    @OneToMany
    private List<Payment> payments;
}
