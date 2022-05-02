package vznd.selenium.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ElementsController {

    @GetMapping("/finders")
    public String finders() {
        return "elements-finders";
    }

    @GetMapping("/information")
    public String information() {
        return "elements-information";
    }

    @GetMapping("/interactions")
    public String interactions() {
        return "elements-interactions";
    }

    @GetMapping("/select-lists")
    public String selectLists() {
        return "elements-select-lists";
    }

    @GetMapping("/traditional-locators")
    public String traditionalLocators() {
        return "elements-traditional-locators";
    }

}
