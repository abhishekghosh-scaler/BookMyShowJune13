package com.scaler.bookmyshowjune13.services;

import com.scaler.bookmyshowjune13.models.*;
import com.scaler.bookmyshowjune13.repositories.BookingRepository;
import com.scaler.bookmyshowjune13.repositories.ShowRepository;
import com.scaler.bookmyshowjune13.repositories.ShowSeatRepository;
import com.scaler.bookmyshowjune13.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService
{
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final PriceCalculatorService priceCalculatorService;

    public BookingServiceImpl(UserRepository userRepository,
                              BookingRepository bookingRepository,
                              ShowRepository showRepository,
                              ShowSeatRepository showSeatRepository,
                              PriceCalculatorService priceCalculatorService)
    {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(List<Long> showSeatIds, Long userId, Long showId)
    {
//        * 1. Get the Show details using showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty())
        {
            throw new RuntimeException("Show not found");
        }

        Show bookedShow = showOptional.get();

//        * 2. Get the User details using userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty())
        {
            throw new RuntimeException("User not found");
        }
        User bookedBy = userOptional.get();

//        * ------ Take the lock ------
//        * 3. Get the ShowSeat using list of showSeatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

//        * 4. Check if the Show seats are available
        for(ShowSeat showSeat : showSeats)
        {
            if(!(showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)))
            {
                if(Duration.between(showSeat.getBlockedAt().toInstant(),
                        new Date().toInstant()).toMinutes() > 15)
                {
                    throw new RuntimeException("Blocked seats should be released");
                }
//        * 5. If not, throw an exception
                throw new RuntimeException("Show seat already booked");
            }
        }

//        * 6. If yes, we change the status to Locked/Blocked
        for(ShowSeat showSeat : showSeats)
        {
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
//        * 7. Save the details to DB
            showSeatRepository.save(showSeat);
        }
//        * ------ Release the lock ------
//        * 8. Create the Booking object
        Booking booking = new Booking();
        booking.setUser(bookedBy);
        booking.setBookedAt(new Date());
        booking.setSeats(showSeats);
        booking.setStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculatorService.calculateAmount(showSeats, bookedShow));

//        * 9. Save and return the Booking object created
        return bookingRepository.save(booking);
    }
}
