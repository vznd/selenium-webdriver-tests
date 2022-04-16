package wiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UserPage extends BasePage {

    @FindBy(css = "textarea[id='wpTextbox1']")
    public WebElement textArea;

    @FindBy(id = "p-logo")
    public WebElement logo;

    @FindBy(id = "ca-user")
    public WebElement userPageTab;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UserPage assertUserPageTabIsSelected() {
        Assert.assertTrue(userPageTab.getAttribute("class").contains("selected"),
                "The userPageTab element did not contain 'selected' in the 'class' attribute!");
        return this;
    }

    public UserPage putTextToTextArea(String text) {
        wait.until(ExpectedConditions.visibilityOf(textArea))
                .sendKeys(text);
        return this;
    }

    public EnMainPage clickLogo() {
        logo.click();
        return new EnMainPage(driver);
    }

}
