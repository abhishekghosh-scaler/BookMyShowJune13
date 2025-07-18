package com.scaler.bookmyshowjune13.repositories;

import com.scaler.bookmyshowjune13.models.Show;
import com.scaler.bookmyshowjune13.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long>
{
    List<ShowSeatType> findAllByShow(Show show);
}
