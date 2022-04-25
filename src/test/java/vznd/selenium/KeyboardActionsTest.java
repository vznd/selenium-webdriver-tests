package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void enterWithActions() {
        WebElement inputField = driver.findElement(By.id("input"));
        new Actions(driver).sendKeys(inputField, "Hello!" + Keys.ENTER).perform();
        String actualButtonColor = driver.findElement(By.id("green-button")).getCssValue("background-color");
        String expectedButtonColor = "rgba(255, 0, 0, 1)";
        Assert.assertEquals(actualButtonColor, expectedButtonColor,
                "The color of button did not match expected!");
    }

    @Test
    public void keyUpAndDown() {
        WebElement inputField = driver.findElement(By.id("input"));
        new Actions(driver)
                .keyDown(Keys.SHIFT).sendKeys(inputField,"qwerty")
                .keyUp(Keys.SHIFT).sendKeys("qwerty")
                .perform();
        String actualText = inputField.getAttribute("value");
        String expectedText = "QWERTYqwerty";
        Assert.assertEquals(actualText, expectedText, "The text did not match expected!");
    }

    @Test
    public void ctrlClick() {
        WebElement button = driver.findElement(By.id("green-button"));
        new Actions(driver).keyDown(Keys.COMMAND).click(button).perform();
        int actualAmountOfWindows = driver.getWindowHandles().size();
        int expectedAmountOfWindows = 2;
        Assert.assertEquals(actualAmountOfWindows, expectedAmountOfWindows,
                "The amount of windows did not match expected!");
    }

}
