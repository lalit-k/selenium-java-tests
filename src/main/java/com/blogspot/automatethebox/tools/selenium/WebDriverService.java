package com.blogspot.automatethebox.tools.selenium;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class WebDriverService {
    private static WebDriver driver;

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
