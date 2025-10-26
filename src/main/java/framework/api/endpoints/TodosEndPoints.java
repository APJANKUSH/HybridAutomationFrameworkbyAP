package framework.api.endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.api.payload.Todos;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

public class TodosEndPoints {
	
	static String token = getURL().getString("token"); 
	static ResourceBundle getURL(){
		ResourceBundle router =  ResourceBundle.getBundle("router");
		return router;
	}
	
	public static Response createTodos(Todos payload) {
		String postTodosURL = getURL().getString("postTodosURL"); 
		Response response = given()
				.header("Authorization", token)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				  .post(Routers.postTodosURL);
		       
			   return response;
		
	}
	public static Response readTodos(int userId) {
		String getTodosURL = getURL().getString("getTodosURL"); 
		Response response = given()
				.header("Authorization", token)
				   .pathParam("userid", userId)
				
				.when()
				  .get(getTodosURL);
		       
			   return response;
		
	}
	
	public static Response updateTodos(Todos payload,int userId) {
		String updateTodosURL = getURL().getString("updateTodosURL"); 
		Response response = given()
				.header("Authorization", token)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				 .pathParam("userid", userId)
				.body(payload)
				.when()
				  .put(updateTodosURL);
		       
			   return response;
		
	}
	public static Response deleteTodos(int userId) {
		String deleteTodosURL = getURL().getString("deleteTodosURL"); 
		Response response = given()
				.header("Authorization", token)
				   .pathParam("userid", userId)
				
				.when()
				  .delete(deleteTodosURL);
		       
			   return response;
		
	}


}
