package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.model.ShowsEntity;
import kinoxp.com.demo.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class BookingRestController {

    @Autowired
    BookingsRepository bookingsRepository;

    //see all bookings
    @GetMapping("/booking/all")
    public List<BookingsEntity> findAll() {
        return bookingsRepository.findAll();
    }

    //create booking
    @PostMapping(value="/booking/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingsEntity postBooking(@RequestBody BookingsEntity booking) {
        return bookingsRepository.save(booking);
    }

    //edit booking
    @PutMapping("/booking/edit")
    public BookingsEntity editBooking(@RequestBody BookingsEntity booking) {
        return bookingsRepository.save(booking);
    }

    //delete booking
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/booking/delete/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        try{
            bookingsRepository.deleteBooking(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }

    //find booking by phone number
    @GetMapping("/booking/search/{phoneNum}")
    public BookingsEntity findBooking(@PathVariable Integer phoneNum) {
        return bookingsRepository.searchBooking(phoneNum);
    }

}
