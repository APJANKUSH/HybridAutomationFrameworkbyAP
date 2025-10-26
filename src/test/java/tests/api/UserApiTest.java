package tests.api;

import framework.api.ApiUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

    @Test
    public void createAndGetUser() {
        Response res = ApiUtils.createUser("Test User", "testuser" + System.currentTimeMillis() + "@example.com");
        Assert.assertEquals(res.getStatusCode(), 201);
        String id = res.jsonPath().getString("id");

        Response get = ApiUtils.getUser(id);
        Assert.assertEquals(get.getStatusCode(), 200);
        Assert.assertEquals(get.jsonPath().getString("id"), id);
    }
}
