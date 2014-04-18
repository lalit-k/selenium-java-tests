package com.blogspot.automatethebox.tools.selenium;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class WebDriverService {
    private static WebDriver driver;

    // Current users directory.
    private static final String USER_DIR = System.getProperty("user.dir");

    // Driver exe files directory.
    private static final String DRIVERS_EXE_DIR = USER_DIR + File.separator + "src" + File.separator + "main" +
            File.separator + "java" + File.separator + "com" + File.separator + "blogspot" + File.separator +
            "automatethebox" + File.separator + "tools" + File.separator + "selenium" + File.separator + "resources" +
            File.separator + "drivers_exe";

    // Chrome driver location.
    private static final String CHROME_DRIVER = DRIVERS_EXE_DIR + File.separator + "chromedriver.exe";

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver startDriver(String browser) {
        Preconditions.checkNotNull(browser, "Target browser parameter is null");
        if (WebDriverService.driver != null) {
            throw new AssertionError("Something is wrong... WebDriver instance is tried to be re-initialized");
        }
        if (browser.toLowerCase().equals("htmlunit")) {
            driver = new HtmlUnitDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.toLowerCase().equals("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browser.toLowerCase().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(120L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
