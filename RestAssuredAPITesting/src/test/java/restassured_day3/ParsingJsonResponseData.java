package restassured_day3;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {
	@Test(priority = 0)
	void testjsonresponses()
	{
		//1st Approach
		given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/json")
			.log().all();
			
		
		
		
		
	} 
	@Test(priority = 1)
	void testjsonresponse1()
	{
		//2nd Approach
		Response res=given()
			.body(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.header("Content-Type"),"application/json");
		Assert.assertEquals(res.getStatusCode(),200);
		
		String book=res.jsonPath().get("book[2].title").toString();
		Assert.assertEquals(book,"Moby Dick");
		
		//JSON Object class
		
		JSONObject js=new JSONObject(res.asString());// Converting the response to json object type
		//printing all the books from json
		for (int i = 0; i < js.getJSONArray("book").length(); i++) {
			String book_title=js.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(book_title);
			
		}
		//search for title of the book in json -validation
		boolean status=false;
		for (int i = 0; i < js.getJSONArray("book").length(); i++) {
			String book_title=js.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(book_title.equals("Moby Dick"))
			{
				status=true;
				break;
			}
		
	}
		Assert.assertEquals(status,true);
		
	//Validate total price of books
	double totalprice=0;
	for (int i = 0; i <js.getJSONArray("book").length();  i++) {
	String price=js.getJSONArray("book").getJSONObject(i).get("price").toString();
	totalprice=totalprice+Double.parseDouble(price);
	
		
	}
	System.out.println(totalprice);	
	Assert.assertEquals(totalprice,745.5);
}
}
