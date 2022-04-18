package selenium.chapters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowsersTest {

    public String environment;
    public WebDriver driver;
    public String url;

    @BeforeTest
    public void preCondition() {
        environment = System.getenv("WIKI_ENV") == null ? "LOCAL" : System.getenv("WIKI_ENV");
        url = "https://google.com";
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        if(environment.equals("CIRCLE_CI")) {
            options = new ChromeOptions()
                    .addArguments("--disable-dev-shm-usage")
                    .addArguments("--headless")
                    .addArguments("--no-sandbox");
        }
        driver = new ChromeDriver(options);
        driver.get(url);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, url, "The URL did not match!");
    }

    @Test // COMING SOON
    public void openEdgeBrowser() {
        /*
        1) Initialize options
        2) Initialize driver
        3) Open url
        4) Get current url
        5) Assert current url match expected
         */
    }

    @Test // COMING SOON
    public void openFirefoxBrowser() {
        /*
        1) Initialize options
        2) Initialize driver
        3) Open url
        4) Get current url
        5) Assert current url match expected
         */
    }

    @Test // COMING SOON
    public void openInternetExplorerBrowser() {
        /*
        1) Initialize options
        2) Initialize driver
        3) Open url
        4) Get current url
        5) Assert current url match expected
         */
    }

    @Test // COMING SOON
    public void openOperaBrowser() {
        /*
        1) Initialize options
        2) Initialize driver
        3) Open url
        4) Get current url
        5) Assert current url match expected
         */
    }

    @Test // COMING SOON
    public void openSafariBrowser() {
        /*
        1) Initialize options
        2) Initialize driver
        3) Open url
        4) Get current url
        5) Assert current url match expected
         */
    }

}
