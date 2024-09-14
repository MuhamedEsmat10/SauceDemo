import Data.JsonDataReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.time.Duration;

public class LoginPageTest extends TestBase {
   protected LoginPage loginPage;
   protected CheckoutPage checkoutPage;
    @Test(priority = 1)
    @Description("user can successfully login using valid credentials ")
    @Severity(SeverityLevel.CRITICAL)
    public void SuccessfulLogin() throws FileNotFoundException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();
        loginPage = new LoginPage(driver);
        loginPage.InsertUserName(jsonReader.UserName);
        loginPage.InsertPassword(jsonReader.Password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.ClickOnLoginBtn();
        WebElement appLogo = driver.findElement(By.className("app_logo"));
        Assert.assertTrue(appLogo.isDisplayed());
    }
    @Test(description = "user cannot log into the site with empty fields")
    public void InvalidLoginWithBlankFields()
    {
        loginPage = new LoginPage(driver);
        loginPage.ClickOnLoginBtn();
        WebElement errorBtn = driver.findElement(By.className("error-button"));
        Assert.assertTrue(errorBtn.isDisplayed());
    }
    @Test(description = "user cannot log into the site with wrong user name or password")
    public void InvalidLoginUsingWrongCredenials() throws FileNotFoundException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();
        loginPage = new LoginPage(driver);
        loginPage.InsertUserName("test01");
        loginPage.InsertPassword(jsonReader.Password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.ClickOnLoginBtn();
        String expectedResult = "Username and password do not match any user in this service";
        String actualResult = driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }




}