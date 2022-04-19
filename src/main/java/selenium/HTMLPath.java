package selenium;

import java.io.File;

public class HTMLPath {

    public static final String FRAMES =
            new File("src/test/resources/iframe/iframes.html").getAbsolutePath();

    public static final String SIMPLE_ALERT =
            new File("src/test/resources/alerts/simple-alert.html").getAbsolutePath();

    public static final String ALERT_WITH_REDIRECT =
            new File("src/test/resources/alerts/alert-with-redirect.html").getAbsolutePath();

    public static final String PROMPT =
            new File("src/test/resources/alerts/prompt.html").getAbsolutePath();

}
