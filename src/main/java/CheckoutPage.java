import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private By FirstNameField = By.id("first-name");
    private WebElement FirstNameFieldEle;
    private By LastNameField = By.id("last-name");
    private WebElement LastNameFieldEle;
    private By PostalCodeField = By.id("postal-code");
    private WebElement PostalCodeFieldEle ;
    private By ContinueBtn = By.cssSelector("input[class=\"btn_primary cart_button\"]");
    private WebElement ContinueBtnEle;
    private By FinishBtn = By.xpath("//a[@class=\"btn_action cart_button\"]");
    private WebElement FiniahBtnEle;

    public void  EnterFirstName(String Fname)
    {
        FirstNameFieldEle = driver.findElement(FirstNameField);
        InsertingData(FirstNameFieldEle,Fname);
    }
    public void  EnterLastName(String Lname)
    {
        LastNameFieldEle = driver.findElement(LastNameField);
        InsertingData(LastNameFieldEle,Lname);
    }
    public void  EnterPostalCode(String PostalCode)
    {
        PostalCodeFieldEle = driver.findElement(PostalCodeField);
        InsertingData(PostalCodeFieldEle,PostalCode);
    }
    public void ClickOnContinueBtn()
    {
        ContinueBtnEle = driver.findElement(ContinueBtn);
        Clicking(ContinueBtnEle);
    }
    public void ConfirmOrder()
    {
        FiniahBtnEle = driver.findElement(FinishBtn);
        Clicking(FiniahBtnEle);
    }
}
