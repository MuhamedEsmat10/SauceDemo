import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By UserNameField = By.id("user-name");
    private WebElement UserNameFieldEle;
    private By PasswordField = By.name("password");
    private WebElement PasswordFieldEle;
    private By LoginBtn = By.id("login-button");
    private WebElement LoginBtnEle;
 public void  InsertUserName(String UserName)
 {
     UserNameFieldEle = driver.findElement(UserNameField);
     InsertingData(UserNameFieldEle,UserName);
 }
    public void  InsertPassword(String Password)
    {
        PasswordFieldEle = driver.findElement(PasswordField);
        InsertingData(PasswordFieldEle,Password);
    }
    public void ClickOnLoginBtn()
    {
        LoginBtnEle = driver.findElement(LoginBtn);
        Clicking(LoginBtnEle);
    }
}
