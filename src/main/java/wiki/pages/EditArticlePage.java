package wiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class EditArticlePage extends BasePage {

    @FindBy(id = "wpTextbox1")
    public WebElement textBox;

    @FindBy(className = "editpage-head-copywarn")
    public WebElement copyWarningMsg;

    public EditArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EditArticlePage assertEditArticlePageIsOpen() {
        Assert.assertNotNull(
                wait.until(ExpectedConditions.visibilityOf(copyWarningMsg)),
                "The copy warning block was not displayed!"
        );
        return this;
    }

    public EditArticlePage putTextToTextArea(String text) {
        textBox.sendKeys(text);
        return this;
    }

}
