import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By AddToCartButton = By.cssSelector("button[class=\"btn_primary btn_inventory\"]");
    private  WebElement AddToCartBtnEle;
    private By ShoppingCart = By.cssSelector("svg[data-icon=\"shopping-cart\"]");
    private WebElement ShoppingCartEle;
    public void AddProductToCart()
    {
        AddToCartBtnEle = driver.findElement(AddToCartButton);
        Clicking(AddToCartBtnEle);
    }
    public void ClickOnShoppingCart()
    {
        ShoppingCartEle = driver.findElement(ShoppingCart);
        Clicking(ShoppingCartEle);
    }

}
