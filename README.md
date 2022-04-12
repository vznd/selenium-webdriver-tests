# Selenium Web Driver Tests
  
[![CircleCI](https://circleci.com/bb/den44/selenium-webdriver-tests.svg?style=shield&circle-token=beec6688d1137f803b984f0bd3564ba6caaeeb9b)](https://app.circleci.com/pipelines/bitbucket/den44/selenium-webdriver-tests?branch=master&filter=all)

This repository includes selenium tests examples using [wikipedia.org](https://www.wikipedia.org/).

## Overview

* [Run tests](#run-tests)
* [Selenium Configurations, Features and Methods](#selenium-configurations-features-and-methods)
    * [Install a Selenium Library](#install-a-selenium-library)
    * [Install browser drivers](#install-browser-drivers)
    * [Open Browsers](#open-browsers)
    * [Shared capabilities](#shared-capabilities)
    * [Getting browser information](#getting-browser-information)
    * [Browser navigation](#browser-navigation)
    * [Alerts](#alerts)
    * [Cookies](#cookies)
    * [Frames](#frames)
    * [Windows](#windows)
    * [Elements](#elements)

## Run tests

To run tests on your local machine, you need to do the following steps:  
1) Create the following folder structure on your PC `/tmp/chromedriver`  
2) Check your local Chrome browser version and download corresponding chromedriver on your local machine. You can use an official Chrome [web page](https://chromedriver.storage.googleapis.com/index.html).  
3) Unzip downloaded archive, e.g. `chromedriver_mac64.zip`  
4) Put the unarchived file to the created folder on the 1st step, so you have your driver under the following location: `/tmp/chromedriver`  
5) Clone this repository  
6) Run `mvn test`

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

### Open Browsers

* [Covered] Chrome
```java
ChromeOptions options = new ChromeOptions();
driver = new ChromeDriver(options); // Opens a new browser session
  
driver.quit(); // Closes browser
```

* [To cover] Edge
* [To cover] Firefox
* [To cover] Internet Explorer
* [To cover] Opera
* [To cover] Safari  
  
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

* [To cover] Press a back browser button
```java
driver.navigate().back();
```

* [To cover] Press a forward browser button
```java
driver.navigate().forward();
```

### Alerts

Alerts are not covered as of now. Should be covered.

* [To cover] Store Alert in a variable using WebDriverWait. Please refer to [Waits](#waits) section for more information about Waits
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // Create wait variable
Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // Get an alert and store to variable
```

* [To cover] Store Alert in a variable using driver
```java
Alert alert = driver.switchTo().alert();
```
  
* [To cover] Get Alert text
```java
alert.getText();
```

* [To cover] Press OK button in the alert
```java
alert.accept();
```

* [To cover] Press Cancel button in the alert
```java
alert.dismiss();
```

* [To cover] Enter some information to a Prompt alert
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

* [Out of scope] Managing a `Same-Site` cookie attribute

### Frames

* [Out of scope] Switch to Frame using WebElement
```java
WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe")); // Store the web element
driver.switchTo().frame(iframe); // Switch to the frame
```

* [Out of scope] Switch to Frame using name or id
```java
driver.switchTo().frame("buttonframe"); // Using the ID, the same syntax for using the name selector
```

* [Out of scope] Switch to Frame using and index
```java
driver.switchTo.frame(1);
```

* [Out of scope] Leave a frame
```java
driver.switchTo().defaultContent();
```

### Windows

WebDriver does not make the distinction between windows and tabs. If your site opens a new tab or window, 
Selenium will let you work with it using a window handle. Each window has a unique identifier which remains persistent 
in a single session.

* [To cover] Get original window identifier and put it to a variable
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
  
Examples below with the `above`, `below`, `left of`, `right of`, `near` and chaining locators 
are related to the following image: 
  
<img src="https://www.selenium.dev/images/documentation/webdriver/relative_locators.png">

* [To cover] Above - find the `<input>` element which is above the `#password` element
```java
By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
```

* [To cover] Below - find the `<input>` element which is below the `#email` element
```java
By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
```

* [To cover] Left of - find the `<button>` element which is to the left of the `#submit` element
```java
By cancelLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));
```

* [To cover] Right of - find the `<button>` element which is to the right of the `#cancel` element
```java
By submitLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));
```

* [To cover] Near - find the `<input>` element which is not more than 50px near the `#lbl-email` element
```java
By emailLocator = RelativeLocator.with(By.tagName("input")).near(By.id("lbl-email"));
```

* [To cover] Chaining locators - find the `<button>` element which below the `#email` element and to the right of the `#cancel` element
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