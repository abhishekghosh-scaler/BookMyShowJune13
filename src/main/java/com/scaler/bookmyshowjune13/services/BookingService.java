package com.scaler.bookmyshowjune13.services;

import com.scaler.bookmyshowjune13.models.Booking;

import java.util.List;

public interface BookingService
{
    Booking bookMovie(List<Long> showSeatIds, Long userId, Long showId);
}
