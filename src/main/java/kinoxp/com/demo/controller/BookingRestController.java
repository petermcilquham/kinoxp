package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
public class BookingRestController {

    @Autowired
    BookingsRepository bookingsRepository;

    //create booking
    @PostMapping(value="/booking/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingsEntity postBooking(@RequestBody BookingsEntity booking) {
        return bookingsRepository.save(booking);
    }

    //find booking by phone number
    @GetMapping("/booking/search/{phoneNum}")
    public BookingsEntity findBooking(@PathVariable Integer phoneNum) {
        return bookingsRepository.searchBooking(phoneNum);
    }

    //search booking by phone number method with error handling
//    @GetMapping("/booking/search/{phoneNum}")
//    public ResponseEntity<BookingsEntity> findBooking(@PathVariable Integer phoneNum){
//        Optional<BookingsEntity> booking = bookingsRepository.searchBooking(phoneNum);
//        if(booking.isPresent()){
//            BookingsEntity realBooking = booking.get();
//            return new ResponseEntity<>(realBooking, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

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

}
