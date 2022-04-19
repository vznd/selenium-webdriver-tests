package selenium.chapters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.BaseTest;
import selenium.HTMLPath;


public class FramesTest extends BaseTest {

    @BeforeMethod
    public void openPageWithIframes() {
        driver.get(HTMLPath.FRAMES);
    }

    @Test
    public void switchToFrameUsingWebElement() {
        WebElement greenFrame = driver.findElement(By.id("first-iframe"));
        driver.switchTo().frame(greenFrame);
        WebElement table = driver.findElement(By.cssSelector("table[id='green-table']"));
        Assert.assertNotNull(table, "The table WebElement object was null!");
    }

    @Test
    public void switchToFrameUsingId() {
        driver.switchTo().frame("first-iframe");
        WebElement table = driver.findElement(By.cssSelector("table[id='green-table']"));
        Assert.assertNotNull(table, "The table WebElement object was null!");
    }

    @Test
    public void switchToFrameUsingName() {
        driver.switchTo().frame("green");
        WebElement table = driver.findElement(By.cssSelector("table[id='green-table']"));
        Assert.assertNotNull(table, "The table WebElement object was null!");
    }

    @Test // COMING SOON
    public void switchToFrameUsingIndex() {
        /*
        STR:
        1) Switch to frame by index
        2) Find some element in this frame
        3) Assert some data(or that found element is not null) within this frame
         */
    }

    @Test // COMING SOON
    public void switchToDefaultContext() {
        /*
        STR:
        1) Switch to frame
        2) Find some element in this frame
        3) Assert some data(or that found element is not null) within this frame
        4) Switch to default content
        5) Assert some data in default content
         */
    }

}
