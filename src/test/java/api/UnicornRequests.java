package api;

import api.hwAPI.models.Unicorn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static Unicorn createUnicorn(Unicorn unicorn) throws JsonProcessingException {

        return given()
                .contentType(ContentType.JSON)
                .body(unicorn)
                .post("/unicorns ")
                .then().statusCode(201)
                .body("$", hasKey("_id"))
                .extract().as(Unicorn.class);
    }

    public static void deleteUnicorn(Unicorn unicorn){
        given()
                .contentType(ContentType.JSON)
                .delete("/unicorns/"+unicorn.getId())
                .then().statusCode(200);
    }

    public static void updateUnicorn(Unicorn unicorn) throws JsonProcessingException {
        String unicornJson = objectMapper.writeValueAsString(unicorn);
        given()
                .contentType(ContentType.JSON)
                .body(unicornJson)
                .put("/unicorns/"+unicorn.getId())
                .then().statusCode(200);
    }

    public static void checkDeletedUnicorn(Unicorn unicorn){
        given()
                .get("/unicorns/" + unicorn.getId())
                .then()
                .statusCode(404);
    }
}
