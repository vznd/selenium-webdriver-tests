package wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "wpName1")
    public WebElement usernameField;

    @FindBy(id = "wpPassword1")
    public WebElement passwordField;

    @FindBy(id = "wpLoginAttempt")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserName(String username) {
        if (usernameField.getText() != null) {
            usernameField.clear();
        }
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        if (passwordField.getText() != null) {
            passwordField.clear();
        }
        passwordField.sendKeys(password);
        return this;
    }

    public EnMainPage clickLoginButton() {
        loginButton.click();
        return new EnMainPage(driver);
    }

}
