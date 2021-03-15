package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.QueryCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
public class BookingRestController {

    @Autowired
    BookingsRepository bookingsRepository;

    @PostMapping(value="/booking/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingsEntity postBooking(@RequestBody BookingsEntity booking) {
        return bookingsRepository.save (booking);
    }

    @GetMapping("/booking/search")
    public BookingsEntity findBooking() {
        String name = "Adam";
        int number = 0;
        return bookingsRepository.searchBooking(name,number);
    }

    @GetMapping("/booking/edit")
    public BookingsEntity editBooking() {
        int newSeat = 505;
        int bookingId = 2;
        return bookingsRepository.editBooking(newSeat, bookingId);
    }

    @GetMapping("/booking/delete")
    public String deleteBooking() throws QueryCreationException {
        int bookingId = 2;
        bookingsRepository.deleteBooking(bookingId);
        return "index";
    }
}
