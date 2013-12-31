package com.blogspot.automatethebox.application.facebook.abstract_scripts;

import com.blogspot.automatethebox.tools.selenium.WebDriverService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public abstract class AbstractTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true, description = "Start the Browser")
    @Parameters("browser")
    public void startBrowser(@Optional("firefox") String browser) {
        driver = WebDriverService.startDriver(browser);
        testSetup();
    }

    @AfterClass(description = "Stop the Browser", alwaysRun = true)
    public void stopBrowser() {
        WebDriverService.stopDriver();
    }

    public abstract void testSetup();
}
