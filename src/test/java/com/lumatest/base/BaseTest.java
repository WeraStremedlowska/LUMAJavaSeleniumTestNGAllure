package com.lumatest.base;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    private WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    protected void setup(@Optional("chrome") String browser) {
        driver = BaseUtils.createDriver(browser);
        Reporter.log("Browser:" + browser + " is opened");
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void teardown(@Optional("chrome") String browser) {
        if (driver != null) {
            if (browser.equals("safari")) {
                driver.close();
            } else {
                driver.quit();
            }
            this.driver = null;
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }

}
