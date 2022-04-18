package wiki.alerts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wiki.BaseTest;
import wiki.helpers.JSHelper;
import wiki.pages.HomePage;

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

}
