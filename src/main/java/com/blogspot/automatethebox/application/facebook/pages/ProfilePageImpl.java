package com.blogspot.automatethebox.application.facebook.pages;

import com.blogspot.automatethebox.application.facebook.modules.UpdateStatusPanel;
import com.blogspot.automatethebox.application.facebook.modules.UpdateStatusPanelImpl;
import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class ProfilePageImpl implements ProfilePage {

    // Web Elements.
    @FindBy(xpath = "//li[contains(@class,'fbTimelineUnit')][2]//span[contains(@class,'userContent')]")
    private WebElement userRecentTextStatus;

    // Page sub-modules.
    private UpdateStatusPanel updateStatusPanel;

    public ProfilePageImpl(WebDriver driver) {
        PageFactory.initElements(driver, this);  //TODO: prohibit initialising dynamic elements with PageFactory.
        updateStatusPanel = new UpdateStatusPanelImpl(driver);
    }

    @Override
    public ProfilePage updateStatus(String status) {
        Preconditions.checkNotNull(status, "Status parameter is null");
        updateStatusPanel.updateStatus(status);
        return this;
    }

    @Override
    public String getRecentStatus() {
        return userRecentTextStatus.getText();
    }
}
