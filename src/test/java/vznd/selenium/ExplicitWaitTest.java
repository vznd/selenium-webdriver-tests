package vznd.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

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

    @Test
    public void elementToBeClickableByLocator() {
        WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("clickable")));
        Assert.assertNotNull(clickableButton, "The 'Click' button was not clickable!");
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

    @Test
    public void frameToBeAvailableAndSwitchToItByElement() {
        WebElement iFrame = driver.findElement(By.id("iframe"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        WebElement greenTable = driver.findElement(By.id("green-table"));
        Assert.assertNotNull(greenTable, "The 'Green iFrame' was not available on the screen!");
    }

    @Test
    public void invisibilityOf() {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        boolean isFirstNameFieldInvisible = wait.until(ExpectedConditions.invisibilityOf(firstNameField));
        Assert.assertTrue(isFirstNameFieldInvisible, "The 'First name' field was visible!");
    }

    @Test
    public void invisibilityOfAllElementsList() {
        List<WebElement> invisibleElements = driver.findElements(By.className("invisible"));
        boolean areAllElementsInvisible = wait.until(ExpectedConditions.invisibilityOfAllElements(invisibleElements));
        Assert.assertTrue(areAllElementsInvisible, "The list had visible elements!");
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

    @Test
    public void numberOfWindowsToBe() {
        driver.findElement(By.id("wait-open-button")).click();
        int expectedNumberOfOpenWindows = 2;
        boolean isExpectedNumberOfOpenWindows = wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfOpenWindows));
        Assert.assertTrue(isExpectedNumberOfOpenWindows,
                "The number of open windows was not " + expectedNumberOfOpenWindows + "!");
    }

    @Test
    public void presenceOfAllElementsLocatedBy() {
        By by = By.className("presence-button");
        int actualAmountOfElements  = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)).size();
        int expectedAmountOfElements = 3;
        Assert.assertEquals(actualAmountOfElements, expectedAmountOfElements,
                "The amount of 'presence' buttons was not " + expectedAmountOfElements + "!");
    }

    @Test
    public void presenceOfElementLocated() {
        WebElement pullButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pull-button")));
        Assert.assertNotNull(pullButton, "The 'pull' button was not present!");
    }

    @Test
    public void presenceOfNestedElementLocatedBy() {
        WebElement presentButtons = driver.findElement(By.id("present"));
        WebElement pullButton = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
                presentButtons,
                By.id("pull-button")
        ));
        Assert.assertNotNull(pullButton, "The 'Pull' button was not present!");
    }

    @Test
    public void presenceOfNestedElementsLocatedBy() {
        List<WebElement> presentButtons = wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(
                By.id("present"),
                By.className("presence-button"))
        );
        Assert.assertNotNull(presentButtons, "The 'Present' buttons were not present!");
    }

    @Test
    public void refreshed() {
        WebElement toRefreshButton = driver.findElement(By.id("to-refresh"));
        WebElement refreshButton = driver.findElement(By.id("refresh"));
        refreshButton.click();
        ExpectedCondition<WebElement> clickableToRefreshButton = ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(toRefreshButton)
        );
        WebElement refreshedButton = wait.until(clickableToRefreshButton);
        Assert.assertNotNull(refreshedButton, "The 'To refresh' button was not clickable!");
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

    @Test
    public void textMatches() {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        boolean isTextMatches = wait.until(ExpectedConditions.textMatches(By.id("text-area"), pattern));
        Assert.assertTrue(isTextMatches, "The text of 'Text area' element did not match with [a-zA-Z] pattern!");
    }

    @Test
    public void textToBe() {
        String expectedText = "I am superhero";
        boolean isTextMatchesExpected = wait.until(ExpectedConditions.textToBe(By.id("text-area"), expectedText));
        Assert.assertTrue(isTextMatchesExpected, "The text of 'Text area' element was not " + expectedText + "!");
    }

    @Test
    public void textToBePresentInElement() {
        WebElement textArea = driver.findElement(By.id("text-area"));
        String expectedText = "superhero";
        boolean isExpectedTextPresent = wait.until(ExpectedConditions.textToBePresentInElement(textArea, expectedText));
        Assert.assertTrue(isExpectedTextPresent,
                "The '" + expectedText + "' text was not present in the 'text-area' element!");
    }

    @Test
    public void textToBePresentInElementLocated() {
        String expectedText = "am";
        boolean isExpectedTextPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated((By.id("text-area")), expectedText));
        Assert.assertTrue(isExpectedTextPresent,
                "The '" + expectedText + "' text was not present in the 'text-area' element!");
    }

    @Test
    public void textToBePresentInElementValueByLocator() {
        String expectedText = "I";
        boolean isExpectedTextPresent = wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("text-area"), "I"));
        Assert.assertTrue(isExpectedTextPresent,
                "The '" + expectedText + "' text was not present in the value of 'text-area' element!");
    }

    @Test
    public void textToBePresentInElementValueByElement() {
        WebElement textArea = driver.findElement(By.id("text-area"));
        String expectedText = "I";
        boolean isExpectedTextPresent = wait.until(ExpectedConditions.textToBePresentInElementValue(textArea, "I"));
        Assert.assertTrue(isExpectedTextPresent,
                "The '" + expectedText + "' text was not present in the value of 'text-area' element!");
    }

    @Test
    public void titleContains() {
        String expectedText = "Explicit";
        boolean isTitleContainsExpectedText = wait.until(ExpectedConditions.titleContains(expectedText));
        Assert.assertTrue(isTitleContainsExpectedText,
                "The 'title' element did not contain '" + expectedText + "'!");
    }

    @Test
    public void titleIs() {
        String expectedTitle = "Explicit Wait";
        boolean isTitleExpected = wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertTrue(isTitleExpected,
                "The 'title' element was not '" + expectedTitle + "'!");
    }

    @Test
    public void urlContains() {
        String expectedText = "wait";
        boolean isUrlContainsExpectedText = wait.until(ExpectedConditions.urlContains(expectedText));
        Assert.assertTrue(isUrlContainsExpectedText, "The 'url' element did not contain '" + expectedText + "'!");
    }

    @Test
    public void urlMatches() {
        boolean isUrlExpected = wait.until(ExpectedConditions.urlMatches(HTMLPath.EXPLICIT_WAIT));
        Assert.assertTrue(isUrlExpected, "The URL was not '" + HTMLPath.EXPLICIT_WAIT + "'!");
    }

    @Test
    public void urlToBe() {
        boolean isUrlExpected = wait.until(ExpectedConditions.urlToBe(HTMLPath.EXPLICIT_WAIT));
        Assert.assertTrue(isUrlExpected, "The URL was not '" + HTMLPath.EXPLICIT_WAIT + "'!");
    }

    @Test
    public void visibilityOf() {
        WebElement playButton = driver.findElement(By.id("play-button"));
        WebElement visiblePlayButton = wait.until(ExpectedConditions.visibilityOf(playButton));
        Assert.assertNotNull(visiblePlayButton, "The 'Play' button was not visible!");
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

    @Test
    public void visibilityOfElementLocated() {
        WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pause-button")));
        Assert.assertNotNull(pauseButton, "The 'Pause' button was not visible!");
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
