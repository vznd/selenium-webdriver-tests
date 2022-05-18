package vznd.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FluentWaitTest extends BaseTest {

    public final long TIMEOUT = 10L;
    public final long STEP_TIMEOUT = 2L;

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.FLUENT_WAIT);
    }

    @Test(enabled = false) // COMING SOON
    public void fluentWait() {
        /*
        STR:
        - check README
         */
    }

}
