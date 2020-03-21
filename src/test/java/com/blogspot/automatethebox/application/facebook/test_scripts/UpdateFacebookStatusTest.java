package com.blogspot.automatethebox.application.facebook.test_scripts;

import com.blogspot.automatethebox.application.facebook.abstract_scripts.AbstractAuthenticationTest;
import com.blogspot.automatethebox.application.facebook.pages.ProfilePage;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;

/**
 * @author Lalit Kumar Narnaulia
 * https://automatethebox.blogspot.com
 */
public class UpdateFacebookStatusTest extends AbstractAuthenticationTest {

    @Override
    public void testSetup() {
    }

    @Test(description = "Update Facebook user text status")
    public void updateTextStatus() {

        // Navigate to user profile page.
        ProfilePage profilePage = homePage.navigateTo().profilePage();

        // Update the user text status.
        String status = new Date().toString();
        profilePage.updateStatus(status);

        // Retrieve and verify the recent status.
        assertEquals(profilePage.getRecentStatus(), status,
            "Facebook text status update is not working.");
    }
}