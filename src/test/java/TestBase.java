import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browserName)
    {
            if (browserName.equalsIgnoreCase("chrome"))
            {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://www.saucedemo.com/v1/index.html");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
            else if (browserName.equalsIgnoreCase("Edge"))
            {
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get("https://www.saucedemo.com/v1/index.html");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}