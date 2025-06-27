package com.scaler.bookmyshowjune13.repositories;

import com.scaler.bookmyshowjune13.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>
{
}
