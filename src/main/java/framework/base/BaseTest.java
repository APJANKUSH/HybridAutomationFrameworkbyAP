package framework.base;

import framework.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    public static WebDriver driver;
    
    ConfigReader cr= new ConfigReader();
    
	public String baseURL=cr.getApplicationURL();
	public String username=cr.getUsername();
	public String password=cr.getPassword();


    @BeforeMethod
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		

			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
