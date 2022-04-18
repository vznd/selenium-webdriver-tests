package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import selenium.helpers.ScreenshotHelper;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver(getChromeOptions());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String fileName = result.getMethod().getTestClass().getName() + "." + result.getName() + ".jpg";
            ScreenshotHelper.takeScreenshot(driver, fileName);
        }
        driver.quit();
    }

    private ChromeOptions getChromeOptions() {
        if(getEnv().equals("CIRCLE_CI")) {
            return new ChromeOptions()
                    .addArguments("--disable-dev-shm-usage")
                    .addArguments("--headless")
                    .addArguments("--no-sandbox");
        }
        return new ChromeOptions();
    }

    private String getEnv() {
        String env = System.getenv("WIKI_ENV");
        return env == null ? "LOCAL" : env;
    }

}
