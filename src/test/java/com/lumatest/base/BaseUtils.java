package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
                try (InputStream inputStream = BaseUtils.class.getClassLoader().getResourceAsStream("local.properties")) {
                    if (inputStream == null) {
                        System.out.println("ERROR: The local.properties file not found in src/test/resources/ directory.");
                        System.out.println("You need to create it from local.properties.TEMPLATE file.");
                        System.exit(1);
                    }
                    properties.load(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    private static final ChromeOptions chromeOptions = new ChromeOptions();
    private static final FirefoxOptions firefoxOptions = new FirefoxOptions();
    private static final EdgeOptions edgeOptions = new EdgeOptions();
    private static final SafariOptions safariOptions = new SafariOptions();

    static {
        initProperties();
        setupChromeOptions();
        setupFirefoxOptions();
        setupEdgeOptions();
        setupSafariOptions();
    }

    private static void setupChromeOptions() {
        String options = properties.getProperty(PROP_CHROME_OPTIONS);
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }
    }

    private static void setupFirefoxOptions() {
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--window-size=1920,1080");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");
        firefoxOptions.addArguments("--ignore-certificate-errors");
    }

    private static void setupEdgeOptions() {
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--window-size=1920,1080");
        edgeOptions.addArguments("--disable-gpu");
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--disable-dev-shm-usage");
        edgeOptions.addArguments("--disable-web-security");
        edgeOptions.addArguments("--allow-running-insecure-content");
        edgeOptions.addArguments("--ignore-certificate-errors");
    }

    private static void setupSafariOptions() {
        safariOptions.setAutomaticInspection(true);
        safariOptions.setAutomaticProfiling(true);
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(edgeOptions);
    }

    private static WebDriver createSafariDriver() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver(safariOptions);
    }

    public static WebDriver createDriver(String driver) {
        return switch (driver) {
            case "chrome" -> createChromeDriver();
            case "firefox" -> createFirefoxDriver();
            default -> throw new IllegalArgumentException("Unknown driver: " + driver);
        };
    }
}

