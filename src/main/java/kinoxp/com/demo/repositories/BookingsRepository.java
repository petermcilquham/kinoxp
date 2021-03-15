package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.BookingsEntity;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingsRepository extends JpaRepository<BookingsEntity, Integer> {

    //find booking by customer name or phone number
    @Query("FROM BookingsEntity WHERE customerName = ?1 OR customerMobileNumber = ?2")
    BookingsEntity searchBooking(String customerName, int customerMobileNumber);

    //edit seat number in booking by id
    @Query("UPDATE BookingsEntity SET seatNum01 = ?1 WHERE bookingId = ?2")
    BookingsEntity editBooking(int newSeat, int bookingId);

    //delete booking with id
    @Query("DELETE FROM BookingsEntity WHERE bookingId = ?1")
    BookingsEntity deleteBooking(int bookingId);
}
