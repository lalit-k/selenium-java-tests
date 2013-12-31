package com.blogspot.automatethebox.application.facebook.modules;

/**
 * This Represents the Facebook status update panel displayed on home page.
 *
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public interface UpdateStatusPanel {

    /**
     * Update current user Facebook status.
     *
     * @param status text status
     */
    UpdateStatusPanel updateStatus(String status);
}
