package selenium.chapters.actions;

import org.testng.annotations.Test;
import selenium.BaseTest;

public class MouseActionsTest extends BaseTest {

    @Test
    public void clickAndHold() {
        /*
        STR:
        1) Open click and hold
        2) Find green-button
        3) Define Actions object
        4) Build action to clickAndHold on button and perform it
        5) Get actual background color of button and store it to a variable
        6) Define expected background color, store it to a variable
        7) Assert actual and expected equals
         */
    }

    @Test
    public void contextClick() {
        /*
        STR:
        1) Open context click html
        2) Find green-button
        3) Define Actions object
        4) Build action to doubleCLick on button and perform it
        5) Assert an element with context menu assert it is displayed
         */
    }

    @Test
    public void doubleClick() {
        /*
        STR:
        1) Open double click html
        2) Find green-button
        3) Define Actions object
        4) Build action to doubleCLick on button and perform it
        5) Assert an element has red backround color
         */
    }

    @Test
    public void moveToElement() {
        /*
        STR:
        1) Open move to element html
        2) Find green-button and store it to a variable
        3) Initialize Actions object
        4) Perform move to element
        5) Assert something
         */
    }

}
