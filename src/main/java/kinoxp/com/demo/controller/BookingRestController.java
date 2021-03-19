package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.repositories.BookingRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class BookingRestController {

    @Autowired
    BookingRepository bookingRepository;

    //see all bookings
    @GetMapping("/booking/all")
    public List<BookingsEntity> findAll() {
        return bookingRepository.findAll();
    }

    //create booking
    @PostMapping(value="/booking/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingsEntity postBooking(@RequestBody BookingsEntity booking) {
        return bookingRepository.save(booking);
    }

    //edit booking
    @PutMapping("/booking/edit/{id}")
    public ResponseEntity<BookingsEntity> editBooking(@PathVariable(value="id") Integer id, @Valid @RequestBody BookingsEntity booking) throws ResourceNotFoundException {
        BookingsEntity bookingsEntity = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("error"));

        if(booking.getCustomerName() != null){
            bookingsEntity.setCustomerName(booking.getCustomerName());
        }
        if(booking.getCustomerMobileNumber() != null){
            bookingsEntity.setCustomerMobileNumber(booking.getCustomerMobileNumber());
        }
        if(booking.getShowId() != 0){
            bookingsEntity.setShowId(booking.getShowId());
        }
        if(booking.getCinemaHallId() != 0){
            bookingsEntity.setCinemaHallId(booking.getCinemaHallId());
        }
        if(booking.getSeatNum01() != 0){
            bookingsEntity.setSeatNum01(booking.getSeatNum01());
        }
        if(booking.getSeatNum02() != 0){
            bookingsEntity.setSeatNum02(booking.getSeatNum02());
        }
        if(booking.getSeatNum03() != 0){
            bookingsEntity.setSeatNum03(booking.getSeatNum03());
        }
        if(booking.getSeatNum04() != 0){
            bookingsEntity.setSeatNum04(booking.getSeatNum04());
        }
        if(booking.getSeatNum05() != 0){
            bookingsEntity.setSeatNum05(booking.getSeatNum05());
        }

        final BookingsEntity updatedBookingEntity = bookingRepository.save(bookingsEntity);
        return ResponseEntity.ok(updatedBookingEntity);
    }

    //delete booking
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/booking/delete/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        try{
            bookingRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }

    //find booking by phone number
    @GetMapping("/booking/search/{phoneNum}")
    public List<BookingsEntity> findBooking(@PathVariable String phoneNum) {
        return bookingRepository.searchBooking(phoneNum);
    }

    //find booking by id, for print booking
    @GetMapping("/booking/print/{id}")
    public BookingsEntity printBooking(@PathVariable Integer id) {
        return bookingRepository.printBooking(id);
    }

}
