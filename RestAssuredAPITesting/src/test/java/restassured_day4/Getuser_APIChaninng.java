package restassured_day4;

import static io.restassured.RestAssured.given;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Getuser_APIChaninng {

    @Test
    void getUser(ITestContext context) {
        int id = (Integer) context.getAttribute("user_id");
        String bearerToken = "14709630607c43f04c594d02c73de6dd3e369b6d2f747867c8b3fe7aa72a876e"; // Replace with actual token

        given()
            .header("Authorization", "Bearer " + bearerToken)
            .pathParam("id", id)
        .when()
            .get("https://gorest.co.in/public/v2/users/{id}")
        .then()
            .statusCode(200)
            .log().all();
    }
}
