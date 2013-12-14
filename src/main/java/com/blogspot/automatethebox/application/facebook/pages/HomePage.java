package com.blogspot.automatethebox.application.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class HomePage {

    // Page Elements.
    @FindBy(id = "navAccountLink")
    private WebElement accountButton;
    @FindBy(id = "logout_form")
    private WebElement logoutButton;

    // WebDriver instance.
    private WebDriver driver;

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
}
