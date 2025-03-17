package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

@Test
public class Usertests {
	
	Faker fake;
	User userpayload;
	@BeforeClass
	public void setupdate()
	{
		fake=new Faker();
		userpayload=new User();
		
		userpayload.setId(fake.idNumber().hashCode());
		userpayload.setUsername(fake.name().username());
		userpayload.setFirstname(fake.name().firstName());
		userpayload.setLastname(fake.name().lastName());
		userpayload.setEmail(fake.internet().safeEmailAddress());
		userpayload.setPassword(fake.internet().password(5,10));
		userpayload.setPhone(fake.phoneNumber().cellPhone());

		
	}
	@Test(priority = 1)
	public void testPostUser()
	{
		Response response=UserEndPoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	@Test(priority=2)
	public void testgetuserbyusername()
	{
		Response response=UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		response.getStatusCode();
		
	}
	@Test(priority=3)
	public void testUpdateUserbyname()
	{
		//updating the data
		userpayload.setFirstname(fake.name().firstName());
		userpayload.setLastname(fake.name().lastName());
		userpayload.setEmail(fake.internet().safeEmailAddress());
		Response response=UserEndPoints.updateuser(this.userpayload.getUsername(),userpayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		//checking data after updates
		
		UserEndPoints.readUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testdeleteuserbyname()
	{
		Response response=UserEndPoints.deleteuser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
	}
	

}