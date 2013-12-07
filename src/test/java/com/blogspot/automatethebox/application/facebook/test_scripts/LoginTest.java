package com.blogspot.automatethebox.application.facebook.test_scripts;

import com.blogspot.automatethebox.application.facebook.pages.LoginPage;
import com.google.common.base.Preconditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class LoginTest extends AbstractTest {
    private LoginPage loginPage;

    @Override
    public void testSetup() {
        driver.get(facebookUrl);
        loginPage = new LoginPage();
    }

    @Test(description = "Facebook Login > Logout")
    @Parameters({"facebook_user_name", "facebook_user_password"})
    public void testMethod(String username, String password) {
        Preconditions.checkNotNull(username, "user name parameter is null");
        Preconditions.checkNotNull(password, "password parameter is null");

        // Login to Facebook [ Change the email and password to your test fb accounts ]
        loginPage.login(username, password);

        // Logout
        loginPage.logout();
    }
}
