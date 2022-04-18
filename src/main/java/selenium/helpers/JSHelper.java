package selenium.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSHelper {

    public static void displaySimpleAlert(WebDriver driver, String alertText) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "alert(\"" + alertText + "\");";
        js.executeScript(script);
    }

    public static void displayAlertWithRedirectOnAccept(WebDriver driver, String alertText, String redirectUrl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "if (confirm('" + alertText + "')) {\n"
                + "  window.location.replace(\"" + redirectUrl + "\");\n"
                + "} else {\n"
                + "  console.log('Thing was not saved to the database.');\n"
                + "}";

        js.executeScript(script);
    }

    public static void displayPromptWithRedirect(WebDriver driver, String question, String answer, String redirectUrl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "let result = prompt(\"" + question + "\");\n"
                + "\n"
                + "if (result.toLowerCase() == \"" + answer + "\") {\n"
                + "  window.location.replace(\"" + redirectUrl + "\");\n"
                + "}";
        js.executeScript(script);
    }

}
