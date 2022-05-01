# Selenium Web Driver Tests
  
[![CircleCI](https://circleci.com/bb/den44/selenium-webdriver-tests.svg?style=shield&circle-token=beec6688d1137f803b984f0bd3564ba6caaeeb9b)](https://app.circleci.com/pipelines/bitbucket/den44/selenium-webdriver-tests?branch=master&filter=all)

This repository includes selenium tests examples using custom spring boot application.

## Overview

* [Run tests](#run-tests)
* [Additional Information](#additional-information)
* [Selenium Configurations, Features and Methods](#selenium-configurations-features-and-methods)
    * [Install a Selenium Library](#install-a-selenium-library)
    * [Install browser drivers](#install-browser-drivers)
    * [Shared capabilities](#shared-capabilities)
    * [Getting browser information](#getting-browser-information)
    * [Browser navigation](#browser-navigation)
    * [Alerts](#alerts)
    * [Cookies](#cookies)
    * [Frames](#frames)
    * [Windows](#windows)
    * [Elements](#elements)
    * [Waits](#waits)
    * [Actions API](#actions-api)

## Run tests
 
1) Download ChromeDriver  

  * Check your local Chrome browser version and [download](https://chromedriver.storage.googleapis.com/index.html) corresponding chromedriver version  

  * Create the following folder structure  
```bash
mkdir -p /tmp/chromedriver
```

  * Unzip downloaded archive  
```bash
unzip chromedriver_mac64.zip
```

  * Move chromedriver to the `/tmp/chromedriver` location  
```bash
mv ~/Downloads/chromedriver /tmp/chromedriver/
```

2) Clone this repository  
```bash
git clone https://github.com/vznd/selenium-webdriver-tests.git
```

3) Move to a project directory
```bash
cd selenium-webdriver-tests
```

4) Run spring boot application  
```bash
mvn spring-boot:run &
```

5) Run tests  
```bash
mvn test
```

## Additional Information

The 3rd version of selenium is used because the 4th one is in conflict with the Sprint Boot dependencies.

## Selenium Configurations, Features and Methods 

All information is gathered from an official [selenium website](https://www.selenium.dev/documentation/).

### Install a Selenium Library

* [Covered] Selenium Web Driver can be installed using a [maven repository](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java).
  
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>${version}</version>
</dependency>
```

### Install browser drivers

* [Out of scope] Install driver with [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) software

* [Out of scope] The `PATH` Environment Variable  

* [Covered] Hard Coded Location. In this repository the PATH to driver is hardcoded in system variable, in pom.xml:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>${maven-surefire-plugin.version}</version>
            <configuration>
                <systemPropertyVariables>
                    <webdriver.chrome.driver>/path/to/driver</webdriver.chrome.driver>
                </systemPropertyVariables>
            </configuration>
        </plugin>
    </plugins>
</build>
```

### Shared capabilities

Not all the shared capabilities are used in this project. But the reference is provided for all available below.
Please, check an official [documentation](https://www.selenium.dev/documentation/webdriver/capabilities/shared/) for details.

### Getting browser information

* [Covered] Get a web page title. Returns String
```java
driver.getTitle();
```
  
* [Covered] Get a web page URL. Returns String
```java
driver.getCurrentUrl();
```

### Browser navigation

* [Covered] Open a web URL at wikipedia.org
```java
driver.get("https://www.wikipedia.org/");
```

* [Covered] A bit longer way to open a web URL at wikipedia.org
```java
driver.navigate().to("https://www.wikipedia.org/");
```

* [Covered] Press a back browser button
```java
driver.navigate().back();
```

* [Covered] Press a forward browser button
```java
driver.navigate().forward();
```

### Alerts

Alerts are not covered as of now. Should be covered.

* [Covered] Store Alert in a variable using WebDriverWait. Please refer to [Waits](#waits) section for more information about Waits
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // Create wait variable
Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // Get an alert and store to variable
```

* [Covered] There is no ExpectedCondition like "alertIsNotPresent()". So, to check that there is no alert, you can implement helper
```java
public boolean isAlertPresent() {
    try {
        driver.switchTo().alert();
        return true;
    } catch (NoAlertPresentException e) {
        return false;
    }
}
```

* [Covered] Store Alert in a variable using driver
```java
Alert alert = driver.switchTo().alert();
```
  
* [Covered] Get Alert text
```java
alert.getText();
```

* [Covered] Press OK button in the alert
```java
alert.accept();
```

* [Covered] Press Cancel button in the alert
```java
alert.dismiss();
```

* [Covered] Enter some information to a Prompt alert
```java
Alert alert = driver.switchTo().alert(); // Firstly, get the Alert and store in variable
alert.sendKeys("Denny") // Secondly, enter the text
alert.accept(); // Thirdly, press OK button
```

### Cookies

* [To cover] Create a cookie object and store it to a variable
```java
Cookie cookie = new Cookie("key", "value");
```

* [To cover] Add a cookie
```java
driver.manage().addCookie(new Cookie("key", "value"));
```

* [To cover] Get a cookie by name and store it to a variable
```java
Cookie cookie = driver.manage().getCookieNamed("key");
```

* [To cover] Get all cookies and store it to a variable
```java
Set<Cookie> cookies = driver.manage().getCookies();
```

* [To cover] Delete a cookie by name
```java
driver.manage().deleteCookieNamed("key");
```

* [To cover] Delete a cookie by Cookie object
```java
Cookie cookie = new Cookie("key", "value"); // Create a cookie
driver.manage().addCookie(cookie); // Add a cookie
// make some actions here
driver.manage().deleteCookie(cookie); // Delete a cookie
```

* [To cover] Delete all cookies
```java
driver.manage().deleteAllCookies();
```

* [Out of scope] Managing a `Same-Site` cookie attribute

### Frames

* [Covered] Switch to Frame using WebElement
```java
WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe")); // Store the web element
driver.switchTo().frame(iframe); // Switch to the frame
```

* [Covered] Switch to Frame using id
```java
driver.switchTo().frame("buttonframe"); // Using the ID, the same syntax for using the name selector
```

* [Covered] Switch to Frame using name
```java
driver.switchTo().frame("firstframe"); 
```

* [Covered] Switch to Frame using and index
```java
driver.switchTo.frame(1);
```

* [Covered] Leave a frame
```java
driver.switchTo().defaultContent();
```

### Windows

WebDriver does not make the distinction between windows and tabs. If your site opens a new tab or window, 
Selenium will let you work with it using a window handle. Each window has a unique identifier which remains persistent 
in a single session.

* [Covered] Get original window identifier and put it to a variable
```java
String originalWindow = driver.getWindowHandle();
```

* [To cover] Get all opened windows identifiers and store it to a variable
```java
Set<String> allWindows = driver.getWindowHandles();
```

* [To cover] Switch to a different window handle
```java
driver.switchTo().window(windowHandleId); // where windowHandleId is a String with handleId 
```

* [To cover] Wait for certain amount of windows to be opened
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // Define a WebDriverWait
ExpectedCondition<Boolean> expectedCondition = numberOfWindowsToBe(2); // Define expected condition calling numberOfWindowsToBe static method
wait.until(expectedCondition); // Perform wait until expected condition
```

* [To cover] Create a new window switching to a new tab
```java
driver.switchTo().newWindow(WindowType.TAB);
```

* [To cover] Create a new window switching to a new window
```java
driver.switchTo().newWindow(WindowType.WINDOW);
```

* [To cover] Close the tab or window
```java
driver.close();
```

* [To cover] Get window size / dimensions individually
```java
int width = driver.manage().window().getSize().getWidth();
int height = driver.manage().window().getSize().getHeight();
```

* [To cover] Store dimensions in a variable and query them from the object
```java
Dimension size = driver.manage().window().getSize();
int width = size.getWidth();
int height = size.getHeight();
```

* [To cover] Set window size
```java
Dimension dimension = new Dimension(1024, 768); // Create a new dimension object with specified height and width
driver.manage().window().setSize(dimension); // Set window size
```

* [To cover] Get window position / x, y coordinates individually
```java
int x = driver.manage().window().getPosition().getX();
int y = driver.manage().window().getPosition().getY();
```

* [To cover] Store window position in a variable and query x, y coordinates from the object
```java
Point position = driver.manage().window().getPosition();
int x1 = position.getX();
int y1 = position.getY();
```

* [To cover] Set window position
```java
Point position = new Point(0, 0); // Create a new position object with specified x and y
driver.manage().window().setPosition(position); // Set position
```

* [To cover] Maximize window
```java
driver.manage().window().maximize();
```

* [To cover] Minimize window
```java
driver.manage().window().minimize();
```

* [To cover] Enter fullscreen
```java
driver.manage().window().fullscreen();
```

* [To cover] Enter fullscreen
```java
driver.manage().window().fullscreen();
```

* [To cover] Take a screenshot of a window
```java
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Take a screenshot 
FileUtils.copyFile(scrFile, new File("./image.png")); // Store it in the root directory with image.png name
```

* [To cover] Take a screenshot of an element
```java
WebElement element = driver.findElement(By.cssSelector("h1")); // Find an element
File scrFile = element.getScreenshotAs(OutputType.FILE); // Take a screenshot
FileUtils.copyFile(scrFile, new File("./image.png")); // Store it in the root directory with image.png name
```

* [To cover] Execute a JavaScript
```java
JavascriptExecutor js = (JavascriptExecutor)driver; // Define a JavascriptExecutor
js.executeScript("console.log('hello world')"); // Invoke the executeScript method and pass a script as a String argument
```

* [To cover] Execute a JavaScript on a WebElement
```java
JavascriptExecutor js = (JavascriptExecutor)driver; // Define a JavascriptExecutor
WebElement button = driver.findElement(By.name("btnLogin")); // Find a web element
js.executeScript("arguments[0].click();", button); // Perform a click on a button with java script
```

* [To cover] Print page
```java
PrintsPage printer = (PrintsPage) driver; // Define PrintsPage object
PrintOptions printOptions = new PrintOptions(); // Define PrintOptions
printOptions.setPageRanges("1-2"); // Set a range of pages for printing

Pdf pdf = printer.print(printOptions); // Invoke print method and store the result in a Pdf variable
String content = pdf.getContent(); // Invoke a getContent method and store the result in a String variable
```

### Elements

**Traditional locators:**

| Locator           | Description                                                                                                                                   |
|-------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| class name        | Locates elements whose class name contains the search value (compound class names are not permitted)                                          |
| css selector      | Locates elements matching a CSS selector                                                                                                      |
| id                | Locates elements whose ID attribute matches the search value                                                                                  |
| name              | Locates elements whose NAME attribute matches the search value                                                                                |
| link text         | Locates anchor elements whose visible text matches the search value                                                                           |
| partial link text | Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected. |
| tag name          | Locates elements whose tag name matches the search value                                                                                      |
| xpath             | Locates elements matching an XPath expression                                                                                                 |
  
**Relative locators:**  
  
Examples below with the `above`, `below`, `left of`, `right of`, `near` and chaining locators 
are related to the following image: 
  
<img src="https://www.selenium.dev/images/documentation/webdriver/relative_locators.png">

* [Out of scope] Above - find the `<input>` element which is above the `#password` element
```java
By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
```

* [Out of scope] Below - find the `<input>` element which is below the `#email` element
```java
By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
```

* [Out of scope] Left of - find the `<button>` element which is to the left of the `#submit` element
```java
By cancelLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));
```

* [Out of scope] Right of - find the `<button>` element which is to the right of the `#cancel` element
```java
By submitLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));
```

* [Out of scope] Near - find the `<input>` element which is not more than 50px near the `#lbl-email` element
```java
By emailLocator = RelativeLocator.with(By.tagName("input")).near(By.id("lbl-email"));
```

* [Out of scope] Chaining locators - find the `<button>` element which below the `#email` element and to the right of the `#cancel` element
```java
By submitLocator = RelativeLocator.with(By.tagName("button")).below(By.id("email")).toRightOf(By.id("cancel"));
```  
  
**Finders:**  
  
* [To cover] Find the first element which has a class with name `tomatoes`
```java
WebElement vegetable = driver.findElement(By.className("tomatoes"));
```

* [To cover] Find a web element, based on a parent element using two objects
```java
WebElement fruits = driver.findElement(By.id("fruits")); // Find a fruits element (parent in HTML)
WebElement fruit = fruits.findElement(By.id("tomatoes")); // Find a tomatoes child element from the parent fruits element
```

* [To cover] Find a web element, based on a parent element using two locators
```java
WebElement fruit = driver.findElement(By.cssSelector("#fruits .tomatoes"));
```

* [To cover] Find all elements on the page which has `<li>` tag
```java
List<WebElement> plants = driver.findElements(By.tagName("li"));
```

* [To cover] Switch to the element which is currently active
```java
driver.switchTo().activeElement().getAttribute("title")
```
  
**Interactions:**

* [Covered] Click on a web element
```java
buttonElement.click();
```

* [Covered] Fill in input filed with the data
```java
inputElement.sendKeys("some-text");
```

* [Covered] Clear data in the input filed
```java
inputElement.clear();
```
  
**Information:**

* [Covered] Check if element is displayed on the page
```java
WebElement loginForm = driver.findElement(By.css("[name='login']")); // Find an element
boolean isFormVisible = loginForm.isDisplayed(); // Invoke isDisplayed method and put it to a variable
```

* [To cover] Check if element is enabled
```java
WebElement button = driver.findElement(By.name("btnK")); // Find an element
boolean isButtonVisible = button.isEnabled(); // Invoke isEnabled method and put it to a variable
```

* [To cover] Check if element is selected
```java
WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type")); // Find an element
boolean isCheckBoxSelected = checkBox.isSelected(); // Invoke isSelected method and put it to a variable
```

* [To cover] Get a tag name from element
```java
WebElement title = driver.findElement(By.cssSelector("h1")); // Find an element
String tagNameValue = title.getTagName(); // Invoke isSelected method and put it to a variable
```

* [To cover] Get an element height, width, x and y coordinates in a single object
```java
Rectangle res = driver.findElement(By.cssSelector("h1")).getRect(); // Get Rectangle data and put it to a variable
System.out.println(res.getX()); // Get x coordinate and print it to a console
System.out.println(res.getY()); // Get y coordinate and print it to a console
System.out.println(res.getWidth()); // Get getWidth coordinate and print it to a console
System.out.println(res.getHeight()); // Get getHeight coordinate and print it to a console
```

* [To cover] Get CSS value from element
```java
String cssValue = driver.findElement(By.id("login-button")).getCssValue("color");
```

* [To cover] Get text from element
```java
String text = driver.findElement(By.cssSelector("h1")).getText();
```

**Select lists:**

Consider the html below.

```html
<select id="check-box-list-id">
 <option value=value1>Bread</option>
 <option value=value2 selected>Milk</option>
 <option value=value3>Cheese</option>
</select>
```

* [To cover] Initialize select object and store it to a variable
```java
WebElement selectElement = driver.findElement(By.id("check-box-list-id")); // Find a web element
Select selectObject = new Select(selectElement); // Initialize Select object
```

* [To cover] Select option by index
```java
selectObject.selectByIndex(1);
```

* [To cover] Deselect option by index
```java
selectObject.deselectByIndex(1);
```

* [To cover] Select option by its value
```java
selectObject.selectByValue("value1");
```

* [To cover] Deselect option by its value
```java
selectObject.deselectByValue("value1");
```

* [To cover] Select option by visible text
```java
selectObject.selectByVisibleText("Bread");
```

* [To cover] Deselect option by visible text
```java
selectObject.deselectByVisibleText("Bread");
```

* [To cover] Deselect all options
```java
selectObject.deselectAll();
```

* [To cover] Get all *selected* options and store it to a variable
```java
List<WebElement> allSelectedOptions = selectObject.getAllSelectedOptions();
```

* [To cover] Get the first *selected* option and store it to a variable
```java
WebElement firstSelectedOption = selectObject.getFirstSelectedOption();
```

* [To cover] Get all available options and store it to a variable
```java
List<WebElement> allAvailableOptions = selectObject.getOptions();
```

* [To cover] Check if multiple options are selected
```java
Boolean doesThisAllowMultipleSelections = selectObject.isMultiple();
```

### Waits

Waiting is having the automated task execution elapse a certain amount of time before continuing with the next step.
To overcome the problem of race conditions between the browser and your WebDriver script, most Selenium clients ship 
with a wait package. When employing a wait, you are using what is commonly referred to as an explicit wait.

**Explicit wait:**

Explicit waits allow your code to pause a program execution, until the condition you pass it resolves. The condition is 
called with a certain frequency until the timeout of the wait is elapsed.

* [To cover] Initialize a WebDriverWait
```java
WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10));
```

* [To cover] Wait until element becomes clickable
```java
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3"));  
```

* [To cover] Wait until element is found and store it to a variable
```java
WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
          .until(driver -> driver.findElement(By.name("q")));
```

**Expected conditions:**

| Method                                                                                    | Description                                                                                              |
|-------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| alertIsPresent()                                                                          | An expectation for checking Alert to present on the page                                                 |
| and(ExpectedCondition<?>... conditions)                                                   | An expectation with the logical and condition of the given list of conditions                            |
| attributeContains(By locator, java.lang.String attribute, java.lang.String value)         | An expectation for checking WebElement with given locator has attribute which contains specific value    |
| attributeContains(WebElement element, java.lang.String attribute, java.lang.String value) | An expectation for checking WebElement with given locator has attribute which contains specific value    |
| attributeToBe(By locator, java.lang.String attribute, java.lang.String value)             | An expectation for checking WebElement with given locator has attribute with a specific value            |
| attributeToBe(WebElement element, java.lang.String attribute, java.lang.String value)     | An expectation for checking given WebElement has attribute with a specific value                         |
| attributeToBeNotEmpty(WebElement element, java.lang.String attribute                      | An expectation for checking WebElement any non empty value for given attribute                           |
| domAttributeToBe(WebElement element, java.lang.String attribute, java.lang.String value)  | An expectation for checking given WebElement has DOM attribute with a specific value                     |
| domPropertyToBe(WebElement element, java.lang.String property, java.lang.String value)    | An expectation for checking given WebElement has DOM property with a specific value                      |
| elementSelectionStateToBe(By locator, boolean selected)                                   | An expectation for checking if the given element is selected                                             |
| elementSelectionStateToBe(WebElement element, boolean selected)                           | An expectation for checking if the given element is selected                                             |
| elementToBeClickable(By locator)                                                          | An expectation for checking an element is visible and enabled such that you can click it                 |
| elementToBeClickable(WebElement element)                                                  | An expectation for checking an element is visible and enabled such that you can click it                 |
| elementToBeSelected(By locator)                                                           | An expectation for checking if the given element is selected                                             |
| elementToBeSelected(WebElement element)                                                   | An expectation for checking if the given element is selected                                             |
| frameToBeAvailableAndSwitchToIt(int frameLocator)                                         | An expectation for checking whether the given frame is available to switch to                            |
| frameToBeAvailableAndSwitchToIt(java.lang.String frameLocator)                            | An expectation for checking whether the given frame is available to switch to                            |
| frameToBeAvailableAndSwitchToIt(By locator)                                               | An expectation for checking whether the given frame is available to switch to                            |
| frameToBeAvailableAndSwitchToIt(WebElement frameLocator)                                  | An expectation for checking whether the given frame is available to switch to                            |
| invisibilityOf(WebElement element)                                                        | An expectation for checking the element to be invisible                                                  |
| invisibilityOfAllElements(java.util.List<WebElement> elements)                            | An expectation for checking all elements from given list to be invisible                                 |
| invisibilityOfAllElements(WebElement... elements)                                         | An expectation for checking all elements from given list to be invisible                                 |
| invisibilityOfElementLocated(By locator)                                                  | An expectation for checking that an element is either invisible or not present on the DOM                |
| invisibilityOfElementWithText(By locator, java.lang.String text)                          | An expectation for checking that an element with text is either invisible or not present on the DOM      |
| javaScriptThrowsNoExceptions(java.lang.String javaScript)                                 | An expectation to check if js executable                                                                 |
| jsReturnsValue(java.lang.String javaScript)                                               | An expectation for String value from javascript                                                          |
| not(ExpectedCondition<?> condition)                                                       | An expectation with the logical opposite condition of the given condition                                |
| numberOfElementsToBe(By locator, java.lang.Integer number)                                | An expectation for checking number of WebElements with given locator                                     |
| numberOfElementsToBeLessThan(By locator, java.lang.Integer number)                        | An expectation for checking number of WebElements with given locator being less than defined number      |
| numberOfElementsToBeMoreThan(By locator, java.lang.Integer number)                        | An expectation for checking number of WebElements with given locator being more than defined number      |
| numberOfWindowsToBe(int expectedNumberOfWindows)                                          | An expectation for checking number of Windows opened in a current session                                |
| or(ExpectedCondition<?>... conditions)                                                    | An expectation with the logical or condition of the given list of conditions                             |
| presenceOfAllElementsLocatedBy(By locator)                                                | An expectation for checking that there is at least one element present on a web page                     |
| presenceOfElementLocated(By locator)                                                      | An expectation for checking that an element is present on the DOM of a page                              |
| presenceOfNestedElementLocatedBy(By locator, By childLocator)                             | An expectation for checking child WebElement as a part of parent element to present                      |
| presenceOfNestedElementLocatedBy(WebElement element, By childLocator)                     | An expectation for checking child WebElement as a part of parent element to be present                   |
| presenceOfNestedElementsLocatedBy(By parent, By childLocator)                             | An expectation for checking child WebElement as a part of parent element to present                      |
| refreshed(ExpectedCondition<T> condition)                                                 | Wrapper for a condition, which allows for elements to update by redrawing                                |
| stalenessOf(WebElement element)                                                           | Wait until an element is no longer attached to the DOM                                                   |
| textMatches(By locator, java.util.regex.Pattern pattern)                                  | An expectation for checking WebElement with given locator has text with a value as a part of it          |
| textToBe(By locator, java.lang.String value)                                              | An expectation for checking WebElement with given locator has specific text                              |
| textToBePresentInElement(WebElement element, java.lang.String text)                       | An expectation for checking if the given text is present in the specified element                        |
| textToBePresentInElementLocated(By locator, java.lang.String text)                        | An expectation for checking if the given text is present in the element that matches the given locator   |
| textToBePresentInElementValue(By locator, java.lang.String text)                          | An expectation for checking if the given text is present in the specified elements value attribute       |
| textToBePresentInElementValue(WebElement element, java.lang.String text)                  | An expectation for checking if the given text is present in the specified elements value attribute       |
| titleContains(java.lang.String title)                                                     | An expectation for checking that the title contains a case-sensitive substring                           |
| titleIs(java.lang.String title)                                                           | An expectation for checking the title of a page                                                          |
| urlContains(java.lang.String fraction)                                                    | An expectation for the URL of the current page to contain specific text                                  |
| urlMatches(java.lang.String regex)                                                        | Expectation for the URL to match a specific regular expression                                           |
| urlToBe(java.lang.String url)                                                             | An expectation for the URL of the current page to be a specific url                                      |
| visibilityOf(WebElement element)                                                          | An expectation for checking that an element, known to be present on the DOM of a page, is visible        |
| visibilityOfAllElements(java.util.List<WebElement> elements)                              | An expectation for checking that all elements present on the web page that match the locator are visible |
| visibilityOfAllElements(WebElement... elements)                                           | An expectation for checking that all elements present on the web page that match the locator are visible |
| visibilityOfAllElementsLocatedBy(By locator)                                              | An expectation for checking that all elements present on the web page that match the locator are visible |
| visibilityOfElementLocated(By locator)                                                    | An expectation for checking that an element is present on the DOM of a page and visible                  |
| visibilityOfNestedElementsLocatedBy(By parent, By childLocator)                           | An expectation for checking child WebElement as a part of parent element to be visible                   |
| visibilityOfNestedElementsLocatedBy(WebElement element, By childLocator)                  | An expectation for checking child WebElement as a part of parent element to be visible                   |

**Implicit wait:**

By implicitly waiting, WebDriver polls the DOM for a certain duration when trying to find any element.

* [To cover] Implicit wait
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

**Fluent wait:**

FluentWait instance defines the maximum amount of time to wait for a condition, as well as the frequency with which to 
check the condition. Users may configure the wait to ignore specific types of exceptions whilst waiting, 
such as NoSuchElementException when searching for an element on the page.

* [To cover] Waiting 30 seconds for an element to be present on the page, checking for its presence once every 5 seconds
```java
Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofSeconds(5))
        .ignoring(NoSuchElementException.class);

WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
    public WebElement apply(WebDriver driver) {
        return driver.findElement(By.id("foo"));
    }
});
```

### Actions API

Unlike the high-level element interactions, which conducts additional validations, the Actions API provides granular 
control over input devices. Selenium provides access to 3 input sources: key inputs for keyboard devices, pointer 
inputs for a mouse, pen or touch device, and a wheel inputs for scroll wheel support.

**Keyboard:**

* [Covered] Enter a "webdriver" text and perform "ENTER" keyboard action
```java
driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
```

* [Covered] Perform "ENTER" keyboard action using Actions object
```java
Actions action = new Actions(driver);
action.sendKeys(Keys.ENTER).perform();
```

* [Covered] Enters text "qwerty" with keyDown SHIFT key and after keyUp SHIFT key (QWERTYqwerty)
```java
Actions action = new Actions(driver);
WebElement search = driver.findElement(By.name("q"));
action.keyDown(Keys.SHIFT).sendKeys(search,"qwerty").keyUp(Keys.SHIFT).sendKeys("qwerty").perform();
```

**Mouse:**

* [To cover] **Click and hold** mouse
```java
WebElement searchBtn = driver.findElement(By.linkText("Sign in"));
Actions actionProvider = new Actions(driver);
actionProvider.clickAndHold(searchBtn).build().perform();
```

* [To cover] **Right click** on element
```java
WebElement searchBtn = driver.findElement(By.linkText("Sign in"));
Actions actionProvider = new Actions(driver);
actionProvider.contextClick(searchBtn).build().perform();
```

* [To cover] **Double click** on element
```java
WebElement searchBtn = driver.findElement(By.linkText("Sign in"));
Actions actionProvider = new Actions(driver);
actionProvider.doubleClick(searchBtn).build().perform();
```

* [To cover] **Move to element** - scroll to a view where element is located and move mouse cursor to a middle of this element
```java
WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
Actions actionProvider = new Actions(driver);
actionProvider.moveToElement(gmailLink).build().perform();
```

* [Out of scope] **Move by offset** - move the mouse from its current position (or 0,0) to the element
```java
// Store 'Gmail' anchor web element
WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

// Capture x and y offset positions of element
int xOffset = gmailLink.getRect().getX();
int yOffset = gmailLink.getRect().getY();

Actions actionProvider = new Actions(driver);
// Performs mouse move action onto the offset position
actionProvider.moveByOffset(xOffset, yOffset).build().perform();
```

* [Out of scope] **DragAndDrop** - click and hold the source element, move to the location of the target element and then releases the mouse
```java
WebElement sourceEle = driver.findElement(By.id("draggable"));
WebElement targetEle = driver.findElement(By.id("droppable"));
Actions actionProvider = new Actions(driver);
actionProvider.dragAndDrop(sourceEle, targetEle).build().perform();
```

* [Out of scope] **DragAndDropBy** - click and hold the source element, move to the location of the given offset and then releases the mouse
```java
WebElement sourceEle = driver.findElement(By.id("draggable"));
WebElement targetEle = driver.findElement(By.id("droppable"));
int targetEleXOffset = targetEle.getLocation().getX();
int targetEleYOffset = targetEle.getLocation().getY();

Actions actionProvider = new Actions(driver);
actionProvider.dragAndDropBy(sourceEle, targetEleXOffset, targetEleYOffset).build().perform();
``` 

* [Out of scope] **Release** - releases the depressed left mouse button. If WebElement is passed, it will release depressed 
left mouse button on the given WebElement
```java
WebElement sourceEle = driver.findElement(By.id("draggable"));
WebElement targetEle = driver.findElement(By.id("droppable"));

Actions actionProvider = new Actions(driver);
actionProvider.clickAndHold(sourceEle).moveToElement(targetEle).build().perform();
actionProvider.release().build().perform(); 
```