package com.scaler.bookmyshowjune13.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel
{
    @ManyToOne
    private Show show;

    @OneToOne
    private SeatType seatType;
    private double price;
}
