package com.scaler.bookmyshowjune13;

import com.scaler.bookmyshowjune13.controllers.UserController;
import com.scaler.bookmyshowjune13.dtos.SignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowJune13Application implements CommandLineRunner
{
    @Autowired
    UserController userController;

    @Override
    public void run(String... args) throws Exception
    {
//        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
//        signUpRequestDto.setEmail("testemail6@scaler.com");
//        signUpRequestDto.setPassword("password");
//
//        userController.registerUser(signUpRequestDto);

        userController.login("testemail6@scaler.com", "password");
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowJune13Application.class, args);
    }

}
