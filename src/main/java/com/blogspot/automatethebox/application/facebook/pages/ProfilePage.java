package com.blogspot.automatethebox.application.facebook.pages;

/**
 * Represents the user profile page.
 *
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public interface ProfilePage {

    /**
     * Update current user Facebook status.
     *
     * @param status text status
     */
    public ProfilePage updateStatus(String status);

    /**
     * Get user most recent status.
     */
    public String getRecentStatus();
}