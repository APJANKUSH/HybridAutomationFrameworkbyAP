package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By logout = By.xpath("//a[normalize-space()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserLoggedIn() {
        try {
            return driver.findElement(logout).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
