package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.ShowsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowsRepository extends JpaRepository<ShowsEntity, Integer> {

    @Query("FROM ShowsEntity WHERE movieTitle = ?1")
    List<ShowsEntity> findShowByTitle(String movieTitle);

    @Query("FROM ShowsEntity WHERE genre = ?1")
    List<ShowsEntity> findShowByGenre(String genre);
}
