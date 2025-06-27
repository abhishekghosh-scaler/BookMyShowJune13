package com.scaler.bookmyshowjune13.services;

import com.scaler.bookmyshowjune13.models.Booking;
import com.scaler.bookmyshowjune13.repositories.BookingRepository;
import com.scaler.bookmyshowjune13.repositories.ShowRepository;
import com.scaler.bookmyshowjune13.repositories.ShowSeatRepository;
import com.scaler.bookmyshowjune13.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService
{
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;

    public BookingServiceImpl(UserRepository userRepository,
                              BookingRepository bookingRepository,
                              ShowRepository showRepository,
                              ShowSeatRepository showSeatRepository)
    {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(List<Long> showSeatIds, Long userId, Long showId)
    {
        /*
        * 1. Get the Show details using showId
        * 2. Get the User details using userId
        * ------ Take the lock ------
        * 3. Get the ShowSeat using list of showSeatIds
        * 4. Check if the Show seats are available
        * 5. If not, throw an exception
        * 6. If yes, we change the status to Locked/Blocked
        * 7. Save the details to DB
        * ------ Release the lock ------
        * 8. Create the Booking object
        * 9. Save and return the Booking object created
        * */
        return null;
    }
}
