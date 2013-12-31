package com.blogspot.automatethebox.application.facebook.modules;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class UpdateStatusPanelImpl implements UpdateStatusPanel {

    // Web Elements.
    @FindBy(xpath = "//textarea")
    private WebElement updateStatusTextArea;
    @FindBy(xpath = "//button[contains(text(),'Post')]")
    private WebElement postButton;

    // Waits.
    private static final int WAIT_FOR_POST_UPDATE = 15;

    public UpdateStatusPanelImpl(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    public UpdateStatusPanel updateStatus(String status) {
        Preconditions.checkNotNull(status, "Status parameter is null");
        updateStatusTextArea.clear();
        updateStatusTextArea.sendKeys(status);
        postButton.click();
        int wait = 0;
        while (wait++ <= WAIT_FOR_POST_UPDATE && postButton.isDisplayed()) {
            Sleeper.sleepTightInSeconds(5);
        }
        return this;
    }
}
