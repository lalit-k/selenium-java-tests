package com.blogspot.automatethebox.application.facebook.test_scripts;

import com.blogspot.automatethebox.tools.selenium.WebDriverService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    protected String facebookUrl;

    @BeforeClass(alwaysRun = true, description = "Start the Browser")
    @Parameters({"browser", "facebook_url"})
    public void startBrowser(@Optional("firefox") String browser,
                             @Optional("http://www.facebook.com") String facebookUrl) {
        this.facebookUrl = facebookUrl;
        driver = WebDriverService.startDriver(browser);
        testSetup();
    }

    @AfterClass(description = "Stop the Browser", alwaysRun = true)
    public void stopBrowser() {
        WebDriverService.stopDriver();
    }

    public abstract void testSetup();
}
