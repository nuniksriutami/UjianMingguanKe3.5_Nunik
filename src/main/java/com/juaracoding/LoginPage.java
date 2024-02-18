package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    // Konstruktor dengan parameter WebDriver
//    public LoginPage() {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
