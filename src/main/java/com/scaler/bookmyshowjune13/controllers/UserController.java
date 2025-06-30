package com.scaler.bookmyshowjune13.controllers;

import com.scaler.bookmyshowjune13.dtos.ResponseStatus;
import com.scaler.bookmyshowjune13.dtos.SignUpRequestDto;
import com.scaler.bookmyshowjune13.dtos.SignUpResponseDto;
import com.scaler.bookmyshowjune13.models.User;
import com.scaler.bookmyshowjune13.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void login(String email, String password)
    {
        User user = userService.login(email, password);
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
    }

    public SignUpResponseDto registerUser(SignUpRequestDto signUpRequestDto)
    {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try {
            User user = userService.registerUser(
                    signUpRequestDto.getEmail(), signUpRequestDto.getPassword()
            );

            signUpResponseDto.setUserId(user.getId());
            signUpResponseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e)
        {
            signUpResponseDto.setStatus(ResponseStatus.FAILURE);
            signUpResponseDto.setFailureMessage(e.getMessage());
        }

        return signUpResponseDto;
    }
}
