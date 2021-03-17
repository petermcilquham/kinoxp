package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.BookingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookingsRepository extends JpaRepository<BookingsEntity, Integer> {

    //find booking by customer name or phone number
    @Query("FROM BookingsEntity WHERE customerMobileNumber like %?1%")
    List<BookingsEntity> searchBooking(String customerMobileNumber);

    @Query("FROM BookingsEntity WHERE bookingId = ?1")
    BookingsEntity printBooking(int customerMobileNumber);

    //delete booking with id
    @Query("DELETE FROM BookingsEntity WHERE bookingId = ?1")
    BookingsEntity deleteBooking(int bookingId);

    //edit seat number in booking by id
//    @Query("UPDATE BookingsEntity SET seatNum01 = ?1 WHERE bookingId = ?2")
//    BookingsEntity editBooking(int newSeat, int bookingId);
}
