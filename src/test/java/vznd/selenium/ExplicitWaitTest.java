package vznd.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTest extends BaseTest {

    public final long TIMEOUT = 10L;
    /* STR: define WebDriverWait variable */

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.EXPLICIT_WAIT);
        /* STR: initialize WebDriverWait variable with TIMEOUT specified as class variable */
    }

    @Test(enabled = false) // COMING SOON
    public void waitWithExpectedCondition() {
        /*
        1) Wait unit visibility of h1 element and put result to a variable
        2) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void waitWithLambda() {
        /*
        STR:
        1) Wait unit h1 element is found using lambda and put result to a variable
        2) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void and() {
        /*
        STR:
        1) Define ExpectedConditions.and(ExpectedConditions, ExpectedConditions) and put it to a variable with type ExpectedConditions<Boolean>
           - The first condition should be a visibility of the on-button
           - The seconds condition should be a visibility of the off-button
        2) Wait until your "and" condition is met and put a result to a variable
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void or() {
        /*
        STR:
        1) Define ExpectedConditions.or(ExpectedConditions, ExpectedConditions) and put it to a variable with type ExpectedConditions<Boolean>
           - The first condition should be element on-button to be clickable
           - The seconds condition should be element off-button to be clickable
        2) Wait until your "or" condition is met and put a result to a variable
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void not() {
        /*
        STR:
        1) Define ExpectedConditions.not(ExpectedConditions) and put it to a variable with type ExpectedConditions<Boolean>
           - The condition should be alertIsPresent()
        2) Wait until your "not" condition is met and put a result to a variable
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void alertIsPresent() {
        /*
        STR:
        1) Click on alert-button
        2) Wait until alertIsPresent and put result to a variable
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void attributeContainsByLocator() {
        /*
        STR:
        1) Wait until #attr-button has a "title" attribute that contains the "title!" value and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void attributeContainsByElement() {
        /*
        STR:
        1) Find attr-button web element and store it to a variable
        2) Wait until button has a "title" attribute that contains the "am" value and store it to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void attributeToBeByLocator() {
        /*
        STR:
        1) Wait until #attr-button has a "title" attribute with the "I am title!" value and store it to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void attributeToBeByElement() {
        /*
        STR:
        1) Find attr-button web element and store it to a variable
        2) Wait until button has a "title" attribute with the "I am a title!" value and store it to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void attributeToBeNotEmpty() {
        /*
        STR:
        1) Find attr-button web element and store it to a variable
        2) Wait until button contains a "title" attribute with the "I am a title!" value and store it to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void elementSelectionStateToBeByLocator() {
        /*
        STR:
        1) Wait until bread option is selected and store result to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void elementSelectionStateToBeByElement() {
        /*
        STR:
        1) Find a bread option element and store it to a variable
        2) Wait until milk option is NOT selected and store result to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void elementToBeSelectedByLocator() {
        /*
        STR:
        1) Wait until bread option is selected and store result to a variable
        2) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void elementToBeSelectedByElement() {
        /*
        STR:
        1) Find bread element option and store it to a variable
        2) Wait until bread option is selected and store result to a variable
        3) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void elementToBeClickableByLocator() {
        /*
        STR:
        1) Wait until a 'clickable' element is clickable and store result to a variable
        2) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void elementToBeClickableByElement() {
        /*
        STR:
        1) Find clickable web element and store it to a variable
        2) Wait until found element is clickable and store result to a variable
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void frameToBeAvailableAndSwitchToItByIntLocator() {
        /*
        STR:
        1) Wait until frame available by index and store it to a variable
        2) Find green-table and store it to a variable
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void frameToBeAvailableAndSwitchToItByStringLocator() {
        /*
        STR:
        1) Wait until frame is available by tag
        2) Find a green-table by id
        3) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON
    public void frameToBeAvailableAndSwitchToItByLocator() {
        /*
        STR:
        1) Wait until frame is available by id and store it to a variable
        2) Find green-table and store it to a variable
        3) Assert not null
         */
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

    @Test(enabled = false) // COMING SOON
    public void invisibilityOfAllElementsWebElementArgs() {
        /*
        STR:
        1) Find first-name element and store it to a variable
        2) Find last-name element and store it to a variable
        3) Wait until invisibility of these elements and store it to a variable
        4) Assert true
         */
    }

    @Test(enabled = false) // COMING SOON
    public void invisibilityOfElementLocatedByLocator() {
        /*
        STR:
        1) Wait until invisibility of element located by first-name id and store it to a variable
        2) Assert true
         */
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

    @Test(enabled = false) // COMING SOON
    public void presenceOfElementLocated() {
        /*
        STR:
        1) Wait until element with pull-button id is present and store it to a variable
        2) Assert not null
         */
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
