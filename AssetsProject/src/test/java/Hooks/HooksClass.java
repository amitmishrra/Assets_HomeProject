package Hooks;

import Helper.HelperClass;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class HooksClass {
    @Before
    public static void getToken(){
        HashMap<String, String> pass = new HashMap<>();
        pass.put("password", "password");

       Response response = given().
                body(pass).
                when().
                post("https://02aa69f4-a2a8-4efe-8db0-b258a93f6d36.mock.pstmn.io/getToken");

//        System.out.println(response.);

//        System.out.println("the status code:-"+ response.then().extract().statusCode());
//        System.out.println("the status String:-"+ response.then().extract().asString());


    }

}
