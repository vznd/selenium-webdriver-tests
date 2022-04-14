package wiki;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnMainPage extends BasePage {

    @FindBy(id = "mp-welcome")
    public WebElement welcomeBlock;

    @FindBy(id = "pt-login")
    public WebElement loginLink;

    @FindBy(id="pt-userpage")
    public WebElement usernameLink;

    public EnMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginLink() {
        loginLink.click();
        return new LoginPage(driver);
    }

    public EnMainPage assertWelcomeBlockIsDisplayed() {
        Assert.assertTrue(welcomeBlock.isDisplayed(), "The welcome block was not displayed!");
        return this;
    }

    public EnMainPage assertUsernameIsCorrect(String expectedUsername) {
        String actualUsername = usernameLink.getText();
        Assert.assertEquals(actualUsername, expectedUsername, "The username was incorrect!");
        return this;
    }

    public PersonalToolsPage clickUsernameLink() {
        usernameLink.click();
        return new PersonalToolsPage(driver);
    }

}
