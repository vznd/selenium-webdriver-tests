package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseActionsTest extends BaseTest {

    public Actions actions;

    @BeforeMethod
    public void preCondition() {
        actions = new Actions(driver);
    }

    @Test
    public void clickAndHold() {
        driver.get(HTMLPath.CLICK_AND_HOLD);
        WebElement clickMeAndHoldButton = driver.findElement(By.id("green-button"));
        actions.clickAndHold(clickMeAndHoldButton).build().perform();
        String actualButtonColor = clickMeAndHoldButton.getCssValue("background-color");
        String expectedButtonColor = "rgba(255, 0, 0, 1)";
        Assert.assertEquals(actualButtonColor, expectedButtonColor,
                "The color of 'click me and hold' button was not " + expectedButtonColor + "!");
    }

    @Test
    public void contextClick() {
        driver.get(HTMLPath.CONTEXT_CLICK);
        WebElement clickMeToSeeContextMenuButton = driver.findElement(By.id("green-button"));
        actions.contextClick(clickMeToSeeContextMenuButton).build().perform();
        boolean isContextMenuDisplayed = driver.findElement(By.id("context-menu")).isDisplayed();
        Assert.assertTrue(isContextMenuDisplayed, "The context menu was not displayed!");
    }

    @Test
    public void doubleClick() {
        driver.get(HTMLPath.DOUBLE_CLICK);
        WebElement doubleClickMeButton = driver.findElement(By.id("green-button"));
        actions.doubleClick(doubleClickMeButton).build().perform();
        String actualButtonColor = doubleClickMeButton.getCssValue("background-color");
        String expectedButtonColor = "rgba(255, 0, 0, 1)";
        Assert.assertEquals(actualButtonColor, expectedButtonColor,
                "The color of 'double click me' button was not " + expectedButtonColor + "!");
    }

    @Test
    public void moveToElement() {
        driver.get(HTMLPath.MOVE_TO_ELEMENT);
        WebElement heyButton = driver.findElement(By.id("green-button"));
        actions.moveToElement(heyButton).build().perform();
        boolean isHeyButtonDisplayed = heyButton.isDisplayed();
        Assert.assertTrue(isHeyButtonDisplayed, "The 'Hey' button was not displayed!");
    }

}
