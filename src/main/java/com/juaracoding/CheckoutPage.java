package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(name = "postalCode")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[text()='Finish']")
    private WebElement finishButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
    }

    public void finishCheckout() {
        finishButton.click();
    }
}

