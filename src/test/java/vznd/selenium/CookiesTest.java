package vznd.selenium;

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

    @Test // COMING SOON
    public void addCookie() {
        /*
        STR:
        1) Create a cookie and store it to a variable (COOKIE_KEY, COOKIE_VALUE)
        2) Add a cookie
        3) Assert a new cookie was added
         */
    }

    @Test // COMING SOON
    public void getCookieByName() {
        /*
        1) Get cookie by name
        3) Assert cookie value
         */
    }

    @Test // COMING SOON
    public void getAllCookies() {
        /*
        STR:
        1) Get all cookies
        2) Assert cookies size match expected
         */
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
