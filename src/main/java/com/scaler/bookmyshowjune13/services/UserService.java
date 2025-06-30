package com.scaler.bookmyshowjune13.services;

import com.scaler.bookmyshowjune13.models.User;

public interface UserService
{
    User registerUser(String email, String password);
    User login(String email, String password);
}
