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

}
