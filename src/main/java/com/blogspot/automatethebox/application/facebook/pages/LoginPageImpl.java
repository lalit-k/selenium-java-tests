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
public class LoginPageImpl extends LoadableComponent<LoginPageImpl> implements LoginPage {

    // Page Elements.
    private WebElement email;
    private WebElement pass;
    private WebElement loginbutton;

    // Driver instance.
    private WebDriver driver;

    public LoginPageImpl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    @Override
    public HomePage loginAs(String emailOrPhone, String password) {
        Preconditions.checkNotNull(emailOrPhone, "Email or phone number parameter is null");
        Preconditions.checkNotNull(password, "Password parameter is null");

        email.sendKeys(emailOrPhone);
        pass.sendKeys(password);
        loginbutton.click();
        return new HomePageImpl(driver);
    }
}
