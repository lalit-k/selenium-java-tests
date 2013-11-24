package com.blogspot.automatethebox.application.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class LoginPage {
    //  private WebElement emailAddressTextInput;
    //  private WebElement passwordTextInput;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String emailAddress, String password) {
        driver.findElement(By.id("email")).sendKeys(emailAddress);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("loginbutton")).click();
    }

    public void logout() {
        driver.findElement(By.id("navAccountLink")).click();
        driver.findElement(By.id("logout_form")).click();
    }
}
