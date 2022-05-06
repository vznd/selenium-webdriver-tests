package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsInformationTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.INFORMATION);
    }

    @Test
    public void isDisplayed() {
        WebElement submitButton = driver.findElement(By.id("submit-button"));
        boolean isSubmitButtonDisplayed = submitButton.isDisplayed();
        Assert.assertTrue(isSubmitButtonDisplayed, "The 'submitButton' was not displayed!");
    }

    @Test
    public void isEnabled() {
        boolean isSubmitButtonEnabled = driver.findElement(By.id("submit-button")).isEnabled();
        Assert.assertFalse(isSubmitButtonEnabled, "The 'submit' button was not displayed!");
    }

    @Test
    public void isSelected() {
        boolean isAgreementCheckboxSelected = driver.findElement(By.id("agreement")).isSelected();
        Assert.assertFalse(isAgreementCheckboxSelected, "The 'agreement' checkbox was selected!");
    }

    @Test // COMING SOON
    public void getTagName() {
        /*
        STR:
        1) Find agreement, call getTagName, store result to a variable
        2) Declare expected value
        2) Assert equals
         */
    }

    @Test
    public void getCssValue() {
        String actualFormBackgroundColor = driver.findElement(By.id("user-form")).getCssValue("background-color");
        String expectedFormBackgroundColor = "rgba(154, 205, 50, 1)";
        Assert.assertEquals(actualFormBackgroundColor, expectedFormBackgroundColor,
                "The background color of user form was not " + expectedFormBackgroundColor + "!");
    }

    @Test
    public void getText() {
        String actualUserFormTitleText = driver.findElement(By.id("form-title")).getText();
        String expectedUserFormTitleText = "User Form";
        Assert.assertEquals(actualUserFormTitleText, expectedUserFormTitleText,
                "The 'user' form title text was not " + expectedUserFormTitleText + "!");
    }

}
