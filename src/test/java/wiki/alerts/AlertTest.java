package wiki.alerts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wiki.BaseTest;
import wiki.pages.HomePage;
import wiki.pages.UserPage;

public class AlertTest extends BaseTest {

    public HomePage homePage;

    @BeforeMethod
    public void preCondition() {
        homePage = new HomePage(driver);
        homePage.open().assertCentralLogoImgIsDisplayed();
    }

    @Test
    public void dismissAlert() {
        String inputText = "It is just a text!";
        UserPage userPage = homePage.open()
                .clickEnMainPageLink()
                .assertWelcomeBlockIsDisplayed()
                .clickLoginLink()
                .setUserName(username)
                .setPassword(password)
                .clickLoginButton()
                .assertUsername(username)
                .clickUsernameLink()
                .clickUserPageLink()
                .putTextToTextArea(inputText);
        userPage.clickLogo()
                .waitForAlert()
                .dismiss();
        userPage.assertUserPageTabIsSelected()
                .assertAlertIsNotPresent();
    }

}
