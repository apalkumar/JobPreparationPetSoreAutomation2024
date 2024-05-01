package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//This is UserEndPoint.Java End point Java class
//Created for perform the Create, Read, Update and Delete Requests 

public class UserEndPoints2 {
	// Created for getting the urls
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	public static Response createUser(User payload) {
		String post_user_url = getURL().getString("post_user_url");

		Response response = given().relaxedHTTPSValidation()
				.contentType("application/json").body(payload).when()
				.post(post_user_url);

		return response;
	}

	public static Response readUser(String userName) {
		String get_user_url = getURL().getString("get_user_url");
		Response response = given().pathParam("username", userName).when()
				.get(get_user_url);

		return response;
	}

	public static Response updateUser(String userName, User payload) {
		String put_user_url = getURL().getString("put_user_url");
		Response response = given().relaxedHTTPSValidation().contentType("application/json")
				.pathParam("username", userName).body(payload).when().put(put_user_url);
		return response;
	}

	public static Response deleteUser(String userName) {
		String delete_user_url = getURL().getString("delete_user_url");
		Response response = given().pathParam("username", userName).when()
//			.delete(Routes.delete_user_url);
				.delete(delete_user_url);

		return response;
	}
}
