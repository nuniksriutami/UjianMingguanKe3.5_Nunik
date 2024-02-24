package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;
    public CartPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private WebElement btnCart;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addProduct;
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement productValidation;

    public void AddToCart() {
        addProduct.click();
        btnCart.click();
    }
    public String getTxtCartIcon(){return productValidation.getText();}
}

