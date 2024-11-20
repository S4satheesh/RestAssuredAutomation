package test;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestOnLocalAPI {

    @Test
    public void get(){

        baseURI = "http://localhost:3000";

        given().
                get("/users").
                then().
                statusCode(200).
                log().all();

    }

    @Test
    public void post()
    {
        JSONObject request = new JSONObject();
        request.put("firstName","sachin");
        request.put("lastName","Ten");
        request.put("subjectID",1);

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }
    @Test
    public  void put()
    {
        JSONObject request = new JSONObject();
        request.put("firstName","sachin");
        request.put("lastName", "Tendulkar");
        request.put("subjectID",1);

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/a216")
                .then()
                .statusCode(200);

    }

    @Test
    public  void patch()
    {
        JSONObject request = new JSONObject();

        request.put("lastName", "Ramesh Tendulkar");

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/users/a216")
                .then()
                .statusCode(200);

    }
    @Test
    public void delete()
    {
        baseURI = "http://localhost:3000";
        when().delete("/users/a216").then().statusCode(200);
    }

}
