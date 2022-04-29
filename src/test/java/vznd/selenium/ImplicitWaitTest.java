package vznd.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitTest extends BaseTest {

    public final long TIMEOUT = 5L;

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.IMPLICIT_WAIT);
    }

    @Test // COMING SOON
    public void implicitWat() {
        /*
        STR:
        1) Make an implicit wait for TIMEOUT
        2) Find green-button
        3) Assert it is displayed
         */
    }

}
