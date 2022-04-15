package wiki.auth;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wiki.BaseTest;
import wiki.HomePage;

public class LoginTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void preCondition() {
        homePage = new HomePage(driver);
    }

    @Test
    public void loginUser() {
        homePage.open()
                .clickEnMainPageLink()
                .clickLoginLink()
                .setUserName(username)
                .setPassword(password)
                .clickLoginButton()
                .assertUsername(username);
    }

}
