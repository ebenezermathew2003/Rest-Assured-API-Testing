package restassured_day4;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
public class API_Key_Authentication {
	@Test
	void testapikeyauthentication()
	{
		given()
		
			.queryParam("appid","555d32a9b0b5b63b5894f117d98f1ff4")
			.pathParam("path","data/2.5/forecast/daily")
			.queryParam("lat", "57")
			.queryParam("lon","-2.15")
			.queryParam("units","metric")
			
		.when()
			.get("https://api.openweathermap.org/{path}")
			
		.then()
			.log().all();
	}

}
