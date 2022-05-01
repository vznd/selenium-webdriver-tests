package vznd.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsSelectListsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.SELECT_LISTS);
        /*
        STR:
        1) Find a select element
        2) Initialize Select object
         */
    }

    @Test // COMING SOON
    public void isMultiple() {
        /*
        STR:
        1) Call isMultiple and store result to a variable
        2) Assert true
         */
    }

    @Test // COMING SOON
    public void getOptions() {
        /*
        STR:
        1) Call getOptions and store result to a variable
        2) Get size from options and store it to a variable
        3) Store expected options amount to a variable
        4) Assert equals
         */
    }

    @Test // COMING SOON
    public void getFirstSelectedOption() {
        /*
        STR:
        1) Select option by index
        2) Get first selected option, get text and store it to a variable
        3) Store expected selected option text to a variable
        4) Assert equals
         */
    }

    @Test // COMING SOON
    public void getAllSelectedOptions() {
        /*
        STR:
        1) Get all selected options, get its size and store it to a variable
        2) Store expected selected options size to a variable
        3) Assert equals
         */
    }

    @Test // COMING SOON
    public void selectByIndex() {
        /*
        STR:
        1) Select by index 1
        2) Get first selected option, get text from it and store it to a variable
        3) Declare expected text
        4) Assert equals
         */
    }

    @Test // COMING SOON
    public void deselectByIndex() {
        /*
        STR:
        1) Select option by index
        2) Deselect option by the same index
        3) Get all selected options size and store it to a variable
        4) Store expected selected options to a variable
        5) Assert equals
         */
    }

    @Test // COMING SOON
    public void selectByValue() {
        /*
        STR:
        1) Define value and store it to a variable
        2) Call selectByValue
        3) Get first selected option, get text and store it to a variable
        4) Define expected Option
        5) Assert equals
         */
    }

    @Test // COMING SOON
    public void deselectByValue() {
        /*
        STR:
        1) Define value and store it to a variable
        2) Call selectByValue
        3) Call deselectByValue
        4) Get all selected options, get size and store it to a variable
        5) Define expected amount of selected options
        6) Assert equals
         */
    }

    @Test // COMING SOON
    public void selectByVisibleText() {
        /*
        STR:
        1) Define visible text and store it to a variable
        2) Call selectByVisibleText
        3) Get first selected option, get text and store it to a variable
        4) Assert equals
         */
    }

    @Test // COMING SOON
    public void deselectAll() {
        /*
        STR:
        1) Select by index
        2) Call deselectAll
        3) Get all selected options, get its size and store it to a variable
        4) Store expected selected options size to a variable
        5) Assert equals
         */
    }

}
