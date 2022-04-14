package wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public String username;
    public String password;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver(getChromeOptions());
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        username = "Username12340";
        password = "Qazxc123";
    }

    @AfterMethod
    public void closeDriver() {
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
