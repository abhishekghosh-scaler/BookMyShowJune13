package com.scaler.bookmyshowjune13.controllers;

import com.scaler.bookmyshowjune13.dtos.BookingRequestDto;
import com.scaler.bookmyshowjune13.dtos.BookingResponseDto;
import com.scaler.bookmyshowjune13.dtos.ResponseStatus;
import com.scaler.bookmyshowjune13.models.Booking;
import com.scaler.bookmyshowjune13.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController
{
    private final BookingService bookingService;

    public BookingController(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }

    public BookingResponseDto bookMovie(BookingRequestDto bookingRequestDto)
    {
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        try
        {
            Booking booking = bookingService.bookMovie(
                    bookingRequestDto.getShowSeatIds(),
                    bookingRequestDto.getUserId(),
                    bookingRequestDto.getShowId()
            );

            bookingResponseDto.setStatus(ResponseStatus.SUCCESS);
            bookingResponseDto.setBookingId(booking.getId());
        }catch(Exception e)
        {
            bookingResponseDto.setStatus(ResponseStatus.FAILURE);
            bookingResponseDto.setFailureMessage(e.getMessage());
        }
        return bookingResponseDto;
    }
}
