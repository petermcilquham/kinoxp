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

    //find seat numbers
    @Query("select seatNum01 from BookingsEntity where showId = ?1")
    List<Integer> findSeats1(int id);
    @Query("select seatNum02 from BookingsEntity where seatNum02 is not null and showId = ?1")
    List<Integer> findSeats2(int id);
    @Query("select seatNum03 from BookingsEntity where seatNum03 is not null and showId = ?1")
    List<Integer> findSeats3(int id);
    @Query("select seatNum04 from BookingsEntity where seatNum04 is not null and showId = ?1")
    List<Integer> findSeats4(int id);
    @Query("select seatNum05 from BookingsEntity where seatNum05 is not null and showId = ?1")
    List<Integer> findSeats5(int id);
}
