package com.scaler.bookmyshowjune13.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto
{
    private ResponseStatus status;
    private long userId;
    private String failureMessage;
}
