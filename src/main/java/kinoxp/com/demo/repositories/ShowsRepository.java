package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.model.ShowsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ShowsRepository extends JpaRepository<ShowsEntity, Integer> {

    //find movie by title
    @Query("FROM ShowsEntity WHERE movieTitle = ?1")
    List<ShowsEntity> findShowByTitle(String movieTitle);

    //find movie by genre
    @Query("FROM ShowsEntity WHERE genre = ?1")
    List<ShowsEntity> findShowByGenre(String genre);

    //delete movie by id
    @Query("DELETE FROM ShowsEntity WHERE showId = ?1")
    ShowsEntity deleteShow(int showId);

    //edit a movie's hall, date and start time by id
    @Query("UPDATE ShowsEntity SET cinemaHall = ?1, date = ?2, startTime = ?3 WHERE showId = ?4")
    ShowsEntity editBooking(int newCinemaHall, Date newDate, Time newStartTime, int showId);
}