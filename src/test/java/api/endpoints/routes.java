package api.endpoints;

// Base URL = "https://petstore.swagger.io"
// Create User API :-->  https://petstore.swagger.io/v2/user
// Get User by UserName API : --> https://petstore.swagger.io/v2/user/{UserName} 
// Get User by UserName API with example:--> https://petstore.swagger.io/v2/user/AmarG
//Update User by UserName API : --> https://petstore.swagger.io/v2/user/{UserName} 
//Update User by UserName API with example:--> https://petstore.swagger.io/v2/user/AmarG
//Delete User by UserName API : --> https://petstore.swagger.io/v2/user/{UserName} 
//Delete User by UserName API with example:--> https://petstore.swagger.io/v2/user/AmaG1

public class routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	// user Module URLs with end points
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	
	
}
