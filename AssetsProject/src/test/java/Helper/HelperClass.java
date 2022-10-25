package Helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

import java.util.List;

public class HelperClass {
    public static String getResponseString(String response, String path){
        JsonPath j = new JsonPath(response);
        String result = j.getString(path);
        return  result;
    }

    public static int getResponseInt(String response, String path){
        JsonPath j = new JsonPath(response);
        int result = j.getInt(path);
        return  result;
    }

    public static List getResponseList(String response, String path){
        JsonPath j = new JsonPath(response);
        List result = j.getList(path);


        return  result;
    }

    public static void validateListItem(Object expected, List list){
        if(list.contains(expected)){
            System.out.println("List contains "+ expected);
        }else {
            System.out.println("List does not contain "+ expected);
        }
    }
    public static void validateFullList(List expected, List  actual){
        Assert.assertEquals(expected, actual);
    }
}
