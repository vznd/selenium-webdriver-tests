package vznd.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitTest extends BaseTest {

    public final long TIMEOUT = 10L;
    WebDriverWait wait;

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.EXPLICIT_WAIT);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    @Test
    public void waitWithExpectedCondition() {
        boolean isHeaderDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "The 'Elements Explicit Wait' header was not displayed!");
    }

    @Test
    public void waitWithLambda() {
        WebElement header = wait.until(driver -> driver.findElement(By.tagName("h1")));
        Assert.assertNotNull(header, "The 'Elements Explicit Wait' header was not displayed!");
    }

    @Test
    public void and() {
        ExpectedCondition<Boolean> conditionElementsVisability = ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(By.id("on-button")),
                ExpectedConditions.visibilityOfElementLocated(By.id("off-button"))
        );
        boolean areOnAndOffButtonsVisible = wait.until(conditionElementsVisability);
        Assert.assertTrue(areOnAndOffButtonsVisible, "The 'On' and 'Off' buttons were not visible!");
    }

    @Test
    public void or() {
        ExpectedCondition<Boolean> conditionElementsClickability = ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(By.id("on-button")),
                ExpectedConditions.elementToBeClickable(By.id("off-button"))
        );
        boolean areOnAndOffButtonsClickable = wait.until(conditionElementsClickability);
        Assert.assertTrue(areOnAndOffButtonsClickable, "The 'On' and 'Off' buttons were not clickable!");
    }

    @Test
    public void not() {
        ExpectedCondition<Boolean> alertIsNotPresentCondition = ExpectedConditions.not(
                ExpectedConditions.alertIsPresent()
        );
        boolean isAlertNotPresent = wait.until(alertIsNotPresentCondition);
        Assert.assertTrue(isAlertNotPresent, "The alert was present!");
    }

    @Test
    public void alertIsPresent() {
        driver.findElement(By.id("alert-button")).click();
        Alert isAlertPresent = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertNotNull(isAlertPresent, "The alert was not present!");
    }

    @Test
    public void attributeContainsByLocator() {
        boolean isElementContainsTitle = wait.until(ExpectedConditions.attributeContains(
                By.id("attr-button"),
                "title",
                "title!")
        );
        Assert.assertTrue(isElementContainsTitle,
                "The 'I am a button' element did not have a 'title' attribute that contains 'title'!");
    }

    @Test
    public void attributeContainsByElement() {
        WebElement attributeButton = driver.findElement(By.id("attr-button"));
        boolean isElementContainsTitle = wait.until(ExpectedConditions.attributeContains(
                attributeButton,
                "title",
                "am")
        );
        Assert.assertTrue(isElementContainsTitle,
                "The 'I am a button' element did not have a 'title' attribute that contains the 'am'!");
    }

    @Test
    public void attributeToBeByLocator() {
        boolean isTitleMatch = wait.until(ExpectedConditions.attributeToBe(
                By.id("attr-button"),
                "title",
                "I am a title!")
        );
        Assert.assertTrue(isTitleMatch, "The title of 'I am a button' element was not 'I am a title!'!");
    }

    @Test
    public void attributeToBeByElement() {
        WebElement attributeButton = driver.findElement(By.id("attr-button"));
        boolean isTitleMatch = wait.until(ExpectedConditions.attributeToBe(
                attributeButton,
                "title",
                "I am a title!")
        );
        Assert.assertTrue(isTitleMatch, "The title of 'I am a button' element was not 'I am a title!'!");
    }

    @Test
    public void attributeToBeNotEmpty() {
        WebElement attributeButton = driver.findElement(By.id("attr-button"));
        boolean isTitleValueNotEmpty = wait.until(ExpectedConditions.attributeToBeNotEmpty(attributeButton, "title"));
        Assert.assertTrue(isTitleValueNotEmpty, "The title of 'I am a button' element was empty!");
    }

    @Test
    public void elementSelectionStateToBeByLocator() {
        boolean isBreadOptionSelected = wait.until(ExpectedConditions.elementSelectionStateToBe(
                By.id("bread"),
                true)
        );
        Assert.assertTrue(isBreadOptionSelected, "The 'bread' option was not selected!");
    }

    @Test
    public void elementSelectionStateToBeByElement() {
        WebElement breadOption = driver.findElement(By.id("bread"));
        boolean isBreadOptionSelected = wait.until(ExpectedConditions.elementSelectionStateToBe(
                breadOption,
                true)
        );
        Assert.assertTrue(isBreadOptionSelected, "The 'bread' option was not selected!");
    }

    @Test
    public void elementToBeSelectedByLocator() {
        boolean isBreadOptionSelected = wait.until(ExpectedConditions.elementToBeSelected(
                By.id("bread"))
        );
        Assert.assertTrue(isBreadOptionSelected, "The 'bread' option was not selected!");
    }

    @Test
    public void elementToBeSelectedByElement() {
        WebElement breadOption = driver.findElement(By.id("bread"));
        boolean isBreadOptionSelected = wait.until(ExpectedConditions.elementToBeSelected(
                breadOption)
        );
        Assert.assertTrue(isBreadOptionSelected, "The 'bread' option was not selected!");
    }

    @Test(enabled = false) // COMING SOON
    public void elementToBeClickableByLocator() {
        /*
        STR:
        1) Wait until a 'clickable' element is clickable and store result to a variable
        2) Assert not null
         */
    }

    @Test
    public void elementToBeClickableByElement() {
        WebElement clickableButton = driver.findElement(By.id("clickable"));
        WebElement isButtonClickable = wait.until(ExpectedConditions.elementToBeClickable(clickableButton));
        Assert.assertNotNull(isButtonClickable, "The 'Click' button was not clickable!");
    }

    @Test
    public void frameToBeAvailableAndSwitchToItByIntLocator() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        WebElement greenTable = driver.findElement(By.id("green-table"));
        Assert.assertNotNull(greenTable, "The 'Green iFrame' was not available on the screen!");
    }

    @Test
    public void frameToBeAvailableAndSwitchToItByStringLocator() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframe"));
        WebElement greenTable = driver.findElement(By.id("green-table"));
        Assert.assertNotNull(greenTable, "The 'Green iFrame' was not available on the screen!");
    }

    @Test
    public void frameToBeAvailableAndSwitchToItByLocator() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframe")));
        WebElement greenTable = driver.findElement(By.id("green-table"));
        Assert.assertNotNull(greenTable, "The 'Green iFrame' was not available on the screen!");
    }

    @Test(enabled = false) // COMING SOON
    public void frameToBeAvailableAndSwitchToItByElement() {
        /*
        STR:
        1) Find a frame element by id and store it to a variable
        2) Wait until frame is available by element and store result to a variable
        3) Find green-table by id and store result to a variable
        4) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void invisibilityOf() {
        /*
        STR:
        1) Find element by first-name id and store it to a variable
        2) Wait until invisibility of this element and store result to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void invisibilityOfAllElementsList() {
        /*
        STR:
        1) Find elements with class name invisible and store it to a variable
        2) Wait until invisibility of these elements and store it to a variable
        3) Assert true
         */
    }

    @Test
    public void invisibilityOfAllElementsWebElementArgs() {
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        boolean isFirstAndLastNameFieldInvisible = wait.until(ExpectedConditions.invisibilityOfAllElements(firstName, lastName));
        Assert.assertTrue(isFirstAndLastNameFieldInvisible, "The 'First name' and 'Last name' were not invisible!");
    }

    @Test
    public void invisibilityOfElementLocatedByLocator() {
        boolean isFirstNameInisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("first-name")));
        Assert.assertTrue(isFirstNameInisible, "The 'First name' field was not invisible!");
    }

    @Test(enabled = false) // COMING SOON
    public void invisibilityOfElementWithText() {
        /*
        STR:
        1) Wait until element with class name invisible and text First name is invisible and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void javaScriptThrowsNoExceptions() {
        /*
        STR:
        1) Define js script which opens alert as string
        2) Wait until this script throws no exceptions and store it to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void jsReturnsValue() {
        /*
        STR:
        1) Define a js 'return document.getElementsByTagName('h1')[0].textContent' as string variable
        2) Wait until the script above returns value, wrap it into String.valueOf() and store it to a variable
        3) Define expected h1 text
        4) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON
    public void numberOfWindowsToBe() {
        /*
        STR:
        1) Click on wait-open-button
        2) Define expected number of windows to be opened
        3) Wait until expected number of windows is open and store result to a variable
        4) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void presenceOfAllElementsLocatedBy() {
        /*
        STR:
        1) Wait until all elements with the 'presence-button' class name are present and store them to a variable
        2) Define expected amount of elements - store it to a variable
        3) Assert equals
         */
    }

    @Test
    public void presenceOfElementLocated() {
        WebElement pullButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pull-button")));
        Assert.assertNotNull(pullButton, "The 'pull' button was not present!");
    }

    @Test(enabled = false) // COMING SOON
    public void presenceOfNestedElementLocatedBy() {
        /*
        STR:
        1) Find element by a 'present' id and store it to a variable
        2) Wait until nested element with 'pull-button' id is present and store it to a variable
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void presenceOfNestedElementsLocatedBy() {
        /*
        STR:
        1) Wait until all with 'presence-button' class and 'present' parent id are present and store it to a variable
        2) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void refreshed() {
        /*
        STR:
        1) Define to-refresh button and store it to a variable
        2) Define refresh button and store it to a variable
        3) Perform a click on refresh button
        4) Define ExpectedConditions variable which expects that toRefreshButton is clickable and refreshed
        5) Wait until expected condition and store it to a variable
        6) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void statelessOf() {
        /*
        STR:
        1) Define to-refresh button and store it to a variable
        2) Define refresh button and store it to a variable
        3) Perform a click on refresh button
        4) Define ExpectedConditions variable which expects that toRefreshButton has changed its state
        5) Wait until expected condition and store it to a variable
        6) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void textMatches() {
        /*
        STR:
        1) Define Pattern variable with pattern "[a-zA-Z]" and store it to a variable
        2) Wait until 'text-area' element matches created pattern and store it to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void textToBe() {
        /*
        STR:
        1) Wait until 'text-area' element text to be "I am a superhero" and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void textToBePresentInElement() {
        /*
        STR:
        1) Find 'text-area' element and store it to a variable
        2) Wait until 'superhero' text is present in element and store it to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void textToBePresentInElementLocated() {
        /*
        STR:
        1) Wait until "am" text is present in the text-area element and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void textToBePresentInElementValueByLocator() {
        /*
        STR:
        1) Wait until "I" text is present in the text-area and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void textToBePresentInElementValueByElement() {
        /*
        STR:
        1) Find text-area element and store it to a variable
        2) Wait until "I" text is present in text-area and store it to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void titleContains() {
        /*
        STR:
        1) Wait until a title contains "Explicit" and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void titleIs() {
        /*
        STR:
        1) Wait until title is "Explicit Wait" and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void urlContains() {
        /*
        STR:
        1) Wait until urlContains "wait" and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void urlMatches() {
        /*
        STR:
        1) Wait until url matches pattern "^http:\\/\\/localhost:8080" and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void urlToBe() {
        /*
        STR:
        1) Wait until url is actual full url and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void visibilityOf() {
        /*
        STR:
        1) Find a play-button web element and store it to a variable
        2) Wait until visibility of found element and store it to a variable
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void visibilityOfAllElementsList() {
        /*
        STR:
        1) Find elements by class name visibility-button and store it to a variable
        2) Wait until found elements are visible and store it to a variable
        3) Define expected size of found elements
        4) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON
    public void visibilityOfAllElementsArgs() {
        /*
        STR:
        1) Find a play-button element and store it to a variable
        2) Find a pause-button element and store it to a variable
        3) Wait until found elements are visible and store it to a variable
        4) Define expected number of found elements
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON
    public void visibilityOfAllElementsLocatedBy() {
        /*
        STR:
        1) Wait until all elements with visibility-button are visible and store it to a variable
        2) Define expected number of elements
        3) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON
    public void visibilityOfElementLocated() {
        /*
        STR:
        1) Wait until pause-button elements are visible
        2) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void visibilityOfNestedElementsLocatedByLocator() {
        /*
        STR:
        1) Define Expected conditions variable with visibility of nested elements located by "visible" id and "visibility-button" class name
        2) Wait until expected condition and store it to a variable
        3) Define expected number of found elements
        4) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON
    public void visibilityOfNestedElementsLocatedByElement() {
        /*
        STR:
        1) Find block by "visible" id and store it to a variable
        2) Define ExpectedConditions with visibility of nested elements located by block and "visibility-button" class
        3) Wait until ExpectedCondition
        4) Define expected amount of elements
        5) Assert equals
         */
    }

}
