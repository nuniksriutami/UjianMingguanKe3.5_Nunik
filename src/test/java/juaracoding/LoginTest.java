package juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @Test
    public void testValidLogin(){
        loginPage.formLogin();
        Assert.assertEquals(loginPage.getTxtAppLogo(), "Swag Labs");
    }


}
