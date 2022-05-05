package vznd.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class WindowsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.WINDOWS);
    }

    @AfterTest
    public void deleteScreenshot() {
        if (Files.exists(Path.of("./image.png"))) {
            try {
                Files.delete(Path.of("./image.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    @Test
    public void waitForCertainAmountOfWindowsToBeOpened() {
        long timeout = 5;
        int expectedNumberOfWindows = 3;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        ExpectedCondition<Boolean> numberOfWindows = ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows);
        boolean isExpectedNumberOfWindowsOpened = wait.until(numberOfWindows);
        Assert.assertTrue(isExpectedNumberOfWindowsOpened,
                "The number of opened windows was not " + expectedNumberOfWindows + "!");
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

    @Test
    public void closeTab() {
        driver.close();
        int actualNumberOfWindows = driver.getWindowHandles().size();
        int expectedNumberOfWindows = 2;
        Assert.assertEquals(actualNumberOfWindows, expectedNumberOfWindows,
                "The number of opened tabs was not " + expectedNumberOfWindows + "!");
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

    @Test
    public void getWindowDimensionsFromObject() {
        Dimension windowSize = driver.manage().window().getSize();

        int minWidthValue = 1000;
        boolean isWidthInExpectedRange = windowSize.getWidth() > minWidthValue;
        Assert.assertTrue(isWidthInExpectedRange,
                "The width of window was not more than " + minWidthValue + "!");

        int minHeightValue = 800;
        boolean isHeightInExpectedRange = windowSize.getHeight() > minHeightValue;
        Assert.assertTrue(isHeightInExpectedRange,
                "The height of window was not more than " + minHeightValue + "!");
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

    @Test
    public void getWindowXAndYPositionFromObject() {
        Point position = driver.manage().window().getPosition();

        int expectedX = 22;
        Assert.assertEquals(position.getX(), expectedX, "The X position of window was not: " + expectedX + "!");

        int expectedY = 47;
        Assert.assertEquals(position.getY(), expectedY, "The Y position of window was not: " + expectedY + "!");
    }

    @Test
    public void setWindowPosition() {
        int expectedY = 500;
        int expectedX = 300;
        Point position = new Point(expectedX, expectedY);

        driver.manage().window().setPosition(position);

        Assert.assertEquals(position.getX(), expectedX, "The X position of window was not: " + expectedX + "!");
        Assert.assertEquals(position.getY(), expectedY, "The Y position of window was not: " + expectedY + "!");
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

    @Test
    public void takeScreenshotOfAWindow() {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isFileExists = Files.exists(Path.of("./image.png"));
        Assert.assertTrue(isFileExists, "The screenshot was not found!");
    }

    @Test
    public void takeScreenshotOfAnElement() {
        WebElement element = driver.findElement(By.cssSelector("h1"));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isFileExists = Files.exists(Path.of("./image.png"));
        Assert.assertTrue(isFileExists, "The screenshot was not found");
    }

    @Test
    public void executeJavascriptOpenAlert() {
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('hello world')");
        Alert alert = driver.switchTo().alert();
        Assert.assertNotNull(alert, "The alert was not opened");
    }

    @Test
    public void executeJavascriptClickOnElement() {
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement button = driver.findElement(By.id("green-button"));
        js.executeScript("arguments[0].click();", button);

        String expectedUrl = HTMLPath.SIMPLE_ALERT;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The address of page was not '" + expectedUrl + "'!");
    }

}
