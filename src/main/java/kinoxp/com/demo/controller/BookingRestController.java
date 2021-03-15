package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingRestController {

    @Autowired
    BookingsRepository bookingsRepository;

    @GetMapping("/booking/id")
    public List<BookingsEntity> findBookingByID() {
        return bookingsRepository.findBookingByID(2);
    }
}
