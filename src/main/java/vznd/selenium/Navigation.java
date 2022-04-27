package vznd.selenium;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Navigation {

    @GetMapping("/navigation")
    public String navigation() {
        return "navigation";
    }

}
