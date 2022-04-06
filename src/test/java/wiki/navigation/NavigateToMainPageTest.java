package wiki.navigation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wiki.BaseTest;
import wiki.HomePage;

public class NavigateToMainPageTest extends BaseTest {

    public HomePage homePage;

    @BeforeMethod
    public void preCondition() {
        homePage = new HomePage(driver);
        homePage.open().assertCentralLogoImgIsDisplayed();
    }

    @Test
    public void navigateToEnMainPage() {
        homePage.clickEnMainPageLink()
                .assertWelcomeBlockIsDisplayed();
    }

}
