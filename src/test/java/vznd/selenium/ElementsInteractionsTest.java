package vznd.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsInteractionsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.INTERACTIONS);
    }

    @Test // COMING SOON
    public void click() {
        /*
        STR:
        1) Find green-button and make a click
        2) Find full name input field, call getAttribute / value, and store it to a variable
        3) Assert is blank
         */
    }

    @Test // COMING SOON
    public void clear() {
        /*
        STR:
        1) Find full name and store it to a variable
        2) Call clear from variable
        3) Get attribute / value from variable
        4) Assert is blank
         */
    }

    @Test // COMING SOON
    public void sendKeys() {
        /*
        STR:
        1) Find full name and store it to a variable
        2) Call clear from variable
        3) Declare full name to set to input, e.g. Corben Dallas
        4) Send keys using Corben Dallas
        5) Get attribute from variable / value
        6) Assert equals
         */
    }

}
