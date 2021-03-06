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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @PutMapping("/booking/edit")
    public ResponseEntity<BookingsEntity> editBooking(@Valid @RequestBody BookingsEntity booking) throws ResourceNotFoundException {
        BookingsEntity bookingsEntity = bookingRepository.findById(booking.getBookingId()).orElseThrow(() -> new ResourceNotFoundException("error"));

        if(booking.getCustomerName() != null){
            bookingsEntity.setCustomerName(booking.getCustomerName());
        }

        if(booking.getCustomerMobileNumber() != null){
            bookingsEntity.setCustomerMobileNumber(booking.getCustomerMobileNumber());
        }
        if(booking.getShowId() != 0){
            bookingsEntity.setShowId(booking.getShowId());
        }

        if(booking.getSeatNum01() != 0){
            bookingsEntity.setSeatNum01(booking.getSeatNum01());
        }
        if(booking.getSeatNum02() != null){
            bookingsEntity.setSeatNum02(booking.getSeatNum02());
        }
        if(booking.getSeatNum03() != null){
            bookingsEntity.setSeatNum03(booking.getSeatNum03());
        }
        if(booking.getSeatNum04() != null){
            bookingsEntity.setSeatNum04(booking.getSeatNum04());
        }
        if(booking.getSeatNum05() != null){
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

    //find booking by show id
    @GetMapping("/booking/showid/{showId}")
    public List<BookingsEntity> findBookingByShowId(@PathVariable Integer showId) {
        return bookingRepository.findBookingByShowId(showId);
    }

    @GetMapping("/bookings/seats/{showId}")
    public List<Integer> findSeatsByShowId(@PathVariable Integer showId){
        List<Integer> list1 = bookingRepository.findSeats1(showId);
        List<Integer> list2 = bookingRepository.findSeats2(showId);
        List<Integer> list3 = bookingRepository.findSeats3(showId);
        List<Integer> list4 = bookingRepository.findSeats4(showId);
        List<Integer> list5 = bookingRepository.findSeats5(showId);
        return Stream.of(list1, list2, list3,list4,list5)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
