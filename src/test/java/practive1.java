import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class practive1 {

//    @Test(priority = 1)
//    public void test1() {
//    useRelaxedHTTPSValidation();
//    Response response = get("https://reqres.in/api/users?page=2");
//
//     System.out.println(response.getStatusCode());
//     //System.out.println(response.body().asString());
//}
//
//    @Test(priority = 2)
//    public void test2() {
//        baseURI = "https://reqres.in/api";
//        when().get("/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7)).log().all();
//
//    }

    @Test
    public  void test3(){
        useRelaxedHTTPSValidation();
        baseURI = "https://api.sampleapis.com/";
        when().get("coffee/hot")
                .then().statusCode(200)
                .body("title[0]", equalTo("Black Coffee"))
                .body("[1].ingredients[0]", equalTo("Espresso"))
                .log().all();
    }

    @Test
    public void test4(){
        useRelaxedHTTPSValidation();
        baseURI = "https://api.sampleapis.com/";
        Response response = when().get("coffee/hot");
        ArrayList<String> titlelist = response.jsonPath().get("title");
        System.out.println("Title List is : "+titlelist);
        ArrayList<String> description = response.jsonPath().get("description");

        for(int i=0; i < description.size(); i++){
            System.out.println("description List is : " +description.get(i) );
        }
    }
}
