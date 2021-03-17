package kinoxp.com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@CrossOrigin(value = "*")
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin () {
        return "admin";
    }

    @PostMapping("/admin/addshift")
    public String addShift(WebRequest wr) {
        String employeeName = wr.getParameter("employeeName");
        String workDate = wr.getParameter("WorkDate");
        String startHour = wr.getParameter("StartHour");
        String endHour = wr.getParameter("EndHour");
        System.out.println(employeeName + workDate + startHour + endHour);
        return "admin";
    }

    @GetMapping("/movie")
    public String movie() {
        return "movie";
    }

    @PostMapping("/shows/booking")
    public String booking(WebRequest wr){
        String customerName = wr.getParameter("customerName");
        String customerNumber = wr.getParameter("customerNumber");
        String seat = wr.getParameter("seat");
        String movieId = wr.getParameter("showId");
        System.out.println(movieId);
        return "redirect:localhost:8080/movie";
    }
}
