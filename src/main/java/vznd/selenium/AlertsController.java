package vznd.selenium;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlertsController {

    @GetMapping("/alert-with-redirect")
    public String alertWithRedirect() {
        return "alert-with-redirect";
    }

    @GetMapping("/simple-alert")
    public String simpleAlert() {
        return "simple-alert";
    }

    @GetMapping("/prompt")
    public String prompt() {
        return "prompt";
    }

}
