package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;


public class JsonSchemaTest {

    @Test
    public void testGet()
    {
        baseURI = "https://fakestoreapi.com";

        given().
                get("/products")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
    }
}
