package com.scaler.bookmyshowjune13.services;

import com.scaler.bookmyshowjune13.models.Show;
import com.scaler.bookmyshowjune13.models.ShowSeat;
import com.scaler.bookmyshowjune13.models.ShowSeatType;
import com.scaler.bookmyshowjune13.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorServiceImpl implements PriceCalculatorService
{
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorServiceImpl(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    @Override
    public double calculateAmount(List<ShowSeat> showSeats, Show show)
    {
        double amount = 0;

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        for(ShowSeat showSeat : showSeats)
        {
            for(ShowSeatType showSeatType: showSeatTypes)
            {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType()))
                {
                    amount += showSeatType.getPrice();
                }
            }
        }
        return amount;
    }
}
