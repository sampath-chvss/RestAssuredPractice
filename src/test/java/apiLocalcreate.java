import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import javax.swing.text.AbstractDocument;

import static io.restassured.RestAssured.*;

public class apiLocalcreate {

    //@Test
    public void apiLocalTest_Get() {
        baseURI = "http://localhost:3000";
        given().get("/users").then().statusCode(200).log().all();

    }

    //@Test
    public void apiLocalTest_post() {
        baseURI = "http://localhost:3000";
        JSONObject json = new JSONObject();
        json.put("name","Ashish");
        json.put("Team", "Onboarding");
        json.put("roleid", 3);

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(json.toJSONString()).
                when().post("/users").
                then().statusCode(201).
                log().all();

        //when().get("/users").then().log().all();
    }

    //@Test
    public void apiLocalTest_put() {
        baseURI = "http://localhost:3000";
        JSONObject jsonput = new JSONObject();
        jsonput.put("name", "Shanthini");
        jsonput.put("team", "NewOnboarding");
        jsonput.put("roleid", "3");

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(jsonput.toJSONString()).
                when().put("/users/{id}",5).
                then().statusCode(200).
                log().all();
    }
   //@Test
    public void apiLocalTest_patch() {
        baseURI = "http://localhost:3000";
        JSONObject jsonput = new JSONObject();

        jsonput.put("team", "Onboarding");

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(jsonput.toJSONString()).
                when().patch("/users/{id}",5).
                then().statusCode(200).
                log().all();
    }

    //@Test
    public void apiLocalTest_delete() {
        baseURI = "http://localhost:3000";

        when().delete("/users/{id}",6).then().statusCode(200).log().all();

        when().get("/users").then().statusCode(200).log().all();
    }
}
