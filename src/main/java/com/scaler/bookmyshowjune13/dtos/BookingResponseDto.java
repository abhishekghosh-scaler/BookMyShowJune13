package com.scaler.bookmyshowjune13.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto
{
    private ResponseStatus status;
    private Long bookingId;
    private int amount;
    private String failureMessage;
}
