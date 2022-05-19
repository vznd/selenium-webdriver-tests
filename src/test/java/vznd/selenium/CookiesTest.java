package vznd.selenium;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class CookiesTest extends BaseTest {

    public final String COOKIE_KEY = "locale";
    public final String COOKIE_VALUE = "EN";

    @BeforeMethod
    public void preCondition() {
        driver.get(HTMLPath.COOKIES);
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteCookieNamed(COOKIE_KEY);
    }

    @Test
    public void addCookie() {
        Cookie cookie = new Cookie(COOKIE_KEY, COOKIE_VALUE);
        driver.manage().addCookie(cookie);
        Cookie actualCookie = driver.manage().getCookieNamed(COOKIE_KEY);
        Assert.assertNotNull(actualCookie, "The cookie with name '" + COOKIE_KEY + "' was not added!");
    }

    @Test
    public void getCookieByName() {
        String actualCookieValue = driver.manage().getCookieNamed("token").getValue();
        String expectedCookieValue = "Aoh_fBqPqArRR0BQM";
        Assert.assertEquals(actualCookieValue, expectedCookieValue,
                "The cookie value with key '" + COOKIE_KEY + "' was not '" + expectedCookieValue + "'!");
    }

    @Test
    public void getAllCookies() {
        int actualCookiesSize = driver.manage().getCookies().size();
        int expectedCookiesSize = 2;
        Assert.assertEquals(actualCookiesSize, expectedCookiesSize,
                "The cookies size was not " + expectedCookiesSize + "!");
    }

    @Test
    public void deleteCookieByName() {
        driver.manage().deleteCookieNamed("token");
        int actualCookiesSize = driver.manage().getCookies().size();
        int expectedCookiesSize = 1;
        Assert.assertEquals(actualCookiesSize, expectedCookiesSize,
                "The cookie was not deleted! The cookies size was not " + expectedCookiesSize + "!");
    }

    @Test
    public void deleteCookieByCookieObject() {
        Cookie cookie = new Cookie(COOKIE_KEY, COOKIE_VALUE);
        driver.manage().addCookie(cookie);
        driver.manage().deleteCookie(cookie);
        int actualCookiesSize = driver.manage().getCookies().size();
        int expectedCookiesSize = 2;
        Assert.assertEquals(actualCookiesSize, expectedCookiesSize,
                "The cookie was not deleted! The cookies size was not " + expectedCookiesSize + "!");
    }

    @Test
    public void deleteAllCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        Assert.assertFalse(cookies.isEmpty(), "The cookies size was equal to 0!");
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        Assert.assertTrue(cookies.isEmpty(),
                "The cookies were not deleted! The cookies size was " + cookies.size() + "!");
    }

}
