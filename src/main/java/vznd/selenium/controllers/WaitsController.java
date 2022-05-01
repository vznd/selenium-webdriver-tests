package vznd.selenium.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WaitsController {

    @GetMapping("/implicit-wait")
    public String implicitWait() {
        return "implicit-wait";
    }

    @GetMapping("/fluent-wait")
    public String fluentWait() {
        return "fluent-wait";
    }

}
