package framework.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import framework.utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    static {
        RestAssured.baseURI = ConfigReader.get("api.baseUrl");
    }

    public static Response createUser(String name, String email) {
        String token = ConfigReader.get("api.token");
        String body = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"gender\":\"male\",\"status\":\"active\"}", name, email);
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(body)
                .post("/users");
    }

    public static Response getUser(String userId) {
        String token = ConfigReader.get("api.token");
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get("/users/" + userId);
    }
    public static Response deleteUser(String userId) {
    	 String token = ConfigReader.get("api.token");
    	 return given()
                 .contentType(ContentType.JSON)
                 .header("Authorization", "Bearer " + token)
                 .delete("/users/" + userId);
    	 
    	
    }
    
}
