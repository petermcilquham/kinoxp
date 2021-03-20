package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.ShowsEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowRepository extends JpaRepository<ShowsEntity, Integer> {

    //find all show sorted by date
    @Query("FROM ShowsEntity")
    List<ShowsEntity> findAllSorted(Sort sort);

    //find show by title
    @Query("FROM ShowsEntity WHERE movieTitle like %?1%")
    List<ShowsEntity> findShowByTitle(String movieTitle);

    //show show by id
    @Query("FROM ShowsEntity WHERE showId = ?1")
    ShowsEntity showMovieById(int showId);

    //find show by genre
    @Query("FROM ShowsEntity WHERE genre like %?1%")
    List<ShowsEntity> findShowByGenre(String genre);

    //find show by id
    @Query("from ShowsEntity where showId = ?1")
    ShowsEntity findByIdCustom(int id);

}
