package wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigateToMainPageTest {

    public WebDriver driver;
    public HomePage homePage;

    @BeforeMethod
    public void preCondition() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.open().assertCentralLogoImgIsDisplayed();
    }

    @AfterMethod
    public void closeDriver() {
        homePage.close();
    }

    @Test
    public void navigateToEnMainPage() {
        homePage.clickEnMainPageLink()
                .assertWelcomeBlockIsDisplayed();
    }

}
