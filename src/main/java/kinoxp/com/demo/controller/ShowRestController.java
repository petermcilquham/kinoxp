package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.ShowsEntity;
import kinoxp.com.demo.repositories.ShowsRepository;
import kinoxp.com.demo.service.FilterShowsByDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
public class ShowRestController {
    FilterShowsByDate filterShowsByDate = new FilterShowsByDate();

    @Autowired
    ShowsRepository showsRepository;

    //see all shows
    @GetMapping("/shows/all")
    public List<ShowsEntity> findAllSorted() {
        return showsRepository.findAllSorted(Sort.by("date"));
    }
    //see shows before 3 months
    @GetMapping("/shows/filtered")
    public List<ShowsEntity> findFiltered() {
        List<ShowsEntity> temp = showsRepository.findAllSorted(Sort.by("date"));
        return filterShowsByDate.returnFilteredShowList(temp);
    }

    //create show
    @PostMapping(value="/shows/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowsEntity postShow(@RequestBody ShowsEntity show) {
        return showsRepository.save(show);
    }

    //edit show
    @PutMapping("/shows/edit")
    public ShowsEntity editShow(@RequestBody ShowsEntity show){
        ShowsEntity newShow = showsRepository.findById(show.getShowId());

        if(show.getMovieTitle().length() > 2){
            newShow.setMovieTitle(show.getMovieTitle());
        }
        if(show.getCinemaHall() != 0){
            newShow.setCinemaHall(show.getCinemaHall());
        }
        if(show.getDate() != null){
            newShow.setDate(show.getDate());
        }
        if(show.getGenre().length() > 2){
            newShow.setGenre(show.getGenre());
        }
        if(show.getAgeReq() != null){
            newShow.setAgeReq(show.getAgeReq());
        }
        if(show.getStars().length() > 2){
            newShow.setStars(show.getStars());
        }

        return showsRepository.save(newShow);
    }

    //delete show
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/shows/delete/{id}")
    public void deleteShow(@PathVariable Integer id){
        try{
            showsRepository.deleteShow(id);
        } catch(EmptyResultDataAccessException e) {
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }

    //find show by title
    @GetMapping("/showtitle/{title}")
    public List<ShowsEntity> findShowByTitle(@PathVariable String title) {
        return showsRepository.findShowByTitle(title);
    }

    //find show by genre
    @GetMapping("/showgenre/{genre}")
    public List<ShowsEntity> findShowByGenre(@PathVariable String genre) {
        return showsRepository.findShowByGenre(genre);
    }

    //find show by id
    @GetMapping("/showid/{id}")
    public ShowsEntity findById(@PathVariable int id) {
        return showsRepository.findById(id);
    }

}
