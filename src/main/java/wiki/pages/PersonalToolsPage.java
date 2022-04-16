package wiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PersonalToolsPage extends BasePage {

    @FindBy(id = "ca-user")
    public WebElement userPageTab;

    @FindBy(css = "textarea[id='wpTextbox1']")
    public WebElement textBox;

    public PersonalToolsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PersonalToolsPage clickUserPageTab() {
        userPageTab.click();
        return this;
    }

    public PersonalToolsPage assertUserPageTabIsSelected() {
        Assert.assertTrue(userPageTab.getAttribute("class").contains("selected"),
                "The userPageTab element did not contain 'selected' in the 'class' attribute!");
        return this;
    }

    public PersonalToolsPage putTextToTextArea(String text) {
        wait.until(ExpectedConditions.visibilityOf(textBox))
                .sendKeys(text);
        return this;
    }

}
