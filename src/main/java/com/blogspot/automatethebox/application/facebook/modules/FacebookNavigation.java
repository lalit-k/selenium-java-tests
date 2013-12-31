package com.blogspot.automatethebox.application.facebook.modules;

import com.blogspot.automatethebox.application.facebook.pages.ProfilePage;

/**
 * Represents the facebook pages navigation functionality.
 *
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public interface FacebookNavigation {
    /**
     * Navigate to the facebook home page 'http://www.facebook.com'.
     */
    public ProfilePage profilePage();
}
