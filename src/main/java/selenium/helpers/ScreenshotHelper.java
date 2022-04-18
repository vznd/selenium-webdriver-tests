package selenium.helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    public static String SCREENSHOTS_DIR = System.getProperty("user.dir")
            + File.separator + "target" + File.separator + "screenshots" + File.separator;

    public static void takeScreenshot(WebDriver driver, String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(SCREENSHOTS_DIR + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
