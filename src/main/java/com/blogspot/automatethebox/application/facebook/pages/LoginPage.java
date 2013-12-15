package com.blogspot.automatethebox.application.facebook.pages;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.testng.Assert.assertEquals;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class LoginPage extends LoadableComponent<LoginPage> {

    // Page Elements.
    private WebElement email;
    private WebElement pass;
    private WebElement loginbutton;

    // Driver instance.
    private WebDriver driver;

    // Page Url and title.
    private static final String URL = "http://www.facebook.com";
    private static final String TITLE = "Welcome to Facebook - Log In, Sign Up or Learn More";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Login to Facebook application successfully.
     */
    public HomePage loginAs(String emailOrPhone, String password) {
        Preconditions.checkNotNull(emailOrPhone, "Email or phone number parameter is null");
        Preconditions.checkNotNull(password, "Password parameter is null");

        email.sendKeys(emailOrPhone);
        pass.sendKeys(password);
        loginbutton.click();
        return new HomePage(driver);
    }

    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    protected void isLoaded()
            throws Error {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, TITLE, "Not on the Facebook login page.");
    }
}
