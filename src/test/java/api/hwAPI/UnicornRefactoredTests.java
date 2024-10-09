package api.hwAPI;


import api.UnicornRequests;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import api.hwAPI.models.Unicorn;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRefactoredTests {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://crudcrud.com/api/a8f3bf9239ce44a9911292d511c94eeb";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    Unicorn unicorn = Unicorn.builder()
            .name("Sparkle Angel")
            .age(2)
            .color("black")
            .build();

    @Test
    public void createUnicornTest() throws JsonProcessingException {
        UnicornRequests.createUnicorn(unicorn);
    }

    @Test
    public void deleteUnicornTest() throws JsonProcessingException {
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);
        UnicornRequests.deleteUnicorn (createdUnicorn);
        UnicornRequests.checkDeletedUnicorn(createdUnicorn);
    }

    @Test
    public void updateUnicornColorTest() throws JsonProcessingException {
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);
        UnicornRequests.updateUnicorn(createdUnicorn);
        UnicornRequests.createUnicorn(createdUnicorn);
    }
}
