package com.blogspot.automatethebox.application.facebook.modules;

import com.blogspot.automatethebox.application.facebook.pages.ProfilePage;
import com.blogspot.automatethebox.application.facebook.pages.ProfilePageImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class FacebookNavigationImpl implements FacebookNavigation {

    // Web Elements.
    @FindBy(xpath = "//li[@id='navTimeline']/a")
    private WebElement profilePageButton;

    // Driver instance.
    private WebDriver driver;

    public FacebookNavigationImpl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public ProfilePage profilePage() {
        profilePageButton.click();
        return new ProfilePageImpl(driver);
    }
}
