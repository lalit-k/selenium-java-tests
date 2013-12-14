package com.blogspot.automatethebox.application.facebook.pages;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class LoginPage {

    // Page Elements.
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "pass")
    private WebElement pass;
    @FindBy(id = "loginbutton")
    private WebElement loginButton;

    // Driver instance
    private WebDriver driver;

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
        loginButton.click();
        return new HomePage(driver);
    }
}
