package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.model.ShowsEntity;
import kinoxp.com.demo.repositories.BookingsRepository;
import kinoxp.com.demo.repositories.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class ShowRestController {

    @Autowired
    ShowsRepository showsRepository;

    @PostMapping(value="/show/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowsEntity postShow(@RequestBody ShowsEntity show) {
        return showsRepository.save (show);
    }

    @GetMapping("/show/title")
    public List<ShowsEntity> findShowByTitle() {
        String title = "Jaws 9";
        return showsRepository.findShowByTitle(title);
    }

    @GetMapping("/show/all")
    public List<ShowsEntity> allShows() {
        return showsRepository.findAll();
    }

    @GetMapping("/show/genre")
    public List<ShowsEntity> findShowByGenre(WebRequest wr) {
        String genre = "Horror";
        return showsRepository.findShowByGenre(genre);
    }

}
