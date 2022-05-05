package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTraditionalLocatorsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.TRADITIONAL_LOCATORS);
    }

    @Test
    public void className() {
        WebElement clickMeLink = driver.findElement(By.className("green-btn"));
        Assert.assertNotNull(clickMeLink, "The 'Click me' link was not found!");
    }

    @Test
    public void cssSelector() {
        WebElement clickMeLink = driver.findElement(By.cssSelector("a[class='green-btn']"));
        Assert.assertNotNull(clickMeLink, "The 'Click me' link was not found!");
    }

    @Test
    public void id() {
        WebElement clickMeLink = driver.findElement(By.id("green-button"));
        Assert.assertNotNull(clickMeLink, "The 'Click me' link was not found!");
    }

    @Test
    public void name() {
        WebElement clickMeLink = driver.findElement(By.name("green"));
        Assert.assertNotNull(clickMeLink, "The 'Click me' link was not found!");
    }

    @Test
    public void linkText() {
        WebElement clickMeLink = driver.findElement(By.linkText("Click me"));
        Assert.assertNotNull(clickMeLink, "The 'Click me' link was not found!");
    }

    @Test
    public void partialLinkText() {
        WebElement clickMeLink = driver.findElement(By.partialLinkText("me"));
        Assert.assertNotNull(clickMeLink, "The 'Click me' link was not found!");
    }

    @Test
    public void tagName() {
        WebElement clickMeLink = driver.findElement(By.tagName("a"));
        Assert.assertNotNull(clickMeLink, "The 'Click me' link was not found!");
    }

    @Test
    public void xpath() {
        WebElement clickMeLink = driver.findElement(By.xpath("//a[@id='green-button']"));
        Assert.assertNotNull(clickMeLink, "The 'Click me' link was not found!");
    }

}
