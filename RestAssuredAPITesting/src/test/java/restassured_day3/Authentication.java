package restassured_day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Authentication {
	/*@Test(priority = 0)
	//Basic Authentication
	void testbasicauthentication() {
	given()
		.auth().basic("postman","password")
	.when()
		.get("https://postman-echo.com/basic-auth")
	.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	@Test(priority = 1)
	//Digest Authentication
	void digestauthentication()
	{
		given()
		.auth().digest("postman","password")
	.when()
		.get("https://postman-echo.com/basic-auth")
	.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	@Test(priority = 2)
	//Preemptive Authentication
	void preemptiveauthentication() {
		given()
		.auth().preemptive().basic("postman","password")
	.when()
		.get("https://postman-echo.com/basic-auth")
	.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	@Test(priority = 3)
	//Bearer Token
	void Bearertoken()
	{
		//String bearer_token="xyz";
		
		given()
		//	.headers("Authorization","Bearer "+bearer_token)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	//Oauth2 Authentication
	@Test(priority = 4)
	void Oauth2authentication()
	{
		given()
			//.auth().oauth2("xyz")
			
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
			.statusCode(200)
			.log().all();
	}*/

}
