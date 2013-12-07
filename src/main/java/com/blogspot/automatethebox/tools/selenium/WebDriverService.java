package com.blogspot.automatethebox.tools.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        if (WebDriverService.driver != null) {
            throw new AssertionError("Something is wrong... WebDriver instance is tried to be re-initialized");
        }
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
