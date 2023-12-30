import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;



public class Request_Practice {

    @Test
    public void testPost() {
        useRelaxedHTTPSValidation();
        baseURI = "https://reqres.in/";
        when().get("api/users").then().statusCode(200).log().all();

        JSONObject json = new JSONObject();
        json.put("Name","Sampath");
        json.put("job","Tester");
        System.out.println("new json added : "+json.toJSONString());

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(json.toJSONString()).
                when().
                post("api/users").
                then().statusCode(201).log().
                all();

    }

    @Test
    public void testPut() {
        useRelaxedHTTPSValidation();
        baseURI = "https://reqres.in/";

        JSONObject json = new JSONObject();
        json.put("name","Sampathput");
        json.put("job","Testerput");
        System.out.println("new json added : "+json.toJSONString());

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(json.toJSONString()).
                when().
                put("api/users/2").
                then().statusCode(200).log().
                all();

    }

    @Test
    public void testPatch() {
        useRelaxedHTTPSValidation();
        baseURI = "https://reqres.in/";

        JSONObject json = new JSONObject();
        json.put("name","Sampathpatch");
        json.put("job","Testerpatch");
        System.out.println("new json added : " + json.toJSONString());

        given().contentType(ContentType.JSON).accept(ContentType.JSON).
                body(json.toJSONString()).
                when().
                patch("api/users/2").
                then().statusCode(200).log().
                all();

    }

    @Test
    public void testDelete() {
        useRelaxedHTTPSValidation();
        baseURI = "https://reqres.in/";

        when().delete("api/users/2").
                then().
                statusCode(204).
                log().all();
    }

}
