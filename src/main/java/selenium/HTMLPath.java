package selenium;

import java.io.File;

public class HTMLPath {

    public static final String prefix = System.getProperty("os.name").contains("Windows") ? "" : "file://";

    public static final String FRAMES = prefix
            + new File("src/test/resources/iframe/iframes.html").getAbsolutePath();

    public static final String SIMPLE_ALERT = prefix
            + new File("src/test/resources/alerts/simple-alert.html").getAbsolutePath();

    public static final String ALERT_WITH_REDIRECT = prefix
            + new File("src/test/resources/alerts/alert-with-redirect.html").getAbsolutePath();

    public static final String PROMPT = prefix
            + new File("src/test/resources/alerts/prompt.html").getAbsolutePath();

    public static final String NAVIGATION = prefix
            + new File("src/test/resources/navigation/navigation.html").getAbsolutePath();

    public static final String CLICK_AND_HOLD = prefix
            + new File("src/test/resources/actions/click-and-hold.html").getAbsolutePath();

    public static final String CONTEXT_CLICK = prefix
            + new File("src/test/resources/actions/context-click.html").getAbsolutePath();

    public static final String DOUBLE_CLICK = prefix
            + new File("src/test/resources/actions/double-click.html").getAbsolutePath();

    public static final String MOVE_TO_ELEMENT = prefix
            + new File("src/test/resources/actions/move-to-element.html").getAbsolutePath();

    public static final String DRAG_AND_DROP = prefix
            + new File("src/test/resources/actions/drag-and-drop.html").getAbsolutePath();

    public static final String KEYBOARD = prefix
            + new File("src/test/resources/actions/keyboard.html").getAbsolutePath();

}
