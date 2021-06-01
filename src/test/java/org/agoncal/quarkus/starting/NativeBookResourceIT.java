package org.agoncal.quarkus.starting;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.NativeImageTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@NativeImageTest
public class NativeBookResourceIT extends BookResourceTest {

    @Test
    @Override
    public void ShouldGetABook() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).pathParam("id", 3).when().get("/api/books/{id}")
                .then().statusCode(200).body("title", is("Effective Java")).body("yearOfPublication", is(2001))
                .body("genre", is("Information Technology"));
    }
}