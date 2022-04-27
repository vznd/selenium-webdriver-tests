package vznd.selenium;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActionsController {

	@GetMapping("/click-and-hold")
	public String clickAndHold() {
		return "click-and-hold";
	}

	@GetMapping("/context-click")
	public String contextClick() {
		return "context-click";
	}

	@GetMapping("/double-click")
	public String doubleClick() {
		return "double-click";
	}

	@GetMapping("/keyboard")
	public String keyboard() {
		return "keyboard";
	}

	@GetMapping("/move-to-element")
	public String moveToElement() {
		return "move-to-element";
	}

}
