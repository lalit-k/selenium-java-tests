package com.blogspot.automatethebox.application.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.testng.Assert.assertEquals;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class HomePage extends LoadableComponent<HomePage> {

    // Page Elements.
    @FindBy(id = "navAccountLink")
    private WebElement accountButton;
    @FindBy(id = "logout_form")
    private WebElement logoutButton;

    // WebDriver instance.
    private WebDriver driver;

    // Page title.
    private static final String TITLE = "Facebook";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Logout from the Facebook application successfully.
     */
    public LoginPage logout() {
        accountButton.click();
        logoutButton.click();
        return new LoginPage(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded()
            throws Error {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, TITLE, "Not on the Facebook Home page.");
    }
}
