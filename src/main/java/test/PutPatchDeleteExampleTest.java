package test;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;


public class PutPatchDeleteExampleTest {

    @Test
    public void testPut()
    {

        JSONObject request = new JSONObject();
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
                put("/users/2").
                then().statusCode(200).log().all();
    }

    @Test
    public void testPatch()
    {

        JSONObject request = new JSONObject();
        request.put("name", "Pandu");
        request.put("job","Teacher");

        System.out.println(request.toJSONString());

        baseURI ="https://reqres.in";

        given().
                header("content-type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/api/users/2").
                then().statusCode(200).log().all();
    }

    @Test
    public void testDelete()
    {

       baseURI ="https://reqres.in";

               when().
                delete("/api/users/2").
                then().statusCode(204).log().all();
    }
}
