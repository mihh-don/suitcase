package hello;

import org.springframework.boot.actuate.health.ShowDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }
}
