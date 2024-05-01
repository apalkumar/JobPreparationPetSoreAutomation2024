package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.response.Response;

// This java file is to perform CRUD operations

public class UserEndPoints {

	public static Response createUser(User payload) {	
		Response response = given()
								.relaxedHTTPSValidation()
//								.contentType("ContentType.JSON")
//								.accept("ContentType.JSON")
								.body(payload)
								.with()
								.contentType("application/json")
							.when()
								.post(routes.post_url);
		return response;
	}
	
	public static Response readUser(String username) {	
		Response response = given().pathParam("username", username)
				.when()
				.get(routes.get_url);
		return response;
	}
	
	public static Response updateUser(String username, User payload) {	
		Response response = given()
								.relaxedHTTPSValidation()
								.contentType("application/json")
//								.accept("ContentType.JSON")
								.pathParam("username", username)
								.body(payload)
							.when()
								.put(routes.update_url);
		return response;
	}

	public static Response deleteUser(String userName) {	
		Response response = given().pathParam("username", userName)
				.when()
				.delete(routes.delete_url);
		return response;
	}

}
