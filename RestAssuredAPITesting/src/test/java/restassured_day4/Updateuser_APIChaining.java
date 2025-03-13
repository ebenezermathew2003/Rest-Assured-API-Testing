package restassured_day4;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class Updateuser_APIChaining {

    @Test
    void updateUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject obj = new JSONObject();

        obj.put("name", faker.name().fullName());
        obj.put("gender", "Female");
        obj.put("email", faker.internet().safeEmailAddress());
        obj.put("status", "active");

        String bearerToken = "14709630607c43f04c594d02c73de6dd3e369b6d2f747867c8b3fe7aa72a876e"; // Replace with actual token
        int id = (Integer) context.getAttribute("user_id");

        given()
            .header("Authorization", "Bearer " + bearerToken)
            .contentType("application/json")
            .pathParam("id", id)
            .body(obj.toString())
        .when()
            .put("https://gorest.co.in/public/v2/users/{id}")
        .then()
            .statusCode(200) // Expecting HTTP 200 (OK)
            .log().all();
    }
}
