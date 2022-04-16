package wiki.alerts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wiki.BaseTest;
import wiki.pages.EditArticlePage;

public class AlertTest extends BaseTest {

    public EditArticlePage editArticlePage;

    @BeforeMethod
    public void preCondition() {
        driver.get("https://en.wikipedia.org/w/index.php?title=Bank&action=edit&section=1");
        editArticlePage = new EditArticlePage(driver);
    }

    @Test
    public void dismissAlert() {
        editArticlePage.clickStartEditingPopup();
        editArticlePage.assertEditArticlePageIsOpen();
        editArticlePage.putTextToTextArea("I am some text.")
                .clickLogo();
        editArticlePage.waitForAlert()
                .dismiss();
        editArticlePage.assertEditArticlePageIsOpen()
                .assertAlertIsNotPresent();
    }

}
