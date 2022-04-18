package selenium.chapters;

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

public class AlertsTest extends BaseTest {

    @BeforeMethod
    public void openURL() {
        driver.get("https://google.com/");
    }

    @Test
    public void storeAlertWithWebDriver() {
        String alertText = "I am alert!";
        JSHelper.displaySimpleAlert(driver, alertText);

        Alert alert = driver.switchTo().alert();
    }

    @Test
    public void storeAlertWithWebDriverWait() {
        String alertText = "I am alert!";
        JSHelper.displaySimpleAlert(driver, alertText);
        Duration timeout = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    @Test
    public void waitForAlertAbsence() {
        String alertText = "I am alert!";
        JSHelper.displaySimpleAlert(driver, alertText);

        driver.switchTo().alert().dismiss();

        boolean isAlertPresent = AlertHelper.isAlertPresent(driver);
        Assert.assertFalse(isAlertPresent, "The alert was present!");
    }

    @Test
    public void getAlertText() {
        String alertText = "I am alert!";
        JSHelper.displaySimpleAlert(driver, alertText);

        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertText, alertText, "The alert text was not correct!");
    }

    @Test
    public void acceptAlert() {
        String alertText = "Google does not work! Click OK if you want to go to another search engine";
        String redirectUrl = "https://duckduckgo.com/";
        JSHelper.displayAlertWithRedirectOnAccept(driver, alertText, redirectUrl);

        driver.switchTo().alert().accept();

        boolean isAlertPresent = AlertHelper.isAlertPresent(driver);
        Assert.assertFalse(isAlertPresent, "The alert was present!");
        Assert.assertEquals(driver.getCurrentUrl(), redirectUrl, "The site was not correct!");
    }

    @Test
    public void enterInfoIntoPrompt() {
        String redirectUrl = "https://duckduckgo.com/";
        JSHelper.displayPromptWithRedirect(driver, "Do you want to change search engine? Write answer: 100 + 55 = ?",
                "155", redirectUrl);

        driver.switchTo().alert().sendKeys("155");
        driver.switchTo().alert().accept();

        boolean isAlertPresent = AlertHelper.isAlertPresent(driver);
        Assert.assertFalse(isAlertPresent, "The alert was present!");
        Assert.assertEquals(driver.getCurrentUrl(), redirectUrl, "The site was not correct!");
    }

}
