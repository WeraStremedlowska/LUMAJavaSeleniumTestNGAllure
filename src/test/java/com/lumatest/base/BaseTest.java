package com.lumatest.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    private WebDriver driver;
    private final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    protected void setup(@Optional("chrome") String browser, ITestContext context, ITestResult result) {
        driver = BaseUtils.createDriver(browser);
        this.threadLocalDriver.set(driver);

        Reporter.log("Test Thread ID: " + Thread.currentThread().getId(), true);
        Reporter.log("TEST SUIT: " + context.getCurrentXmlTest().getSuite().getName(), true);
        Reporter.log("RUN " + result.getMethod().getMethodName(), true);
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void teardown(@Optional("chrome") String browser, ITestResult result) {
        if (driver != null) {
            if (browser.equals("safari")) {
                driver.close();
            } else {
                driver.quit();

            }
            Reporter.log("INFO: " + browser.toUpperCase() + " driver closed.", true);

            Reporter.log("After Test Thread ID: " + Thread.currentThread().getId(), true);
            threadLocalDriver.remove();
            this.driver = null;
        }
    }

    protected WebDriver getDriver() {
        return threadLocalDriver.get();
    }

}
