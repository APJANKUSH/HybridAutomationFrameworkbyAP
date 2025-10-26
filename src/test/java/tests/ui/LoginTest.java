package tests.ui;

import framework.base.BaseTest;
import framework.pages.DashboardPage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("hp@t.com", "hp1529");
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isUserLoggedIn(), "User should be logged in");
    }
}
