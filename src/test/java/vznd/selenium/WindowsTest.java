package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.NAVIGATION);
        WebElement link = driver.findElement(By.id("frames-link"));
        new Actions(driver)
                .keyDown(Keys.LEFT_CONTROL)
                .click(link)
                .click(link)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    @Test
    public void getWindowHandle() {
        String window = driver.getWindowHandle();
        Assert.assertNotNull(window, "The amount of windows did not match expected!");
    }

    @Test // COMING SOON
    public void getAllWindowHandles() {
        /*
        STR:
        1) Get all window handles
        2) Assert the size
         */
    }

    @Test // COMING SOON
    public void waitForCertainAmountOfWindowsToBeOpened() {
        /*
        STR:
        1) Create WebDriverWait
        2) Create ExpectedCondition
        3) Wait until Expected condition
         */
    }

    @Test // COMING SOON
    public void switchToNewTab() {
        /*
        STR:
        1) Switch to a new tab
        2) Assert current url is about:blank
         */
    }

    @Test // COMING SOON
    public void switchToNewWindow() {
        /*
        STR:
        1) Switch to a window
        2) Assert current url is about:blank
         */
    }

    @Test // COMING SOON
    public void closeTab() {
        /*
        STR:
        1) Close all tabs except one
        2) Assert amount of opened tabs is 1
         */
    }

    @Test // COMING SOON
    public void getWindowDimensionsIndividually() {
        /*
        STR:
        1) Get window width
        2) Assert width is NOT less than 1000
        3) Get window height
        4) Assert height is NOT less than 800
         */
    }

    @Test // COMING SOON
    public void getWindowDimensionsFromObject() {
        /*
        STR:
        1) Get window size and store to a Dimension variable
        2) Get width from the Dimension variable
        3) Assert width is NOT less than 1000
        4) Get window height from the Dimension variable
        5) Assert height is NOT less than 800
         */
    }

    @Test // COMING SOON
    public void setWindowSize() {
        /*
        STR:
        1) Create a Dimension object with specified height and weight
        2) Set window size
        3) Assert window has the same size as was set
         */
    }

    @Test // COMING SOON
    public void getWindowXAndYPositionIndividually() {
        /*
        STR:
        1) Get X position and store it to a variable
        2) Get Y position and store it to a variable
        3) Assert something
         */
    }

    @Test // COMING SOON
    public void getWindowXAndYPositionFromObject() {
        /*
        STR:
        1) Create a Position object and store it to a variable
        2) Get X from its object
        3) Get Y from its object
        4) Assert something
         */
    }

    @Test // COMING SOON
    public void setWindowPosition() {
        /*
        STR:
        1) Initialize a Position object with specified X and Y
        2) Set position
        3) Assert Position was changed
         */
    }

    @Test // COMING SOON
    public void maximizeWindow() {
        /*
        STR:
        1) Maximize Window
        2) Assert window size
         */
    }

    @Test // COMING SOON
    public void minimizeWindow() {
        /*
        STR:
        1) Maximize Window
        2) Assert window size
        3) Minimize Window
        4) Assert window size
         */
    }

    @Test // COMING SOON
    public void enterFullscreen() {
        /*
        STR:
        1) Enter fullscreen
        2) Assert window size
         */
    }

    @Test // COMING SOON
    public void takeScreenshotOfAWindow() {
        /*
        STR:
        1) Take a screenshot
        2) Save file at some location (target/test-screenshots/)
        3) Assert file exists in that location
         */
    }

    @Test // COMING SOON
    public void takeScreenshotOfAnElement() {
        /*
        STR:
        1) Find an element
        2) Take a screenshot
        3) Save file at some location (target/test-screenshots/)
        4) Assert file exists in that location
         */
    }

    @Test // COMING SOON
    public void executeJavascriptOpenAlert() {
        /*
        STR:
        1) Initialize JavascriptExecutor
        2) Initialize a String with script which opens alert in browser
        3) Execute script
        4) Assert alert is open
         */
    }

    @Test // COMING SOON
    public void executeJavascriptClickOnElement() {
        /*
        STR:
        1) Initialize JavascriptExecutor
        2) Find a Gmail button element
        3) Initialize a String with script which clicks on element
        4) Execute script
        5) Assert gmail page is open
         */
    }

    @Test // COMING SOON
    public void printPage() {
        /*
        STR:
        1) Define PrintsPage object
        2) Define PrintOptions
        3) Set a range of pages for printing
        4) Invoke print method and store the result in a Pdf variable
        5) Invoke a getContent method and store the result in a String variable
        6) Assert content match expected
         */
    }

}
