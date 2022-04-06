package wiki.search;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wiki.BaseTest;
import wiki.HomePage;

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
