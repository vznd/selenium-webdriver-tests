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

    @Test // COMING SOON
    public void isEnabled() {
        /*
        STR:
        1) Find submit-button, call isEnabled, store it to a variable
        2) Assert false
         */
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

    @Test // COMING SOON
    public void getText() {
        /*
        STR:
        1) Find form title, call getText, store it to a variable
        2) Declare expected title
        3) Assert equals
         */
    }

}
