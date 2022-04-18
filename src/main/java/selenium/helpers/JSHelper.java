package selenium.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSHelper {

    public static void displayAlert(WebDriver driver, String alertText) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "alert(\"" + alertText + "\");";
        js.executeScript(script);
    }
}
