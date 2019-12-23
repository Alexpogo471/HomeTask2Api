import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestMain {

    // RequestFilter
    public static void debug() {
        RestAssured.filters(
                ResponseLoggingFilter.responseLogger(),
                new RequestLoggingFilter());
    }

    @BeforeClass(description = "Base URL")
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }


    @Test
    public void testApiAlbumsTitle0(){
        setup();
        JsonPath body = given()
                .when().get("/albums")
                .then().statusCode(200).extract().body().jsonPath();
        debug();
        System.out.println(body.get("title[0]").toString());
    }

    @Test
    public void testApiAlbumsTitle30(){
        setup();
        JsonPath body = (JsonPath) given()
                .when().get("/albums?id=6")
                .then().assertThat()
                .body(matchesJsonSchemaInClasspath("Json.json"));
        debug();
        System.out.println(body.get("title[30]").toString());
    }

    @Test
    public void testApiAlbumsId5(){
        setup();
        JsonPath body = given()
                .when().get("/albums")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("id[5]").toString());
    }

    @Test
    public void testApiUsers1(){
        setup();
        JsonPath body = given().header("User","Agent")
                .when().get("/users")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("name[1]").toString());
    }

    @Test
    public void testApiToDos(){
        setup();
        JsonPath body = given().header("User","Agent")
                .when().get("/todos")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("title[0]").toString());
    }

    @Test
    public void testApiToDos2(){
        setup();
        JsonPath body = given().header("User","Agent")
                .when().get("/todos")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("title[3]").toString());
    }

    @Test
    public void testApiPhotos(){
        setup();
        JsonPath body = given()
                .when().get("/photos")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("url[0]").toString());
    }

    @Test
    public void testApiPhotos2(){
        setup();
        JsonPath body = given()
                .when().get("/photos")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("url[2]").toString());
    }

    @Test
    public void testApiComments(){
        setup();
        JsonPath body = given()
                .when().get("/comments")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("body[0]").toString());
    }

    @Test
    public void testApiComments2(){
        setup();
        JsonPath body = given()
                .when().get("/comments")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("body[2]").toString());
    }

    @Test
    public void testApiUsers2(){
        setup();
        JsonPath body = given()
                .when().get("/users")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("phone[2]").toString());
    }

    @Test
    public void testApiUsers3(){
        setup();
        JsonPath body = given()
                .when().get("/users?name=2")
                .then().extract().body().jsonPath();
        debug();
        System.out.println(body.get("website[2]").toString());
    }
}
