package vznd.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = new ChromeDriver(getChromeOptions());
    }

    @AfterMethod
    public void tearDown() {
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
