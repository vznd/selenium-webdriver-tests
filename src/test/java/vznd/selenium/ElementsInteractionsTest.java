package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsInteractionsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.INTERACTIONS);
    }

    @Test
    public void click() {
        driver.findElement(By.id("green-button")).click();
        String fullNameInput = driver.findElement(By.id("full-name")).getAttribute("value");
        Assert.assertTrue(fullNameInput.isBlank(), "The 'full name' input field was not blank!");
    }

    @Test
    public void clear() {
        WebElement fullNameInput = driver.findElement(By.id("full-name"));
        fullNameInput.clear();
        String actualFullNameInputValue = fullNameInput.getAttribute("value");
        Assert.assertTrue(actualFullNameInputValue.isBlank(), "The 'full name' input field was not blank!");
    }

    @Test
    public void sendKeys() {
        WebElement fullNameInputField = driver.findElement(By.id("full-name"));
        fullNameInputField.clear();
        String expectedFullName = "Corben Dallas";
        fullNameInputField.sendKeys(expectedFullName);
        String actualFullName = fullNameInputField.getAttribute("value");
        Assert.assertEquals(actualFullName, expectedFullName,
                "The 'full-name' was not " + expectedFullName + "!");
    }

}
