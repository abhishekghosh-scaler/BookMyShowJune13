package com.scaler.bookmyshowjune13.repositories;

import com.scaler.bookmyshowjune13.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long>
{
    @Override
    Optional<Show> findById(Long aLong);
}
