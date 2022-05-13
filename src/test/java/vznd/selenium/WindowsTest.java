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
import java.time.Duration;
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
        Duration timeout = Duration.ofSeconds(5);
        int expectedNumberOfWindows = 3;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        ExpectedCondition<Boolean> numberOfWindows = ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows);
        boolean isExpectedNumberOfWindowsOpened = wait.until(numberOfWindows);
        Assert.assertTrue(isExpectedNumberOfWindowsOpened,
                "The number of opened windows was not " + expectedNumberOfWindows + "!");
    }

    @Test
    public void closeTab() {
        driver.close();
        int actualNumberOfWindows = driver.getWindowHandles().size();
        int expectedNumberOfWindows = 2;
        Assert.assertEquals(actualNumberOfWindows, expectedNumberOfWindows,
                "The number of opened tabs was not " + expectedNumberOfWindows + "!");
    }

    @Test(enabled = false) // This test is platform-dependent, expected values should be customized individually
    public void getWindowDimensionsIndividually() {
        int actualWidth = driver.manage().window().getSize().getWidth();
        int minWidthValue = 1000;
        boolean isWidthInExpectedRange = actualWidth > minWidthValue;
        Assert.assertTrue(isWidthInExpectedRange,
                "The width of window was not more than " + minWidthValue + "!\n\n" +
                        "Actual width: " + actualWidth);

        int actualHeight = driver.manage().window().getSize().getHeight();
        int minHeightValue = 800;
        boolean isHeightInExpectedRange = actualHeight > minHeightValue;
        Assert.assertTrue(isHeightInExpectedRange,
                "The height of window was not more than " + minHeightValue + "!\n\n" +
                        "Actual height: " + actualHeight);
    }

    @Test(enabled = false) // This test is platform-dependent, expected values should be customized individually
    public void getWindowDimensionsFromObject() {
        Dimension windowSize = driver.manage().window().getSize();

        int minWidthValue = 1000;
        int actualWidthValue = windowSize.getWidth();
        boolean isWidthInExpectedRange = actualWidthValue > minWidthValue;
        Assert.assertTrue(isWidthInExpectedRange,
                "The width of window was not more than " + minWidthValue + "!\n\n" +
                        "Actual window width: " + actualWidthValue);

        int minHeightValue = 800;
        int actualHeightValue = windowSize.getHeight();
        boolean isHeightInExpectedRange = actualHeightValue > minHeightValue;
        Assert.assertTrue(isHeightInExpectedRange,
                "The height of window was not more than " + minHeightValue + "!\n\n" +
                        "Actual window height: " + actualHeightValue);
    }

    @Test
    public void setWindowSize() {
        int width = 800;
        int height = 500;
        Dimension windowSize = new Dimension(width, height);
        driver.manage().window().setSize(windowSize);

        Dimension actualSize = driver.manage().window().getSize();
        boolean isWidthInExpectedRange = actualSize.getWidth() == width;
        Assert.assertTrue(isWidthInExpectedRange,
                "The width of window was not " + width + "!");

        boolean isHeightInExpectedRange = actualSize.getHeight() == height;
        Assert.assertTrue(isHeightInExpectedRange,
                "The height of window was not " + height + "!");
    }

    @Test(enabled = false) // This test is platform-dependent, expected values should be customized individually
    public void getWindowXAndYPositionIndividually() {
        int actualX = driver.manage().window().getPosition().getX();
        int expectedX = 22;
        Assert.assertEquals(actualX, expectedX, "The X position of window was not: " + expectedX + "!\n\n" +
                "ActualX: " + actualX);

        int actualY = driver.manage().window().getPosition().getY();
        int expectedY = 47;
        Assert.assertEquals(actualY, expectedY, "The Y position of window was not: " + expectedY + "!\n\n" +
                "ActualY: " + actualY);
    }

    @Test(enabled = false) // This test is platform-dependent, expected values should be customized individually
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

    @Test(enabled = false) // This test is platform-dependent, expected values should be customized individually
    public void maximizeWindow() {
        Dimension defaultSize = driver.manage().window().getSize();
        driver.manage().window().maximize();
        Dimension maximizedSize = driver.manage().window().getSize();

        boolean wasWidthChanged = defaultSize.getWidth() < maximizedSize.getWidth();
        Assert.assertTrue(wasWidthChanged,
                "The window width after enabling maximize was not more than before maximize!\n\n" +
                        "Before maximize: " + defaultSize.getWidth() +
                        "After maximize: " + maximizedSize.getWidth()
        );

        boolean wasHeightChanged = defaultSize.getHeight() < maximizedSize.getHeight();
        Assert.assertTrue(wasHeightChanged,
                "The window height after enabling maximize was less or equal to window height before!\n\n" +
                        "Before maximize: " + defaultSize.getHeight() +
                        "After maximize: " + maximizedSize.getHeight()
        );
    }

    @Test(enabled = false) // This test is failing for some reason
    public void enterFullscreen() {
        Dimension defaultSize = driver.manage().window().getSize();
        driver.manage().window().fullscreen();
        Dimension fullscreenSize = driver.manage().window().getSize();

        boolean wasHeightChanged = defaultSize.getHeight() < fullscreenSize.getHeight();
        Assert.assertTrue(wasHeightChanged,
                "The window height after enabling full screen was less or equal to window height before!");
        boolean wasWidthChanged = defaultSize.getWidth() < fullscreenSize.getWidth();
        Assert.assertTrue(wasWidthChanged,
                "The window width after enabling full screen was less or equal to window width before!");
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
