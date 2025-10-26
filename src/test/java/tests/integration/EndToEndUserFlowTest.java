package tests.integration;

import framework.api.ApiUtils;
import framework.base.BaseTest;
import framework.pages.DashboardPage;
import framework.pages.LoginPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndUserFlowTest extends BaseTest {
	
	public static String userId;

    @Test
    public void apiToUiUserFlow() {
        Response create = ApiUtils.createUser("E2E User", "e2euser" + System.currentTimeMillis() + "@example.com");
        Assert.assertEquals(create.getStatusCode(), 201);
        userId = create.jsonPath().getString("id");

//        LoginPage login = new LoginPage(driver);
//        login.login("Admin12", "admin1223@gmail.com");
//        DashboardPage dash = new DashboardPage(driver);
//        Assert.assertTrue(dash.isUserLoggedIn());
        Response get = ApiUtils.getUser(userId);
        String email = get.jsonPath().prettyPrint();
        Response delete = ApiUtils.deleteUser(userId);
        System.out.println("API-created user id: " + userId);
        System.out.println("API-created email id: " + get);
        System.out.println("API-deleted user id: " + userId);
       

    }
}
