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

    @Test // COMING SOON
    public void cssSelector() {
        /*
        STR:
        1) Find element by cssSelector and store it to a variable
        2) Assert not null
         */
    }

    @Test // COMING SOON
    public void id() {
        /*
        STR:
        1) Find element by id and store it to a variable
        2) Assert not null
         */
    }

    @Test // COMING SOON
    public void name() {
        /*
        STR:
        1) Find element by name and store it to a variable
        2) Assert not null
         */
    }

    @Test // COMING SOON
    public void linkText() {
        /*
        STR:
        1) Find element by linkText and store it to a variable
        2) Assert not null
         */
    }

    @Test // COMING SOON
    public void partialLinkText() {
        /*
        STR:
        1) Find element by partialLinkText and store it to a variable
        2) Assert not null
         */
    }

    @Test // COMING SOON
    public void tagName() {
        /*
        STR:
        1) Find element by tagName and store it to a variable
        2) Assert not null
         */
    }

    @Test // COMING SOON
    public void xpath() {
        /*
        STR:
        1) Find element by xpath and store it to a variable
        2) Assert not null
         */
    }

}
