package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    
    private By signUp = By.xpath("//a[normalize-space()='Signup / Login']");
    private By email = By.xpath("//input[@data-qa='login-email']");
    private By  password= By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//button[normalize-space()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email1, String pass) {
    	driver.findElement(signUp).click();
        driver.findElement(email).sendKeys(email1);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
