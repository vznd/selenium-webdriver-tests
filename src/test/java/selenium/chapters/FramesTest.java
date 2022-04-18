package selenium.chapters;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.BaseTest;

import java.io.File;

public class FramesTest extends BaseTest {

    @BeforeTest
    public void openPageWithIframes() {
        File resourcesDirectory = new File("src/test/resources/iframe/iframes.html");
        String path = resourcesDirectory.getAbsolutePath();
        driver.get(path);
    }

    @Test // COMING SOON
    public void switchToFrameUsingWebElement() {
        /*
        STR:
        1) Find a web element with frame
        2) Switch to frame by this element
        3) Find some element in this frame
        4) Assert some data(or that found element is not null) within this frame
         */
    }

    @Test // COMING SOON
    public void switchToFrameUsingId() {
        /*
        STR:
        1) Switch to frame by ID
        2) Find some element in this frame
        3) Assert some data(or that found element is not null) within this frame
         */
    }

    @Test // COMING SOON
    public void switchToFrameUsingName() {
        /*
        STR:
        1) Switch to frame by name
        2) Find some element in this frame
        3) Assert some data(or that found element is not null) within this frame
         */
    }

    @Test // COMING SOON
    public void switchToFrameUsingIndex() {
        /*
        STR:
        1) Switch to frame by index
        2) Find some element in this frame
        3) Assert some data(or that found element is not null) within this frame
         */
    }

    @Test // COMING SOON
    public void switchToDefaultContext() {
        /*
        STR:
        1) Switch to frame
        2) Find some element in this frame
        3) Assert some data(or that found element is not null) within this frame
        4) Switch to default content
        5) Assert some data in default content
         */
    }

}
