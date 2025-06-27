package com.scaler.bookmyshowjune13.repositories;

import com.scaler.bookmyshowjune13.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}
