package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.ShowsEntity;
import kinoxp.com.demo.repositories.ShowRepository;
import kinoxp.com.demo.service.FilterShowsByDate;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ShowRestController {
    FilterShowsByDate filterShowsByDate = new FilterShowsByDate();

    @Autowired
    ShowRepository showRepository;

    //see all shows
    @GetMapping("/shows/all")
    public List<ShowsEntity> findAllSorted() {
        return showRepository.findAllSorted(Sort.by("date"));
    }
    //see shows before 3 months
    @GetMapping("/shows/filtered")
    public List<ShowsEntity> findFiltered() {
        List<ShowsEntity> temp = showRepository.findAllSorted(Sort.by("date"));
        return filterShowsByDate.returnFilteredShowList(temp);
    }

    //create show
    @PostMapping(value="/shows/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowsEntity postShow(@RequestBody ShowsEntity show) {
        return showRepository.save(show);
    }

    //edit show
    @PutMapping("/shows/edit/{id}")
    public ResponseEntity<ShowsEntity> editShow(@PathVariable(value="id") Integer id, @Valid @RequestBody ShowsEntity show) throws ResourceNotFoundException {
        ShowsEntity showsEntity = showRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("error"));

        if(show.getMovieTitle() != null){
            showsEntity.setMovieTitle(show.getMovieTitle());
        }
        if(show.getCinemaHall() != 0){
            showsEntity.setCinemaHall(show.getCinemaHall());
        }
        if(show.getDate() != null){
            showsEntity.setDate(show.getDate());
        }
        if(show.getStartTime() != null){
            showsEntity.setStartTime(show.getStartTime());
        }
        if(show.getDuration() != null){
            showsEntity.setDuration(show.getDuration());
        }
        if(show.getGenre() != null){
            showsEntity.setGenre(show.getGenre());
        }
        if(show.getAgeReq() != null){
            showsEntity.setAgeReq(show.getAgeReq());
        }
        if(show.getStars() != null){
            showsEntity.setStars(show.getStars());
        }

        final ShowsEntity updatedShowsEntity = showRepository.save(showsEntity);
        return ResponseEntity.ok(updatedShowsEntity);
    }

    //delete show
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/shows/delete/{id}")
    public void deleteShow(@PathVariable Integer id){
        try{
            showRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }

    //find show by title
    @GetMapping("/showtitle/{title}")
    public List<ShowsEntity> findShowByTitle(@PathVariable String title) {
        return showRepository.findShowByTitle(title);
    }

    //find show by genre
    @GetMapping("/showgenre/{genre}")
    public List<ShowsEntity> findShowByGenre(@PathVariable String genre) {
        return showRepository.findShowByGenre(genre);
    }

    //find show by id
    @GetMapping("/showid/{id}")
    public List<ShowsEntity> findById(@PathVariable int id) {
        return showRepository.findById(id);
    }

}
