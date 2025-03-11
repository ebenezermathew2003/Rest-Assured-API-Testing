package restassured_day1;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;
/*
 * given()
 * content type,set,cookies,add auth,add param,set headers info etc
 
 *when()
 *Http requests
 *
 *then()
 *response body,validate status code,extract headres,cookies....
 */

public class Httpresquest {
	int id;
	@Test(priority = 0)
	void getUsers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
@Test(priority = 1)
void createuser()
{
	HashMap hmt=new HashMap();
	hmt.put("name","mathew");
	hmt.put("job", "Student");
	
	id=given()
		.contentType("application/json")
		.body(hmt)
	.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
//	.then()
//		.statusCode(201)
//		.log().all();
}
@Test(priority = 2, dependsOnMethods = {"createuser"})
void updateuser()
{
	HashMap hmt=new HashMap();
	hmt.put("name","mathew");
	hmt.put("job", "Intern");
	
	given()
		.contentType("application/json")
		.body(hmt)
	.when()
		.put("https://reqres.in/api/users/"+id)
		
	.then()
		.statusCode(200)
		.log().all();
	
}
@Test(priority = 3)
	void deleteuser()
{
	given()
	
	.when()
		.delete("https://reqres.in/api/users/"+id)
	
	.then()
		.statusCode(204)
		.log().all();
}
	

}
