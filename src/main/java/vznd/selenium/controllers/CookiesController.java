package vznd.selenium.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookiesController {

    @GetMapping("/cookies")
    public String cookies() {
        return "cookies";
    }
}
