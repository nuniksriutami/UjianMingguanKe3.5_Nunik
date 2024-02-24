package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    private WebElement btnCheckout;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    private WebElement postCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement btnContinue;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    private WebElement btnFinish;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private WebElement btnBackHome;

    public void CheckoutProduct(){
        btnCheckout.click();
        firstName.sendKeys("Nunik");
        lastName.sendKeys("Utami");
        postCode.sendKeys("57275");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        btnContinue.click();
        btnFinish.click();
        btnBackHome.click();
    }
}

