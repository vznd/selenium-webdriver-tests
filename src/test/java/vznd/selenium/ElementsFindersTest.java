package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsFindersTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.FINDERS);
    }

    @Test
    public void findFirstElementWithClass() {
        String actualText = driver.findElement(By.className("fruit")).getText();
        String expectedText = "Apple";
        Assert.assertEquals(actualText, expectedText, "The text of first element was not " + expectedText + "!");
    }

    @Test // COMING SOON
    public void findElementBasedOnParentObject() {
        /*
        STR:
        1) Find element by fruits ID
        2) Find element from fruits element by class name fruit
        3) Get text from found element
        4) Assert the first element(from fruits) on the page was found
         */
    }

    @Test
    public void findElementBasedOnParentLocator() {
        String actualText = driver.findElement(By.cssSelector("#fruits .fruit")).getText();
        String expectedText = "Apple";
        Assert.assertEquals(actualText, expectedText, "The text of the first element was not " + expectedText + "!");
    }

    @Test // COMING SOON
    public void findAllElementsByTag() {
        /*
        STR:
        1) Find element all elements that has <li> tag and store it to a variable
        2) Assert the size of found elements match expected
         */
    }

    @Test // COMING SOON
    public void switchToActiveElement() {
        /*
        STR:
        1) Find green-button and click on it
        2) Switch to active element
        3) Get text from its element
        4) Assert the text match expected
         */
    }

}
