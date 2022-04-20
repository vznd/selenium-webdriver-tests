package selenium.chapters;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.BaseTest;
import selenium.HTMLPath;

public class BrowserNavigationTest extends BaseTest {

    @Test
    public void openUrl() {
        driver.get(HTMLPath.NAVIGATION);
        Assert.assertEquals(driver.getCurrentUrl(), HTMLPath.NAVIGATION, "The URL was not correct!");
    }

    @Test
    public void openUrlWithNavigate() {
        driver.navigate().to(HTMLPath.NAVIGATION);
        Assert.assertEquals(driver.getCurrentUrl(), HTMLPath.NAVIGATION, "The URL was not correct!");
    }

    @Test
    public void pressBackBrowserButton() {
        driver.get(HTMLPath.NAVIGATION);
        String expectedUrl = driver.getCurrentUrl();
        driver.findElement(By.id("frames-link")).click();
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "The URL was not correct!");
    }

    @Test // COMING SOON
    public void pressForwardBrowserButton() {
        /*
        STR:
        1) Open a web URL with navigate
        2) Click on a button to navigate to another URL
        3) Click BACK button
        4) Click FORWARD button
        5) Assert expected page is displayed
         */
    }

}
