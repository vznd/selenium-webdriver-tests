package selenium.chapters.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.BaseTest;
import selenium.HTMLPath;

public class KeyboardActionsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.KEYBOARD);
    }

    @Test
    public void enterWithSendKeys() {
        driver.findElement(By.id("input"))
                .sendKeys("Hello!" + Keys.ENTER);
        driver.findElement(By.cssSelector("button[style='background-color: red;']"))
                .isDisplayed();
    }

    @Test // COMING SOON
    public void enterWithActions() {
        /*
        STR:
        1) Find input field and store it to a variable
        2) Press ENTER using Actions
        3) Assert css value of green-button was changed to red
         */
    }

    @Test // COMING SOON
    public void keyUpAndDown() {
         /*
        STR:
        1) Define Actions object
        2) Find input field and store it to a variable
        3) Build action which sends QWERTYqwerty into a input filed
        4) Assert entered text from the 'value' or 'text' attribute
         */
    }

    @Test // COMING SOON
    public void ctrlClick() {
         /*
        STR:
        1) Define Actions object
        2) Build action which presses LEFT_CONTROL and clicks on green-button
        3) Perform action
        4) Assert two windows are currently open
         */
    }

}
