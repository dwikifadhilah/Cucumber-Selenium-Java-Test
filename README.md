# Cucumber-Selenium-Java-Test

## Web Automation Testing Using Cucumber

Tested Web http://qa.cilsy.id:8080/

### How To Change Firefox Browser
Change WebDriverManager in file Hook.java

```java 
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
```

### How To Run tests
We can run the tests using the test runner file for Cucumber which is located in the package runner with a file called TestRunner.java
