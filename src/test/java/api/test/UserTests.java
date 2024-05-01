package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setFirstName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		// logs
		logger = LogManager.getLogger(this.getClass());
		logger.debug("************************* debugging User ******************************");
	}
	
	@Test(priority=1)
	public void testPostUser() {
		logger.info("************************* Creating User ******************************");
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************************* User is created ******************************");
	}
	
	@Test(priority=2)
	public void testgetUserName() {
		logger.info("************************* Reading User Info******************************");
		Response response = UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************************* User info is displayed******************************");
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		//update data using payload
		logger.info("************************* Updating User******************************");
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setFirstName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterUpdate = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		logger.info("************************* User Updated ******************************");
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		logger.info("************************* User Deleting ******************************");
		Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterDelete = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(responseAfterDelete.getStatusCode(), 200);
		logger.info("************************* User Deleted ******************************");
	}
}
