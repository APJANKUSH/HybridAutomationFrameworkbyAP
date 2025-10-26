package framework.api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import java.util.ResourceBundle;

import framework.api.payload.Users;

public class UsersEndPoints {

	static String token = getURL().getString("token");

	static ResourceBundle getURL() {
		ResourceBundle router = ResourceBundle.getBundle("router");
		return router;
	}

	public static Response createUsers(Users payload) {

		String postUsersURL = getURL().getString("postUsersURL");
		String token = getURL().getString("token");

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Authorization", token).body(payload).when().post(postUsersURL);

		return response;

	}

	public static Response readUsers(int userId) {
		String getUsersURL = getURL().getString("getUsersURL");
		Response response = given().header("Authorization", token).pathParam("id", userId)

				.when().get(getUsersURL);

		return response;

	}

	public static Response updateUsers(Users payload, int userId) {
		String updateUsersURL = getURL().getString("updateUsersURL");
		Response response = given().header("Authorization", token).contentType(ContentType.JSON)
				.accept(ContentType.JSON).pathParam("id", userId).body(payload).when().put(updateUsersURL);

		return response;

	}

	public static Response deleteUsers(int userId) {
		String deleteUsersURL = getURL().getString("deleteUsersURL");
		Response response = given()
				.header("Authorization", "Bearer c414017e8498a23fad2aceb018389f3a9a94fd663a6d07cf568951166efe7c47")
				.pathParam("id", userId)

				.when().delete(deleteUsersURL);

		return response;

	}

}