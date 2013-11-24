package com.blogspot.automatethebox.tools.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class TestDriver {
    // TODO: Add all the supported drivers for mac, windows and linux

    protected WebDriver driver;

    public TestDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
    }

}
