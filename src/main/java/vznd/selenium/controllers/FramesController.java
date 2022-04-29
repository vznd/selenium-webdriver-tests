package vznd.selenium.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FramesController {

    @GetMapping("/iframes")
    public String iframes() {
        return "iframes";
    }

    @GetMapping("/first-iframe")
    public String first() {
        return "first-iframe";
    }

    @GetMapping("/second-iframe")
    public String second() {
        return "second-iframe";
    }

}
