package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

public class TestGetAPI {
    public static void main(String[] args) {
        // Set Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Perform GET request
        Response response =
                given()
                       // .header("Accept", "application/json")
                        .when()
                        .get("/posts/1") // Sample API Endpoint
                        .then()
                        //.statusCode(200) // Validate Status Code
                        //.contentType("application/json") // Validate Content Type
                        .extract().response();

        // Extract response as JSON
        String jsonResponse = response.getBody().asString();
        System.out.println("Response: " + jsonResponse);

        // Validating JSON fields
        int userId = response.jsonPath().getInt("userId");
        System.out.println("userId: " + userId);
        int id = response.jsonPath().getInt("id");
        System.out.println("id: " + id);
        String title = response.jsonPath().getString("title");

        String body = response.jsonPath().get("body");
        System.out.println("body: " + body);



        // Assertions
        Assert.assertEquals(userId, 1, "UserId doesn't match!");
        Assert.assertEquals(id, 1, "ID doesn't match!");
        Assert.assertNotNull(title, "Title should not be null!");

        System.out.println("API response validation passed!");
    }
}
