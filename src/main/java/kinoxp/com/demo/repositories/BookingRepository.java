package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.BookingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingsEntity, Integer> {

    //find booking by customer mobile number
    @Query("FROM BookingsEntity WHERE customerMobileNumber like %?1%")
    List<BookingsEntity> searchBooking(String customerMobileNumber);

    //find booking by id
    @Query("FROM BookingsEntity WHERE bookingId = ?1")
    BookingsEntity printBooking(int id);

    //find booking by show id
    @Query("FROM BookingsEntity WHERE showId = ?1")
    List<BookingsEntity> findBookingByShowId(int id);

//    @Query("from BookingsEntity join ShowsEntity on showId = showId")
//    List<BookingsEntity> findX();

    @Query("select seatNum01 from BookingsEntity")
    List<Integer> findSeats1();
    @Query("select seatNum02 from BookingsEntity where seatNum02 is not null")
    List<Integer> findSeats2();
    @Query("select seatNum03 from BookingsEntity where seatNum03 is not null")
    List<Integer> findSeats3();
    @Query("select seatNum04 from BookingsEntity where seatNum04 is not null")
    List<Integer> findSeats4();
    @Query("select seatNum05 from BookingsEntity where seatNum05 is not null")
    List<Integer> findSeats5();
}
