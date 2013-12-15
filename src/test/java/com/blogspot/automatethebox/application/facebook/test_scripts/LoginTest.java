package com.blogspot.automatethebox.application.facebook.test_scripts;

import com.blogspot.automatethebox.application.facebook.pages.HomePage;
import com.blogspot.automatethebox.application.facebook.pages.LoginPage;
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
        loginPage = new LoginPage(driver).get();
    }

    @Test(description = "Facebook Login > Logout")
    @Parameters({"facebook_user_name", "facebook_user_password"})
    public void testMethod(String emailOrPhone, String password) {

        // Login to Facebook.
        HomePage homePage = loginPage.loginAs(emailOrPhone, password);

        // Logout.
        homePage.logout();
    }
}
