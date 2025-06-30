package com.scaler.bookmyshowjune13.services;

import com.scaler.bookmyshowjune13.models.Show;
import com.scaler.bookmyshowjune13.models.ShowSeat;

import java.util.List;

public interface PriceCalculatorService
{
    double calculateAmount(List<ShowSeat> showSeats, Show show);
}
