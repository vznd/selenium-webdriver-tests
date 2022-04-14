package wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalToolsPage extends BasePage {

    @FindBy(id = "ca-user")
    public WebElement userPageLink;

    public PersonalToolsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public UserPage clickUserPageLink() {
        userPageLink.click();
        return new UserPage(driver);
    }

}
