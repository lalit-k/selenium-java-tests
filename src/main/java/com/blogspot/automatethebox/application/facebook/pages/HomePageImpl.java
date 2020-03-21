package com.blogspot.automatethebox.application.facebook.pages;

import com.blogspot.automatethebox.application.facebook.modules.FacebookNavigation;
import com.blogspot.automatethebox.application.facebook.modules.FacebookNavigationImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.testng.Assert.assertEquals;

/**
 * @author Lalit Kumar Narnaulia
 * https://automatethebox.blogspot.com
 */
public class HomePageImpl extends LoadableComponent<HomePageImpl> implements HomePage {

    // Page Elements.
    @FindBy(id = "navAccountLink")
    private WebElement accountButton;
    @FindBy(id = "logout_form")
    private WebElement logoutButton;

    // WebDriver instance.
    private WebDriver driver;

    public HomePageImpl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, APP_TITLE, "Not on the Facebook Home page.");
    }

    @Override
    public LoginPage logout() {
        accountButton.click();
        logoutButton.click();
        return new LoginPageImpl(driver);
    }

    @Override
    public FacebookNavigation navigateTo() {
        return new FacebookNavigationImpl(driver);
    }
}
