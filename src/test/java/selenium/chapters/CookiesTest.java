package selenium.chapters;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.BaseTest;

public class CookiesTest extends BaseTest {

    @BeforeTest // COMING SOON
    public void createCookieAndStoreItToVariable() {
        // STR: - create a cookie variable
    }

    @Test // COMING SOON
    public void addCookie() {
        /*
        STR:
        1) Add a cookie which was created in @BeforeTest
        2) Assert a new cookie was added
         */
    }

    @Test // COMING SOON
    public void getCookieByName() {
        /*
        1) Add a cookie which was created in @BeforeTest
        2) Get this cookie by name
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
        1) Add a cookie which was created in @BeforeTest
        2) Delete a cookie by object
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
