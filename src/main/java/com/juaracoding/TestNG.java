package com.juaracoding;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNG {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        String path = "/Users/macbookpro/Downloads/chromedriver-mac-x64/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigasi ke halaman utama
        String url = "https://www.saucedemo.com/";
        driver.get(url);
    }

    @Test
    public void testLoginAndAddToCart() {
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        System.out.println("Open web eCommerce");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Tambahkan langkah-langkah untuk menambahkan produk ke keranjang dan proses checkout di sini
    }
    @Test
    public void testCheckout() {
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("Nunik", "Utami", "57275");
        checkoutPage.finishCheckout();
    }
    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
