package restassured_day2;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Headersdemo1 {
	@Test
		void testheadres()
		{
			given()
			
			.when()
				.get("https://www.google.com/")
				
			.then()
				.header("Content-Type","text/html; charset=ISO-8859-1")
				.and()
				.header("Content-Encoding","gzip")
				.log().headers();
		}
		
@Test		
void getheaders()
{
	Response res=given()
			
			.when()
				.get("https://www.google.com/");
	
	//get single header info
	
//	String headervalue=res.getHeader("Content-Type");
//	System.out.println("The value of single header "+headervalue);

	//get all headers info
	Headers myheaders=res.getHeaders();
	
	for(Header hd:myheaders) {
		System.out.println(hd.getName()+"      "+hd.getValue());
	}
	
}

}
