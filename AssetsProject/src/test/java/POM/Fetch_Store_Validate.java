package POM;
import Helper.HelperClass;
import Hooks.HooksClass;
import io.restassured.response.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;



public class Fetch_Store_Validate {
public static String response;
public static int id;
public static List batters;
public static String topping;

public static List <String> demoList = new ArrayList<>();


public static void fetch(){
    HashMap<String, String> pass = new HashMap<>();
    pass.put("password", "amit");

    response = given().
            body(pass).
            when().
            post("https://02aa69f4-a2a8-4efe-8db0-b258a93f6d36.mock.pstmn.io/post").asString();
}


public static void storeResponse(){
 id =  HelperClass.getResponseInt(response, "[0].ppu");
    System.out.println(id);

    batters = HelperClass.getResponseList(response, "[0].batters.batter.type");
    System.out.println(batters);

    topping = HelperClass.getResponseString(response, "[2].topping[3].type");
    System.out.println(topping);
}

public static void validateResponse(){
    demoList.add("Regular");
    demoList.add("Chocolate");
    demoList.add("Blueberry");
    demoList.add("Devil's Food");

    HelperClass.validateListItem("Regular", batters);

    HelperClass.validateFullList(batters, demoList);

    HooksClass.getToken();
}

}
