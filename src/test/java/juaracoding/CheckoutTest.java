package juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {
    private WebDriver driver;

    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        loginPage = new LoginPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testValidLogin(){
        loginPage.formLogin();
        Assert.assertEquals(loginPage.getTxtAppLogo(),"Swag Labs");
        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cartPage.AddToCart();
        Assert.assertEquals(cartPage.getTxtCartIcon(),"Sauce Labs Backpack");
        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkoutPage.CheckoutProduct();
        try {
            Thread.sleep(1000); // Tunggu 1 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
