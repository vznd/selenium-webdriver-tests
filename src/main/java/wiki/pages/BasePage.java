package wiki.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public WebDriverWait longWait;
    public static int DEFAULT_TIMEOUT = 30;
    public static int LONG_TIMEOUT = 120;

    @FindBy(id = "p-logo")
    public WebElement logo;

    @FindBy(id = "pt-login")
    public WebElement loginLink;

    @FindBy(id="pt-userpage")
    public WebElement usernameLink;

    @FindBy(xpath = "//span[text()='Start editing']/parent::a")
    public WebElement startEditingButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public BasePage clickStartEditingPopup() {
        wait.until(ExpectedConditions.visibilityOf(startEditingButton))
                .click();
        return this;
    }

    public BasePage clickLogo() {
        logo.click();
        return this;
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

    public PersonalToolsPage clickUsernameLink() {
        usernameLink.click();
        return new PersonalToolsPage(driver);
    }

    public Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public BasePage assertAlertIsNotPresent() {
        Assert.assertFalse(isAlertPresent(), "The alert was present!");
        return this;
    }

}
