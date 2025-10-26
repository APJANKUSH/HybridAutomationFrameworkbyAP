package tests.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


import com.github.javafaker.Faker;

import framework.api.endpoints.PostsEndPoints;
import framework.api.payload.Posts;
import io.restassured.response.Response;

public class TestPosts {
	Faker faker;
	Posts posts;
	public Logger log;
	public static int postId;
	
	@BeforeTest
	public void setUpData() {
		
		faker = new Faker();
		posts = new Posts();
		log = LogManager.getLogger(this.getClass());
		
		
		posts.setId(faker.idNumber().hashCode());
		posts.setUserId(TestUsers.userId);
		posts.setTitle(faker.name().title());
		posts.setBody(faker.name().fullName());
		
	}
	
	@Test(priority=1)
	public void testPostPosts() {
		Response response = PostsEndPoints.createPosts(posts);
		response.then().log().body();
		postId= response.jsonPath().getInt("id");
		System.out.println("Created Post ID: " + postId);
		Assert.assertEquals(response.getStatusCode(),200);
		System.out.println("Content-Type: " + response.getContentType());
	    System.out.println("Status Code: " + response.getStatusCode());
	    System.out.println("Cookies: " + response.getCookies());
	}
	@Test(priority=2)
	public void testGetPosts() {
		Response response = PostsEndPoints.readPosts(postId);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);	
		System.out.println("Status Code: "+response.statusCode());
		
	}
	
	@Test
	public void testUpdatePosts() {
		posts.setTitle(faker.name().title());
		posts.setBody(faker.name().fullName());
		Response response = PostsEndPoints.updatePosts(posts, postId);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		System.out.println("Content-Type: " + response.getContentType());
	    System.out.println("Status Code: " + response.getStatusCode());
	    System.out.println("Cookies: " + response.getCookies());
		
	}
	
	@Test
	public void testDeletePosts() {
	
		Response response  = PostsEndPoints.deletePosts(postId);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);	
		System.out.println("Status Code: "+response.statusCode());		
		
	}

}
