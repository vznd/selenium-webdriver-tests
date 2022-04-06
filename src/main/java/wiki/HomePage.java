package wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

    public String URL = "https://www.wikipedia.org/";

    @FindBy(css = "img[class='central-featured-logo']")
    public  WebElement centralLogoImg;

    @FindBy(css = "div[lang='en'] a")
    public WebElement enMainPageLink;

    @FindBy(css = "button[type='submit']")
    public WebElement searchButton;

    @FindBy(css = "input[id='searchInput']")
    public WebElement searchInputField;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // init elements by annotation FindBy
    }

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public HomePage assertCentralLogoImgIsDisplayed() {
        Assert.assertTrue(centralLogoImg.isDisplayed());
        return this;
    }

    public EnMainPage clickEnMainPageLink() {
        enMainPageLink.click();
        return new EnMainPage(driver);
    }

    public HomePage enterTextToSearchInputField(String searchQuery) {
        searchInputField.sendKeys(searchQuery);
        return this;
    }

    public ArticlePage clickSearchButton() {
        searchButton.click();
        return new ArticlePage(driver);
    }

}
