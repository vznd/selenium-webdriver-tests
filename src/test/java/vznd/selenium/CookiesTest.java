package vznd.selenium;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test // COMING SOON
    public void deleteCookieByName() {
        /*
        STR:
        1) Delete a cookie by name
        3) Assert cookie was deleted
         */
    }

    @Test // COMING SOON
    public void deleteCookieByCookieObject() {
        /*
        STR:
        1) Create a cookie and store it to a variable (COOKIE_KEY, COOKIE_VALUE)
        2) Add a cookie
        3) Delete a cookie by object
        3) Assert cookie was deleted
         */
    }

    @Test // COMING SOON
    public void deleteAllCookies() {
        /*
        STR:
        1) Get all cookies
        2) Assert that size of cookies is NOT 0
        3) Delete all cookies
        4) Assert that size is 0
         */
    }

}
