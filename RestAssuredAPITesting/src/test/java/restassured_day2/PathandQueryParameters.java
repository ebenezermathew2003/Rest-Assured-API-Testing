package restassured_day2;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathandQueryParameters {
//api://https://reqres.in/api/users?page=2&id=5
	@Test
	void testQueryParameters(){
		given()
		
			.pathParam("pathparam", "users")//path parameter
			.queryParam("page", 2)//query paramater
			.queryParam("id", 5)//query parameter
		
			.when()
				.get("https://reqres.in/api/{pathparam}")
	
			.then()
			.statusCode(200)
			.log().all();
	}

}
