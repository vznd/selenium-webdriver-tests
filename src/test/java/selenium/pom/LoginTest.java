package selenium.pom;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.BaseTest;
import selenium.pom.HomePage;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    public String username;
    public String password;

    @BeforeMethod
    public void preCondition() {
        homePage = new HomePage(driver);
        username = "Username12340";
        password = "Qazxc123";
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
