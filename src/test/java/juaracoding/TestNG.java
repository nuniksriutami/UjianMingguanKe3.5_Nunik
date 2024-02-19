package juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import org.testng.annotations.AfterClass;

import static org.testng.TestRunner.PriorityWeight.priority;

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
    public void testLogin() {
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        System.out.println("Open web eCommerce");

        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // product page abis ini
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAddToCart(){
        String url = "https://www.saucedemo.com/cart.html";
        driver.get(url);

        // masuk ke cart page
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();

        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // lanjut klik button checkout
        CartPage cartPage1 = new CartPage(driver);
        cartPage1.proceedToCheckout();

        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCheckoutStepOne(){
        String url = "https://www.saucedemo.com/checkout-step-one.html";
        driver.get(url);

        // checkout information -- input firstname, lastname, zipcode --> klik continue
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("Nunik", "Utami", "57275");

        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCheckoutStepTwo(){
        String url = "https://www.saucedemo.com/checkout-step-two.html";
        driver.get(url);
        // finish checkout
        CheckoutPage checkoutPage1 = new CheckoutPage(driver);
        checkoutPage1.finishCheckout();

        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}
