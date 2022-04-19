package selenium.chapters;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.BaseTest;
import selenium.HTMLPath;

import java.time.Duration;

public class AlertsTest extends BaseTest {

    @Test
    public void storeAlertWithWebDriver() {
        driver.get(HTMLPath.SIMPLE_ALERT);
        driver.findElement(By.id("green-button")).click();
        Alert alert = driver.switchTo().alert();
    }

    @Test
    public void storeAlertWithWebDriverWait() {
        driver.get(HTMLPath.SIMPLE_ALERT);
        driver.findElement(By.id("green-button")).click();
        Duration timeout = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    @Test
    public void waitForAlertAbsence() {
        driver.get(HTMLPath.SIMPLE_ALERT);
        driver.findElement(By.id("green-button")).click();
        driver.switchTo().alert().dismiss();
        boolean isAlertPresent = isAlertPresent();
        Assert.assertFalse(isAlertPresent, "The alert was present!");
    }

    @Test
    public void getAlertText() {
        driver.get(HTMLPath.SIMPLE_ALERT);
        driver.findElement(By.id("green-button")).click();
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "Simple Alert";
        Assert.assertEquals(actualAlertText, expectedAlertText, "The alert text was not correct!");
    }

    @Test
    public void acceptAlert() {
        driver.get(HTMLPath.ALERT_WITH_REDIRECT);
        driver.findElement(By.id("green-button")).click();
        driver.switchTo().alert().accept();

        boolean isAlertPresent = isAlertPresent();
        Assert.assertFalse(isAlertPresent, "The alert was present!");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.google.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "The URL was not correct!");
    }

    @Test
    public void enterInfoIntoPrompt() {
        driver.get(HTMLPath.PROMPT);
        driver.findElement(By.id("green-button")).click();

        driver.switchTo().alert().sendKeys("155");
        driver.switchTo().alert().accept();

        boolean isAlertPresent = isAlertPresent();
        Assert.assertFalse(isAlertPresent, "The alert was present!");

        String actualURL = driver.getCurrentUrl();
        String expectedUrl = "https://www.google.com/";
        Assert.assertEquals(actualURL, expectedUrl, "The URL was not correct!");
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
