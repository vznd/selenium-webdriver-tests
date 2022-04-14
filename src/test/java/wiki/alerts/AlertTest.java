package wiki.alerts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wiki.BaseTest;
import wiki.HomePage;
import wiki.UserPage;

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
                .clickLoginLink()
                .setUserName(username)
                .setPassword(password)
                .clickLoginButton()
                .assertUsernameIsCorrect(username)
                .clickUsernameLink()
                .clickUserPageLink()
                .putTextToTextArea(inputText);
        userPage.clickLogo();
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
        userPage.clickLogo().assertWelcomeBlockIsDisplayed();
    }

}
