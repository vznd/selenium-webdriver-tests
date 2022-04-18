package selenium.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public static int DEFAULT_TIMEOUT = 30;

    @FindBy(id = "pt-login")
    public WebElement loginLink;

    @FindBy(id="pt-userpage")
    public WebElement usernameLink;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginLink() {
        loginLink.click();
        return new LoginPage(driver);
    }

    public BasePage assertUsername(String expectedUsername) {
        String actualUsername = usernameLink.getText();
        Assert.assertEquals(actualUsername, expectedUsername, "The username was incorrect!");
        return this;
    }

}
