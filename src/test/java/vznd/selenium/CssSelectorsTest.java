package vznd.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorsTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.CSS_SELECTORS);
    }

    @Test(enabled = false) // COMING SOON | .class
    public void selectAllElementsWithClass() {
        /* STR:
        1) Define By css variable with css selector of play button / by class
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected button text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON | #id
    public void selectAllElementsWithId() {
        /* STR:
        1) Define By css variable with css selector with id
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected button text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON | .class, #id
    public void selectAllElementsWithClassAndId() {
        /* STR:
        1) Define By css variable with css selector with class and id
        2) Add a break line
        3) Find elementS by its css selector, get size and store result to a variable
        4) Define expected size
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON | tag
    public void selectAllElementsWithTag() {
        /* STR:
        1) Define By css variable with css selector with tag name
        2) Add a break line
        3) Find element by its css selector and store result to a variable
        4) Assert not null
         */
    }

    @Test(enabled = false) // COMING SOON | tag, tag
    public void selectAllElementsWithTagAndAnotherTag() {
        /* STR:
        1) Define By css variable with css selector with label and textarea
        2) Add a break line
        3) Find elementS by its css selector, get size and store result to a variable
        4) Define expected size
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON | tag tag
    public void selectAllElementsWithTagThatAreInsideAnotherTag() {
        /* STR:
        1) Define By css variable with css selector with article by div parent
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON | tag > tag
    public void selectAllElementsWithTagWithParentTag() {
        /* STR:
        1) Define By css variable with css selector with p by div parent
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON tag + tag
    public void selectAllElementsWithTagThatAreNextToAnotherTag() {
        /* STR:
        1) Define By css variable with css selector with textarea which is next to div
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON tag ~ tag
    public void selectAllElementsThatAreSiblingsOfAnotherElement() {
        /* STR:
        1) Define By css variable with css selector with all ul elements which are next to p element
        2) Add a break line
        3) Find elementS by its css selector, get size and store result to a variable
        4) Define expected size
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON *
    public void selectAllElements() {
        /* STR:
        1) Define By css variable with css selector with all elements
        2) Add a break line
        3) Find elementS by its css selector, get size and store result to a variable
        4) Define expected size
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON tag.class
    public void selectAllElementsWithTagAndClass() {
        /* STR:
        1) Define By css variable with css selector with button and class
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON [id]
    public void selectAllElementsWithIdAttribute() {
        /* STR:
        1) Define By css variable with css selector with all elements that have id attribute
        2) Add a break line
        3) Find elementS by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON [id='some-id']
    public void selectAllElementsWithSpecificIdAttribute() {
        /* STR:
        1) Define By css variable with css selector with id equal to 'selenium
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON [id$='ending']
    public void selectAllElementsWithIdSpecificEnding() {
        /* STR:
        1) Define By css variable with css selector with id ending with -up
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON [id|=starting]
    public void selectAllElementsWithIdSpecificStartingAbdFollowingByHyphen() {
        /* STR:
        1) Define By css variable with css selector with id equal to 'selenium
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON [id^=starting]
    public void selectAllElementsWithIdSpecificStarting() {
        /* STR:
        1) Define By css variable with css selector with id starting with 'x'
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON [attribute~=word]
    public void selectAllElementsElementsWithAttributeContaining() {
        /* STR:
        1) Define By css variable with css selector with title containing with text
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON [id*=string]
    public void selectAllElementsElementsWithIDContainingString() {
        /* STR:
        1) Define By css variable with css selector with title containing string gg
        2) Add a break line
        3) Find element by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON :checked
    public void selectAllCheckedFormElements() {
        /* STR:
        1) Define By css variable with css selector with checked attribute
        2) Add a break line
        3) Find element by its css selector, get name attribute and store result to a variable
        4) Define expected attribute value
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON :disabled
    public void selectAllDisabledFormElements() {
        /* STR:
        1) Define By css variable with css selector with disabled attribute
        2) Add a break line
        3) Find element by its css selector, get name attribute and store result to a variable
        4) Define expected attribute value
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON :enabled
    public void selectAllEnabledFormElements() {
        /* STR:
        1) Define By css variable with css selector with enabled input and user-data class
        2) Add a break line
        3) Find element by its css selector, get name attribute and store result to a variable
        4) Define expected attribute value
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON :empty
    public void selectAllEmptyElements() {
        /* STR:
        1) Define By css variable with css selector with empty elements
        2) Add a break line
        3) Find elementS by its css selector, get size and store result to a variable
        4) Define expected size
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON tag:first-of-type
    public void selectAllElementsThatAreTheFirstElementOfTheirParent() {
        /* STR:
        1) Define By css variable with css selector with i element that is the first i element of its parent
        2) Add a break line
        3) Find elementS by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON tag:hover
    public void selectAllElementsWhenTheyAreHovered() {
        /* STR:
        1) Define actions object, call move to element(by 'boom' id) and perform this action
        2) Define By css variable with css selector with button hover
        2) Add a break line
        3) Find elementS by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON input:in-range
    public void selectAllInputElementsWithMaxOrMinValueWhenValueIsInRange() {
        /* STR:
        1) Define By css variable with css selector with input in range and age class
        2) Add a break line
        3) Find elementS by its css selector, get id attribute and store result to a variable
        4) Define expected id attribute value
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON input:out-of-range
    public void selectAllInputElementsWithMaxOrMinValueWhenValueIsOutOfRange() {
        /* STR:
        1) Define By css variable with css selector with input out of range and age class
        2) Add a break line
        3) Find elementS by its css selector, get id attribute and store result to a variable
        4) Define expected id attribute value
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON input:invalid
    public void selectAllInputElementsWithMaxOrMinValueWhenValueIsInvalidAccordingToLimitations() {
        /* STR:
        1) Define By css variable with css selector with input invalid and age class
        2) Add a break line
        3) Find elementS by its css selector, get id attribute and store result to a variable
        4) Define expected id attribute value
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON input:valid
    public void selectAllInputElementsWithMaxOrMinValueWhenValueIsValidAccordingToLimitations() {
        /* STR:
        1) Define By css variable with css selector with input valid and age class
        2) Add a break line
        3) Find elementS by its css selector, get id attribute and store result to a variable
        4) Define expected id attribute value
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON tag:lang(it)
    public void selectAllElementsWithAttributeValueEqualTo() {
        /* STR:
        1) Define By css variable with css selector with p element with lang equal to 'it'
        2) Add a break line
        3) Find elementS by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON tag:last-child
    public void selectAllElementsThatAreTheLastChildOfTheirParent() {
        /* STR:
        1) Define By css variable with css selector with strong element is last child of his parent
        2) Add a break line
        3) Find elementS by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON tag:last-of-type
    public void selectAllElementsThatAreTheLastChildWithThisTypeOfTheirParent() {
        /* STR:
        1) Define By css variable with css selector with strong element is last child of his parent
        2) Add a break line
        3) Find elementS by its css selector, get text and store result to a variable
        4) Define expected text
        5) Assert equals
         */
    }

    @Test(enabled = false) // COMING SOON :root
    public void selectTheDocumentsRootElement() {
        /* STR:
        1) Define By css variable with css selector with root element
        2) Add a break line
        3) Find elementS by its css selector, get size and store result to a variable
        4) Define expected size
        5) Assert equals
         */
    }

}
