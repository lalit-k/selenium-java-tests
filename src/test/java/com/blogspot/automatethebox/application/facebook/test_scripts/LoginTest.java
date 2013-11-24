package com.blogspot.automatethebox.application.facebook.test_scripts;

import com.blogspot.automatethebox.application.facebook.pages.LoginPage;
import com.blogspot.automatethebox.tools.selenium.TestDriver;
import org.testng.annotations.Test;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class LoginTest extends TestDriver {

    // Pages.
    private LoginPage loginPage;

    public LoginTest() {
        driver.get("https://www.facebook.com");
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Facebook Login > Logout")
    public void testMethod() {

        // Login to Facebook [ Change the email and password to your test fb accounts ]
        loginPage.login("test email", "test password");

        // Logout
        loginPage.logout();

        // Kill driver
        driver.quit();
    }
}
