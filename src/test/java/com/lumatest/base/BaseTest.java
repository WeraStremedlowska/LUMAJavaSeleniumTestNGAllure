package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    protected void setup() {
        driver = BaseUtils.createDriver();
    }

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
