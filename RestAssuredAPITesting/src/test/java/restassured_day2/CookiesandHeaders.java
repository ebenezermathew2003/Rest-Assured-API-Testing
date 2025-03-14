package restassured_day2;
import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesandHeaders {
	//@Test
	void testcookie()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
			
		.then()
		.cookie("AEC","AVcja2cnzjf6nhccNR5JMFAnDj_vRYZj6dNGhea_7Hnu0rjtql0kF0H9kL8")
		.log().all();
	}
	@Test
	void testcookieinfo()
	{
		Response res=given()
		
		.when()
			.get("https://www.google.com/");
			
		//get single cookie info
//		String cookie_value=res.getCookie("AEC");
//		System.out.println("Cookie value :"+cookie_value);
		
		//get all cookies info
		Map<String,String> cookies_values=res.getCookies();
		for (String k : cookies_values.keySet()) 
 {
			String cookie_value=res.getCookie(k);
			System.out.println(k+"			"+cookie_value);
			
		}
		
	}

}
