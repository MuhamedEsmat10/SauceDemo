import Data.JsonDataReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

public class CartPageTest extends TestBase{
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    @Test()
    @Severity(SeverityLevel.CRITICAL)
    public void DirectedToCheckoutPage() throws FileNotFoundException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();
        loginPage = new LoginPage(driver);
        loginPage.InsertUserName(jsonReader.UserName);
        loginPage.InsertPassword(jsonReader.Password);
        loginPage.ClickOnLoginBtn();
        homePage = new HomePage(driver);
        homePage.AddProductToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePage.ClickOnShoppingCart();
        cartPage = new CartPage(driver);
        cartPage.ClickOnCheckoutBtn();
        String expectedURL = "https://www.saucedemo.com/v1/checkout-step-one.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedURL);
    }
}
