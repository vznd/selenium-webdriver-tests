package selenium.pom;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.BaseTest;

public class SearchFromHomePage extends BaseTest {

    public HomePage homePage;

    @BeforeMethod
    public void preCondition() {
        homePage = new HomePage(driver);
        homePage.open().assertCentralLogoImgIsDisplayed();
    }

    @Test
    public void searchFromHomePage() {
        String searchQuery = "Odessa";
        homePage.enterTextToSearchInputField(searchQuery)
                .clickSearchButton()
                .assertContentBlockIsDisplayed()
                .assertFirstHeading(searchQuery);
    }

}
