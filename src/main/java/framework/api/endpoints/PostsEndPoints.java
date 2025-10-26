package framework.api.endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.api.payload.Posts;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

public class PostsEndPoints {
	
	static String token = getURL().getString("token"); 
	static ResourceBundle getURL(){
		ResourceBundle router =  ResourceBundle.getBundle("router");
		return router;
	}
	
	
	public static Response createPosts(Posts payload) {
		String postPostsURL = getURL().getString("postPostsURL"); 
		Response response = given()
				.header("Authorization", token)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				.body(payload)
				.when()
				  .post(postPostsURL);
		       
			   return response;
		
	}
	public static Response readPosts(int postId) {
		String getPostsURL = getURL().getString("getPostsURL"); 
		Response response = given()
				.header("Authorization", token)
				   .pathParam("id", postId)
				   .header("Authorization", token)
				
				.when()
				  .get(getPostsURL);
		       
			   return response;
		
	}
	
	public static Response updatePosts(Posts payload,int postId) {
		String updatePostsURL = getURL().getString("updatePostsURL"); 
		Response response = given()
				.header("Authorization", token)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", token)
				 .pathParam("id", postId)
				.body(payload)        
				.when()
				  .put(updatePostsURL);
		       
			   return response;
		
	}
	public static Response deletePosts(int postId) {
		String deletePostsURL = getURL().getString("deletePostsURL"); 
		Response response = given()
				.header("Authorization", token)
				   .pathParam("id", postId)
				   .header("Authorization", token)
				
				.when()
				  .delete(deletePostsURL);
		       
			   return response;
		
	}

}
