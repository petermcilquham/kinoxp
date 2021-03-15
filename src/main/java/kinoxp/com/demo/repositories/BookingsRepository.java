package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.BookingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingsRepository extends JpaRepository<BookingsEntity, Integer> {

    @Query("FROM BookingsEntity WHERE bookingId = ?1")
    List<BookingsEntity> findBookingByID(int bookingId);
}
