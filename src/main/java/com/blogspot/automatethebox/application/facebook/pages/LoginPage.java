package com.blogspot.automatethebox.application.facebook.pages;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public interface LoginPage {
    String URL = "http://www.facebook.com";
    String TITLE = "Welcome to Facebook - Log In, Sign Up or Learn More";

    /**
     * Login to Facebook application successfully.
     *
     * @param emailOrPhone user login email address or phone number
     * @param password     user password
     */
    public HomePage loginAs(String emailOrPhone, String password);
}
