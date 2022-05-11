package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsSelectListsTest extends BaseTest {

    public Select favouriteFood;

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.SELECT_LISTS);
        WebElement foodList = driver.findElement(By.id("favourite-food"));
        favouriteFood = new Select(foodList);
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

    @Test
    public void getFirstSelectedOption() {
        favouriteFood.selectByIndex(0);
        String actualSelectedOption = favouriteFood.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Bread";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption,
                "The first selected option of 'favourite food' list was not " + expectedSelectedOption + "!");
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

    @Test
    public void selectByValue() {
        String elementOfListValue = "cheese";
        favouriteFood.selectByValue(elementOfListValue);
        String actualSelectedOption = favouriteFood.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Cheese";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption,
                "The first selected option of 'favourite food' list was not " + expectedSelectedOption + "!");
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
