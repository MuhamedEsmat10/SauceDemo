import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private  By CheckoutBtn = By.xpath("//a[@class=\"btn_action checkout_button\"]");
    private  WebElement CheckoutBtnEle;
    public void ClickOnCheckoutBtn()
    {
        CheckoutBtnEle = driver.findElement(CheckoutBtn);
        Clicking(CheckoutBtnEle);
    }


}
