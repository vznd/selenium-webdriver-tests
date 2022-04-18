package selenium.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.BaseTest;
import selenium.helpers.AlertHelper;
import selenium.helpers.JSHelper;

import java.time.Duration;

/**
 * This class demonstrates how to work with Alerts in Selenium WD
 * @see org.openqa.selenium.Alert
 */
public class AlertTest extends BaseTest {

    public String alertText;

    @BeforeMethod
    public void openURL() {
        driver.get("https://google.com");
    }

    @BeforeMethod
    public void generateAlert() {
        alertText = "I am alert!";
        JSHelper.displayAlert(driver, alertText);
    }

    /**
     * Stores Alert in a variable using WebDriver
     * The test passes if alert is present
     * If alert is not present, the test will fail with NoAlertPresentException
     *
     * @see org.openqa.selenium.WebDriver
     * @see org.openqa.selenium.NoAlertPresentException
     */
    //
    @Test
    public void storeAlertWithWebDriver() {
        Alert alert = driver.switchTo().alert();
    }

    /**
     * Stores Alert in a variable using WebDriverWait
     * The test passes if alert is present
     * If alert is not present, the test will fail with TimeoutException
     *
     * @see org.openqa.selenium.support.ui.WebDriverWait
     * @see org.openqa.selenium.TimeoutException
     */
    @Test
    public void storeAlertWithWebDriverWait() {
        Duration timeout = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Dismisses alert and check that alert is not present
     * It uses helper method isAlertPresent()
     *
     * {@link selenium.helpers.AlertHelper }
     */
    @Test
    public void waitForAlertAbsence() {
        driver.switchTo().alert().dismiss();
        boolean isAlertPresent = AlertHelper.isAlertPresent(driver);
        Assert.assertFalse(isAlertPresent, "The alert was present!");
    }

    /**
     * Gets Alert text
     *
     */
    @Test
    public void getAlertText() {
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertText, alertText, "The alert text was not correct!");
    }

}
