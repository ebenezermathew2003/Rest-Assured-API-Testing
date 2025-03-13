package restassured_day4;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class createuser_APIChaining {

    @Test
    void createUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject obj = new JSONObject();

        obj.put("name", faker.name().fullName());
        obj.put("gender", "Male");
        obj.put("email", faker.internet().safeEmailAddress());
        obj.put("status", "inactive");

        String bearerToken = "14709630607c43f04c594d02c73de6dd3e369b6d2f747867c8b3fe7aa72a876e"; 

        int id = given()
            .header("Authorization", "Bearer " + bearerToken)
            .contentType("application/json")
            .body(obj.toString())
        .when()
            .post("https://gorest.co.in/public/v2/users")
        .then()
            .statusCode(201) 
            .log().all()
            .extract().jsonPath().getInt("id");

        System.out.println("User ID Generated: " + id);

        
        context.setAttribute("user_id", id);
    }
}
