package vznd.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsInformationTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.INFORMATION);
    }

    @Test // COMING SOON
    public void isDisplayed() {
        /*
        STR:
        1) Find green-button and store it to a variable
        2) Call isDisplayed() method and store a result to a variable
        3) Assert boolean variable is true
         */
    }

    @Test // COMING SOON
    public void isEnabled() {
        /*
        STR:
        1) Find submit-button, call isEnabled, store it to a variable
        2) Assert false
         */
    }

    @Test // COMING SOON
    public void isSelected() {
        /*
        STR:
        1) Find agreement, call isSelected, store it to a variable
        2) Assert false
         */
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

    @Test // COMING SOON
    public void getRect() {
        /*
        STR:
        1) Find form, call getRect, store it to a variable
        2) Compare actualX not more than 8 and store it to a variable
        3) Assert true
        4) Compare actualY not more than 80 and store it to a variable
        5) Assert true
        6) Compare actualWidth not more than 920 and store it to a variable
        7) Assert true
        8) Compare actualHeight not more than 140 and store it to a variable
        9) Assert true
         */
    }

    @Test // COMING SOON
    public void getCssValue() {
        /*
        STR:
        1) Find form, call getCssValue / background-color, store it to a variable
        2) Declare expected background color
        3) Assert equals
         */
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
