package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public final class BaseUtils {
    private static final String ENV_CHROME_OPTIONS = "CHROME_OPTIONS";
    private static final String ENV_BROWSER_OPTIONS = "BROWSER_OPTIONS";

    private static final String PREFIX_PROP = "default.";
    private static final String PROP_CHROME_OPTIONS = PREFIX_PROP + ENV_CHROME_OPTIONS.trim().toLowerCase();

    private static Properties properties;

    private static void initProperties() {
        if (properties == null) {
            properties = new Properties();
            if (isServerRun()) {
                properties.setProperty(PROP_CHROME_OPTIONS, System.getenv(ENV_CHROME_OPTIONS));
                if (System.getenv(ENV_BROWSER_OPTIONS) != null) {
                    for (String option : System.getenv(ENV_BROWSER_OPTIONS).split(";")) {
                        String[] browserOptionArr = option.split("=");
                        properties.setProperty(browserOptionArr[0], browserOptionArr[1]);
                    }
                }
            } else {
                try {
                    InputStream inputStream = BaseUtils.class.getClassLoader().getResourceAsStream("local.properties");
                    if (inputStream == null) {
                        System.out.println("ERROR: The \u001B[31mlocal.properties\u001B[0m file not found in src/test/resources/ directory.");
                        System.out.println("You need to create it from local.properties.TEMPLATE file.");
                        System.exit(1);
                    }
                    properties.load(inputStream);
                } catch (IOException ignore) {
                }
            }
        }
    }

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    private static final ChromeOptions chromeOptions;

    static {
        initProperties();

        chromeOptions = new ChromeOptions();

        String options = properties.getProperty(PROP_CHROME_OPTIONS);
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.executeCdpCommand("Network.enable", Map.of());
        driver.executeCdpCommand("Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9")));
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createSafariDriver() {
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        System.setProperty("webdriver.safari.verboseLogging", "true");
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setAutomaticInspection(true);
        safariOptions.setAutomaticProfiling(true);
        try {
            System.out.println("Setting up SafariDriver");
            WebDriverManager.getInstance(SafariDriver.class).setup();
            System.out.println("Creating SafariDriver instance");
            WebDriver driver = new SafariDriver(safariOptions);
            System.out.println("SafariDriver instance created successfully");
            return driver;
        } catch (Exception e) {
            System.err.println("Error creating SafariDriver: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }



    public static WebDriver createDriver(String driver) {
        switch (driver) {
            case "chrome" -> {
                return createChromeDriver();
            }
            case "firefox" -> {
                return createFirefoxDriver();
            }
            case "edge" -> {
                return createEdgeDriver();
            }
            case "safari" -> {
                return createSafariDriver();
            }
            default -> throw new IllegalArgumentException("Unknown driver: " + driver);
        }
    }
}
