package com.lumatest.base;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    private WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    protected void setup( String browser) {
        driver = BaseUtils.createDriver(browser);
        Reporter.log("Browser:" + browser + " is opened");
    }

    @Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void teardown() {
        if (driver != null) {
            driver.quit();
            this.driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}