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
 * @author Lalit Kumar Narnaulia
 * https://automatethebox.blogspot.com
 */
public final class WebDriverService {
    private static WebDriver driver;

    private WebDriverService() {
    }

    // Driver executable files directory.
    private static final String DRIVERS_DIR = System.getProperty("user.dir") + File.separator +
        "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" +
        File.separator + "blogspot" + File.separator + "automatethebox" + File.separator + "tools" +
        File.separator + "selenium" + File.separator + "resources" + File.separator + "drivers";

    private static final String IE_DRIVER = DRIVERS_DIR + File.separator + "IEDriverServer.exe";

    public static WebDriver startDriver(String browser) {
        Preconditions.checkNotNull(browser, "Target browser parameter is null");
        if (driver != null) {
            return driver;
        }

        String os = System.getProperty("os.name").toLowerCase();
        switch (browser) {
        case "chrome":
            if (os.startsWith("mac")) {
                System.setProperty("webdriver.chrome.driver",
                    DRIVERS_DIR + File.separator + "chromedriver_mac64_80-0-3987-106");
            } else if (os.startsWith("win")) {
                System.setProperty("webdriver.chrome.driver",
                    DRIVERS_DIR + File.separator + "chromedriver_win32_80-0-3987-106.exe");
            } else {
                System.setProperty("webdriver.chrome.driver",
                    DRIVERS_DIR + File.separator + "chromedriver_linux64_80-0-3987-106.exe");
            }
            driver = new ChromeDriver();
            break;
        case "firefox":
            if (os.startsWith("mac")) {
                System.setProperty("webdriver.gecko.driver",
                    DRIVERS_DIR + File.separator + "geckodriver_macos_0-26-0");
            } else if (os.startsWith("win")) {
                System.setProperty("webdriver.gecko.driver",
                    DRIVERS_DIR + File.separator + "geckodriver_win32_0-26-0.exe");
            } else {
                System.setProperty("webdriver.gecko.driver",
                    DRIVERS_DIR + File.separator + "geckodriver_linux32_0-26-0");
            }
            driver = new FirefoxDriver();
            break;
        case "ie":
            if (!os.startsWith("win")) throw new AssertionError(
                "ie browser on supported on current OS " + os);
            System.setProperty("webdriver.ie.driver",
                DRIVERS_DIR + File.separator + "IEDriverServer_win32_3.150.1.exe");
            driver = new InternetExplorerDriver();
            break;
        case "htmlunit":
            driver = new HtmlUnitDriver();
            break;
        default:
            throw new AssertionError(browser + " not supported");
        }

        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
