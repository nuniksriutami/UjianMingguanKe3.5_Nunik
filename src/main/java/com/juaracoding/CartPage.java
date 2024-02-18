package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private WebElement cartButton;

    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    private WebElement checkoutButton;



    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        cartButton.click();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}

