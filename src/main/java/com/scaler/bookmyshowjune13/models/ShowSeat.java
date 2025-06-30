package com.scaler.bookmyshowjune13.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel
{
    @ManyToOne
    private Show show;

    @OneToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus status;

    private Date blockedAt;
}
