package com.blogspot.automatethebox.application.facebook.pages;

import com.blogspot.automatethebox.application.facebook.modules.FacebookNavigation;

/**
 * @author Lalit Kumar Narnaulia
 * https://automatethebox.blogspot.com
 */
public interface HomePage {
    String APP_TITLE = "Facebook";

    /**
     * Logout from the Facebook application successfully.
     */
    public LoginPage logout();

    /**
     * Facebook pages navigation.
     */
    public FacebookNavigation navigateTo();
}
