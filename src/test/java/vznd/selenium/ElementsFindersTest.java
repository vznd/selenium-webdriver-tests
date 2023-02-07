package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    @Test
    public void findElementBasedOnParentObject() {
        WebElement fruits = driver.findElement(By.id("fruits"));
        String actualText = fruits.findElement(By.className("fruit")).getText();
        String expectedText = "Apple";
        Assert.assertEquals(actualText, expectedText, "The text of first element was not " + expectedText + "!");
    }

    @Test
    public void findElementBasedOnParentLocator() {
        String actualText = driver.findElement(By.cssSelector("#fruits .fruit")).getText();
        String expectedText = "Apple";
        Assert.assertEquals(actualText, expectedText, "The text of the first element was not " + expectedText + "!");
    }

    @Test
    public void findAllElementsByTag() {
        List<WebElement> allElements = driver.findElements(By.tagName("li"));
        int actualAmountOfElements = allElements.size();
        int expectedAmountOfElements = 3;
        Assert.assertEquals(actualAmountOfElements, expectedAmountOfElements,
                "The amount of elements was not " + expectedAmountOfElements + "!");
    }

    @Test
    public void switchToActiveElement() {
        driver.findElement(By.id("green-button")).click();
        String actualText = driver.switchTo().activeElement().getText();
        String expectedText = "Active";
        Assert.assertEquals(actualText, expectedText, "The text of active element was not " + expectedText + "!");
    }

}
