import Data.JsonDataReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

public class HomePageTest extends TestBase{
    public LoginPage loginPage;
    protected HomePage homePage;
    @Test()
    @Description("user after successful login can add product to cart")
    @Severity(SeverityLevel.CRITICAL)
    public void AddProductToCart()
    {
        JsonDataReader jsonReader = new JsonDataReader();
        try {
            jsonReader.JsonReader();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        loginPage = new LoginPage(driver);
        loginPage.InsertUserName(jsonReader.UserName);
        loginPage.InsertPassword(jsonReader.Password);
        loginPage.ClickOnLoginBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        homePage.AddProductToCart();
        WebElement ShoppingCartCounter = driver.findElement(By.xpath("//span[@class=\"fa-layers-counter shopping_cart_badge\"]"));
        Assert.assertTrue(ShoppingCartCounter.isDisplayed());
    }
}
