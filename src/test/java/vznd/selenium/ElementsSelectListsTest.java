package vznd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ElementsSelectListsTest extends BaseTest {

    public Select favouriteFood;

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.SELECT_LISTS);
        WebElement foodList = driver.findElement(By.id("favourite-food"));
        favouriteFood = new Select(foodList);
    }

    @Test
    public void isMultiple() {
        boolean isMultiple = favouriteFood.isMultiple();
        Assert.assertTrue(isMultiple, "The 'favourite food' select list was not multiple!");
    }

    @Test
    public void getOptions() {
        List<WebElement> favouriteFoodOptions = favouriteFood.getOptions();
        int actualFavouriteFoodOptionsAmount = favouriteFoodOptions.size();
        int expectedFavouriteFoodOptionsAmount = 3;
        Assert.assertEquals(actualFavouriteFoodOptionsAmount, expectedFavouriteFoodOptionsAmount,
                "The options amount of 'favourite food' list was not equals " + expectedFavouriteFoodOptionsAmount + "!");
    }

    @Test
    public void getFirstSelectedOption() {
        favouriteFood.selectByIndex(0);
        String actualSelectedOption = favouriteFood.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Bread";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption,
                "The first selected option of 'favourite food' list was not " + expectedSelectedOption + "!");
    }

    @Test
    public void getAllSelectedOptions() {
        int actualSelectedOptionsAmount = favouriteFood.getAllSelectedOptions().size();
        int expectedSelectedOptionsAmount = 0;
        Assert.assertEquals(actualSelectedOptionsAmount, expectedSelectedOptionsAmount,
                "The amount of selected options in the ‘favourite food’ select list was not "
                        + expectedSelectedOptionsAmount + "!");
    }

    @Test
    public void selectByIndex() {
        favouriteFood.selectByIndex(1);
        String actualSelectedOptionText = favouriteFood.getFirstSelectedOption().getText();
        String expectedSelectedOptionText = "Milk";
        Assert.assertEquals(actualSelectedOptionText, expectedSelectedOptionText,
                "The first selected option of 'favourite food' was not " + expectedSelectedOptionText + "!");
    }

    @Test
    public void deselectByIndex() {
        favouriteFood.selectByIndex(1);
        favouriteFood.deselectByIndex(1);
        int actualSelectedOptionsAmount = favouriteFood.getAllSelectedOptions().size();
        int expectedSelectedOptionsAmount = 0;
        Assert.assertEquals(actualSelectedOptionsAmount, expectedSelectedOptionsAmount,
                "The amount of selected options in the ‘favourite food’ select list was not "
                        + expectedSelectedOptionsAmount + "!");
    }

    @Test
    public void selectByValue() {
        String value = "cheese";
        favouriteFood.selectByValue(value);
        String actualSelectedOption = favouriteFood.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Cheese";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption,
                "The first selected option of 'favourite food' list was not " + expectedSelectedOption + "!");
    }

    @Test
    public void deselectByValue() {
        String value = "cheese";
        favouriteFood.selectByValue(value);
        favouriteFood.deselectByValue(value);
        int actualSelectedOptionsAmount = favouriteFood.getAllSelectedOptions().size();
        int expectedSelectedOptionsAmount = 0;
        Assert.assertEquals(actualSelectedOptionsAmount, expectedSelectedOptionsAmount,
                "The amount of selected options in the ‘favourite food’ select list was not "
                        + expectedSelectedOptionsAmount + "!");
    }

    @Test
    public void selectByVisibleText() {
        String visibleText = "Cheese";
        favouriteFood.selectByVisibleText(visibleText);
        String actualSelectedOption = favouriteFood.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Cheese";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption,
                "The first selected option of 'favourite food' list was not " + expectedSelectedOption + "!");
    }

    @Test
    public void deselectAll() {
        favouriteFood.selectByIndex(1);
        favouriteFood.deselectAll();
        int actualSelectedOptionsAmount = favouriteFood.getAllSelectedOptions().size();
        int expectedSelectedOptionsAmount = 0;
        Assert.assertEquals(actualSelectedOptionsAmount, expectedSelectedOptionsAmount,
                "The amount of selected options in the ‘favourite food’ select list was not "
                        + expectedSelectedOptionsAmount + "!");
    }

}
