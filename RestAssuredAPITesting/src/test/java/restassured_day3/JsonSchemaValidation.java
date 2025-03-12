package restassured_day3;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class JsonSchemaValidation {
	@Test
	void jsonschemavalidate()
	{
		given()
		
		.when()
			.get("http://localhost:3000/store")
			
		.then()
			//schema validation
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
			
	}

}
