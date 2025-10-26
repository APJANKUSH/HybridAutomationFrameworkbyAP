package framework.api.endpoints;

public class Routers {
	
	
	public static String baseURL= "https://gorest.co.in/public/v2";
	
//	Users Model
	public static String postUsersURL = baseURL + "/users"; 
	public static String getUsersURL  = baseURL + "/users/{id}"; 
	public static String updateUsersURL  = baseURL + "/users/{id}";
	public static String deleteUsersURL  = baseURL + "/users/{id}";
	
//	Posts Model
	public static String postPostsURL = baseURL + "/posts"; 
	public static String getPostsURL  = baseURL + "/posts/{id}"; 
	public static String updatePostsURL  = baseURL + "/posts/{id}";
	public static String deletePostsURL  = baseURL + "/posts/{id}";
	
//	Comments Model
	public static String postCommentsURL = baseURL + "/comments"; 
	public static String getCommentsURL  = baseURL + "/comments/{id}"; 
	public static String updateCommentsURL  = baseURL + "/comments/{id}";
	public static String deleteCommentsURL  = baseURL + "/comments/{id}";
	
//	Todos Model
	public static String postTodosURL = baseURL + "/todos"; 
	public static String getTodosURL  = baseURL + "/todod/{id}"; 
	public static String updateTodosURL  = baseURL + "/todos/{id}";
	public static String deleteTodosURL  = baseURL + "/todos/{id}";
	
}
