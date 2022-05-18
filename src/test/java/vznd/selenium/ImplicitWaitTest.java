package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitTest extends BaseTest {

    public final long TIMEOUT = 5L;

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.IMPLICIT_WAIT);
    }

    @Test(enabled = false)
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        WebElement heyButton = driver.findElement(By.id("green-button"));
        Assert.assertTrue(heyButton.isDisplayed(), "The 'Hey' button was not displayed!");
    }

}
