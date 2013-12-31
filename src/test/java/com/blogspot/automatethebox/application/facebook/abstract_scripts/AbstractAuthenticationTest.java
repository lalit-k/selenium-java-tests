package com.blogspot.automatethebox.application.facebook.abstract_scripts;

import com.blogspot.automatethebox.application.facebook.pages.HomePage;
import com.blogspot.automatethebox.application.facebook.pages.LoginPage;
import com.blogspot.automatethebox.application.facebook.pages.LoginPageImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public abstract class AbstractAuthenticationTest extends AbstractTest {
    protected HomePage homePage;

    @BeforeClass(description = "Facebook Login")
    @Parameters({"facebook_user_name", "facebook_user_password"})
    public void login(String emailOrPhone, String password) {
        LoginPage loginPage = new LoginPageImpl(driver).get();
        homePage = loginPage.loginAs(emailOrPhone, password);
    }

    @AfterClass(description = "Facebook Logout")
    public void logout() {
        homePage.logout();
    }
}
