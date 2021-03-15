package kinoxp.com.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(value = "*")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
