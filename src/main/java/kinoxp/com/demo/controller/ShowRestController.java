package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.ShowsEntity;
import kinoxp.com.demo.repositories.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ShowRestController {

    @Autowired
    ShowsRepository showsRepository;

    //create show
    @PostMapping(value="/shows/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowsEntity postShow(@RequestBody ShowsEntity show) {
        return showsRepository.save(show);
    }

    //see all shows
    @GetMapping("/shows/all")
    public List<ShowsEntity> findAllSorted() {
        return showsRepository.findAllSorted(Sort.by("date"));
    }

    //edit show
    @PutMapping("/shows/edit")
    public ShowsEntity editShow(@RequestBody ShowsEntity show){
        return showsRepository.save(show);
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

}
