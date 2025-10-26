package framework.api.endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.api.payload.Comments;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

public class CommentsEndPoints {
	
	static String token = getURL().getString("token"); 
	static ResourceBundle getURL(){
		ResourceBundle router =  ResourceBundle.getBundle("router");
		return router;
	}
	
	public static Response createComments(Comments payload) {
		String postCommentsURL = getURL().getString("postCommentsURL"); 
		Response response = given()
				.header("Authorization", token)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				  .post(postCommentsURL);
		       
			   return response;
		
	}
	public static Response readComments(int userId) {
		String getCommentsURL = getURL().getString("getCommentsURL"); 
		Response response = given()
				.header("Authorization", token)
				   .pathParam("id", userId)
				
				.when()
				  .get(getCommentsURL);
		       
			   return response;
		
	}
	
	public static Response updateComments(Comments payload,int userId) {
		String updateCommentsURL = getURL().getString("updateCommentsURL"); 
		Response response = given()
				.header("Authorization", token)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				 .pathParam("id", userId)
				.body(payload)
				.when()
				  .put(updateCommentsURL);
		       
			   return response;
		
	}
	public static Response deleteComments(int userId) {
		String deleteCommentsURL = getURL().getString("deleteCommentsURL"); 
		Response response = given()
				.header("Authorization", token)
				   .pathParam("id", userId)
				
				.when()
				  .delete(deleteCommentsURL);
		       
			   return response;
		
	}


}
