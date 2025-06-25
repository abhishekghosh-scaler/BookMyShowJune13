package com.scaler.bookmyshowjune13.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel
{
    @OneToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;

    @OneToOne
    private Movie movie;

    @OneToMany
    private List<ShowSeat> showSeats;

    @OneToMany
    private List<ShowSeatType> showSeatTypes;
}
