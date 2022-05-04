package vznd.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.WINDOWS);
    }

    @Test
    public void getWindowHandle() {
        String window = driver.getWindowHandle();
        Assert.assertNotNull(window, "The window was not opened!");
    }

    @Test
    public void getWindowHandles() {
        Set<String> windows = driver.getWindowHandles();
        int expectedNumberOfHandledWindows = 3;
        Assert.assertEquals(windows.size(), expectedNumberOfHandledWindows ,
                "The number of opened windows was not " + expectedNumberOfHandledWindows + "!");
    }

    @Test
    public void switchToWindowById() {
        String firstTab = String.valueOf(driver.getWindowHandles().toArray()[0]);
        driver.switchTo().window(firstTab);
        WebElement button = driver.findElement(By.id("green-button"));
        Assert.assertTrue(button.isDisplayed(),
                "The button was not displayed after switching to the first tab!");
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

    @Test
    public void maximizeWindow() {
        Dimension defaultSize = driver.manage().window().getSize();
        driver.manage().window().maximize();
        Dimension maximizeSize = driver.manage().window().getSize();

        boolean wasWidthChanged = defaultSize.getWidth() < maximizeSize.getWidth();
        Assert.assertTrue(wasWidthChanged,
                "The window width after enabling maximize was less or equal to window height before!");
        boolean wasHeightChanged = defaultSize.getHeight() < maximizeSize.getHeight();
        Assert.assertTrue(wasHeightChanged,
                "The window height after enabling maximize was less or equal to window height before!");
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
