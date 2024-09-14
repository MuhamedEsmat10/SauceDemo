import Data.JsonDataReader;
import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

public class CheckoutPageTest extends TestBase {
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    Faker fakeData = new Faker();
    String FirstName = fakeData.name().firstName();
    String LastName = fakeData.name().lastName();
    String PostalCode = fakeData.address().zipCode();
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void ConfirmOrder() throws FileNotFoundException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();
        loginPage = new LoginPage(driver);
        loginPage.InsertUserName(jsonReader.UserName);
        loginPage.InsertPassword(jsonReader.Password);
        loginPage.ClickOnLoginBtn();
        homePage = new HomePage(driver);
        homePage.AddProductToCart();
        homePage.ClickOnShoppingCart();
        cartPage = new CartPage(driver);
        cartPage.ClickOnCheckoutBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.EnterFirstName(FirstName);
        checkoutPage.EnterLastName(LastName);
        checkoutPage.EnterPostalCode(PostalCode);
        checkoutPage.ClickOnContinueBtn();
        checkoutPage.ConfirmOrder();
        String expectedResult = "THANK YOU FOR YOUR ORDER";
        String actualResult = driver.findElement(By.className("complete-header")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}