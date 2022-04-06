package wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticlePage extends BasePage {

    @FindBy(css = "div[id='toc']")
    public WebElement contentBlock;

    @FindBy(id = "firstHeading")
    public WebElement firstHeading;

    public ArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ArticlePage assertContentBlockIsDisplayed() {
        Assert.assertTrue(contentBlock.isDisplayed(), "The content block was not displayed!");
        return this;
    }

    public ArticlePage assertFirstHeading(String expectedHeading) {
        String actualHeading = firstHeading.getText();
        Assert.assertEquals(actualHeading, expectedHeading, "The first heading did not match expected!");
        return this;
    }

}
