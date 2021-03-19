package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.BookingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingsRepository extends JpaRepository<BookingsEntity, Integer> {

    //find booking by customer mobile number
    @Query("FROM BookingsEntity WHERE customerMobileNumber like %?1%")
    List<BookingsEntity> searchBooking(String customerMobileNumber);

    //find booking by id
    @Query("FROM BookingsEntity WHERE bookingId = ?1")
    BookingsEntity printBooking(int id);

}
