package kinoxp.com.demo.controller;

import kinoxp.com.demo.model.BookingsEntity;
import kinoxp.com.demo.model.ShowsEntity;
import kinoxp.com.demo.repositories.BookingsRepository;
import kinoxp.com.demo.repositories.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ShowRestController {

    @Autowired
    ShowsRepository showsRepository;

    @GetMapping("/show/{id}")
    public ResponseEntity<ShowsEntity> findShowById(@PathVariable Integer id) {
        Optional<ShowsEntity> tmpShow = showsRepository.findById(id);
        if (tmpShow.isPresent()) {
            ShowsEntity realShow = tmpShow.get();
            return new ResponseEntity<>(realShow, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/show/title")
    public List<ShowsEntity> findShowByTitle() {
        return showsRepository.findShowByTitle("Jaws 9");
    }

    @GetMapping("/show/all")
    public List<ShowsEntity> allShows() {
        return showsRepository.findAll();
    }

    @GetMapping("/show/genre")
    public List<ShowsEntity> findShowByGenre() {
        return showsRepository.findShowByGenre("Action");
    }

}
