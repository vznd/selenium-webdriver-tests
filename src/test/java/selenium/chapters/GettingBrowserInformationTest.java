package selenium.chapters;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.BaseTest;

public class GettingBrowserInformationTest extends BaseTest {

    public String URL = "https://www.google.com/";

    @BeforeMethod
    public void openURL() {
        driver.get(URL);
    }

    @Test
    public void getTitle() {
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "The title was not correct!");
    }

    @Test
    public void getCurrentUrl() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, URL, "The URL was not correct!");
    }

}