package tests.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import framework.api.endpoints.UsersEndPoints;
import framework.api.payload.Users;
import io.restassured.response.Response;

public class TestUsers {

	Faker faker;
	Users users;
	public static int userId;

	public Logger log;

	@BeforeTest
	public void setUpData() {

		faker = new Faker();
		users = new Users();
		log = LogManager.getLogger(this.getClass());

		users.setId(faker.idNumber().hashCode());
		users.setName(faker.name().firstName());
		users.setEmail(faker.internet().safeEmailAddress());
		users.setGender(faker.demographic().sex()); // returns "Male" or "Female"
		users.setStatus(faker.bool().bool() ? "active" : "inactive");
	}

	@Test(priority = 1)
	public void testPostUsers() {

		Response response = UsersEndPoints.createUsers(users);
		response.then().log().body();

		userId = response.jsonPath().getInt("id");
		System.out.println("User ID :" + userId);
		Assert.assertEquals(response.getStatusCode(), 201);

		System.out.println("Content-Type: " + response.getContentType());
		System.out.println("Status Code: " + response.getStatusCode());

		log.info("User created ..!");
	}

	@Test(priority = 2)
	public void testGetUsersById() {

		Response response = UsersEndPoints.readUsers(userId);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status Code: " + response.statusCode());
		log.info(" User data fetched..!");

	}

	@Test(priority = 3)
	public void testUpdateUsers() {

		users.setName(faker.name().firstName());
		users.setEmail(faker.internet().safeEmailAddress());

		Response response = UsersEndPoints.updateUsers(users, userId);
		response.then().log().body();
		System.out.println("Content-Type: " + response.getContentType());
		System.out.println("Status Code: " + response.getStatusCode());

		log.info("User Updated ..!");

	}

	@Test(priority = 4)
	public void testDeleteUsers() {

		Response response = UsersEndPoints.deleteUsers(userId);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 204);
		System.out.println("Status Code: " + response.statusCode());
		log.info("User Deleted ..!");

	}

}
