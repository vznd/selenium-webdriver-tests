package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseActionsTest extends BaseTest {

    @Test
    public void clickAndHold() {
        driver.get(HTMLPath.CLICK_AND_HOLD);
        WebElement clickMeAndHoldButton = driver.findElement(By.id("green-button"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(clickMeAndHoldButton).build().perform();
        String actualButtonColor = clickMeAndHoldButton.getCssValue("background-color");
        String expectedButtonColor = "rgba(255, 0, 0, 1)";
        Assert.assertEquals(actualButtonColor, expectedButtonColor,
                "The color of 'click me and hold' button was not " + expectedButtonColor + "!");
    }

    @Test
    public void contextClick() {
        /*
        STR:
        1) Open context click html
        2) Find green-button
        3) Define Actions object
        4) Build action to doubleCLick on button and perform it
        5) Assert an element with context menu assert it is displayed
         */
    }

    @Test
    public void doubleClick() {
        /*
        STR:
        1) Open double click html
        2) Find green-button
        3) Define Actions object
        4) Build action to doubleCLick on button and perform it
        5) Assert an element has red backround color
         */
    }

    @Test
    public void moveToElement() {
        /*
        STR:
        1) Open move to element html
        2) Find green-button and store it to a variable
        3) Initialize Actions object
        4) Perform move to element
        5) Assert something
         */
    }

}
