package com.blogspot.automatethebox.tools.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Lalit Kumar Narnaulia
 * https://automatethebox.blogspot.com
 */
public class WebElementUtils {

    private static final WebDriver driver;

    static {
        driver = WebDriverService.getDriver();
    }

    public static WebElement findElement(final By by) {
        WebElement webElement = null;
        try {
            webElement = new WebDriverWait(driver, 60).until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }
}
