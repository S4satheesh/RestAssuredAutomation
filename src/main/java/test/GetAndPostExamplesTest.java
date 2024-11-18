package test;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetAndPostExamplesTest  {

    @Test
    public void testGet()
    {
        baseURI = "https://fakestoreapi.com";

        given().
                get("/products").
                then().
                log().all().
                statusCode(200).
                body("[2].title", equalTo("Mens Cotton Jacket")).
                body("category", hasItems("men's clothing","jewelery"));

    }

    @Test
    public void testPost()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        /*map.put("name","Pandu");
        map.put("job","Teacher");*/

        //System.out.println(map);

        JSONObject request = new JSONObject(map);
        request.put("name", "Pandu");
        request.put("job","Teacher");

        System.out.println(request.toJSONString());

        baseURI ="https://reqres.in/api";

        given().
                header("content-type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().statusCode(201).log().all();
    }
}
