package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private WebElement btnCart;

    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    private WebElement btnCheckout;



    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        btnCart.click();
    }

    public void proceedToCheckout() {
        btnCheckout.click();
    }
}

