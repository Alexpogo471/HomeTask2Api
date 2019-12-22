import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestMain {

    public static void debug() {
        RestAssured.filters(
                ResponseLoggingFilter.responseLogger(),
                new RequestLoggingFilter());
    }

    @Test
    public void testApiAlbumsTitle0(){
        String URL = "https://jsonplaceholder.typicode.com/albums";
        JsonPath body = given()
                .when().get(URL)
                .then().statusCode(200).extract().body().jsonPath();
        debug();
        System.out.println(body.get("title[0]").toString());
    }

    @Test
    public void testApiAlbumsTitle30(){
        String URL = "https://jsonplaceholder.typicode.com/albums";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("title[30]").toString());
    }

    @Test
    public void testApiAlbumsId5(){
        String URL = "https://jsonplaceholder.typicode.com/albums";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("id[5]").toString());
    }

    @Test
    public void testApiUsers1(){
        String URL = "https://jsonplaceholder.typicode.com/users";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("name[1]").toString());
    }

    @Test
    public void testApiToDos(){
        String URL = "https://jsonplaceholder.typicode.com/todos";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("title[0]").toString());
    }

    @Test
    public void testApiToDos2(){
        String URL = "https://jsonplaceholder.typicode.com/todos";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("title[3]").toString());
    }

    @Test
    public void testApiPhotos(){
        String URL = "https://jsonplaceholder.typicode.com/photos";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("url[0]").toString());
    }

    @Test
    public void testApiPhotos2(){
        String URL = "https://jsonplaceholder.typicode.com/photos";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("url[2]").toString());
    }

    @Test
    public void testApiComments(){
        String URL = "https://jsonplaceholder.typicode.com/comments";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("body[0]").toString());
    }

    @Test
    public void testApiComments2(){
        String URL = "https://jsonplaceholder.typicode.com/comments";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("body[2]").toString());
    }

    @Test
    public void testApiUsers2(){
        String URL = "https://jsonplaceholder.typicode.com/users";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("phone[2]").toString());
    }

    @Test
    public void testApiUsers3(){
        String URL = "https://jsonplaceholder.typicode.com/users";
        JsonPath body = given().log().all()
                .when().get(URL)
                .then().extract().body().jsonPath();
        System.out.println(body.get("website[2]").toString());
    }
}
