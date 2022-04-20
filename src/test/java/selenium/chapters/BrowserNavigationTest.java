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

    @Test
    public void pressForwardBrowserButton() {
        driver.get(HTMLPath.NAVIGATION);
        driver.findElement(By.id("frames-link")).click();
        String expectedUrl = driver.getCurrentUrl();
        driver.navigate().back();
        driver.navigate().forward();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "The URL was not correct!");
    }

}
