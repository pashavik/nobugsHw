package hwAPI;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UnicornTests {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://crudcrud.com/api/80f3f466f29346e1979e92732899f91e";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
    @Test
    public void createUnicornTest(){
        given()
                .contentType(ContentType.JSON)
                .body("{\n" + "  \"name\": \"SkyFall \",\n" + "  \"hair_color\": \"Night\"\n" + "}")
                .post("/unicorns ")
                .then().statusCode(201)
                .body("$", hasKey("_id"));
    }

    @Test
    public void deleteUnicornTest(){
        String id = given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"Sparkle Angel\", \"age\":2, \"colour\":\"blue\" }")
                .post("/unicorns")
                .then().statusCode(201)
                .body("$", hasKey("_id"))
                .extract().path("_id");

        given()
                .contentType(ContentType.JSON)
                .delete("/unicorns/"+id)
                .then().statusCode(200);

        given()
                .get("/unicorns/" + id)
                .then()
                .statusCode(404);
    }
    @Test
    public void updateUnicornColorTest(){

        String id = given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"Sparkle Angel\", \"age\":2, \"colour\":\"blue\" }")
                .post("/unicorns")
                .then().statusCode(201)
                .body("$", hasKey("_id"))
                .extract().path("_id");

        given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"Sparkle Angel\", \"age\":2, \"colour\":\"red\" }")
                .put("/unicorns/"+id)
                .then().statusCode(200);

        given()
                .get("/unicorns/" + id)
                .then()
                .assertThat()
                .statusCode(200)
                .body("colour", equalTo("red"));
    }
}
