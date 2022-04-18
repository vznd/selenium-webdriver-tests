package selenium.alerts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.BaseTest;
import selenium.helpers.JSHelper;
import selenium.pom.HomePage;

public class AlertTest extends BaseTest {

    public HomePage homePage;
    public String alertText;

    @BeforeMethod
    public void preCondition() {
        homePage = new HomePage(driver);
        homePage.open()
                .assertCentralLogoImgIsDisplayed();
        alertText = "I am alert!";
        JSHelper.displayAlert(driver, alertText);
    }

    @Test
    public void dismissAlert() {
        homePage.waitForAlert()
                .dismiss();
        homePage.assertCentralLogoImgIsDisplayed()
                .assertAlertIsNotPresent();
    }

    @Test
    public void assertTextAlert() {
        String actualAlertText = homePage.waitForAlert().getText();
        String expectedAlertText = alertText;
        Assert.assertEquals(actualAlertText, expectedAlertText, "The alert text is incorrect!");
    }

}
