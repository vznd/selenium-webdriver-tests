package wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage {

    @FindBy(id = "wpTextbox1")
    public WebElement textArea;

    @FindBy(id = "p-logo")
    public WebElement logo;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UserPage putTextToTextArea(String text) {
        textArea.sendKeys(text);
        return this;
    }

    public EnMainPage clickLogo() {
        logo.click();
        return new EnMainPage(driver);
    }

}
