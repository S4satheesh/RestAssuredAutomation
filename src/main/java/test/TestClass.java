package test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {


    @Test
    public void TestsExample(){

        Response response = get("https://fakestoreapi.com/products");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int StatusCode = response.statusCode();

        Assert.assertEquals(StatusCode, 200);
    }

    @Test
    public  void Test1()
    {
        baseURI = "https://fakestoreapi.com/products";
        System.out.println(given().get(baseURI).getStatusCode());

        // Using URL + then + finding the element in Body
        System.out.println( given().get(baseURI).then().statusCode(200).body("[2].id",equalTo(3)));
        // printing the log in console
        //given().get(baseURI).then().log().all();

        //To fetch only Body of the Json
        //given().get(baseURI).then().log().body();

        System.out.println(given().get(baseURI).cookies());
        System.out.println(given().get(baseURI).contentType());
        //System.out.println(given().get(baseURI).getHeaders());
        System.out.println(given().get(baseURI).getTime());

        //given().get(baseURI).then().time()
    }
}
