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

    @Test
    public void switchToFrameUsingIndex() {
        driver.switchTo().frame(0);
        WebElement table = driver.findElement(By.cssSelector("table[id='green-table']"));
        Assert.assertNotNull(table, "The table WebElement object was null!");
    }

    @Test
    public void switchToDefaultContext() {
        driver.switchTo().frame(0);
        WebElement table = driver.findElement(By.cssSelector("table[id='green-table']"));
        Assert.assertNotNull(table, "The table WebElement object was null!");

        driver.switchTo().defaultContent();
        WebElement headerInDefaultContent = driver.findElement(By.cssSelector("h1"));
        Assert.assertNotNull(headerInDefaultContent, "This object was null!");
    }

}
