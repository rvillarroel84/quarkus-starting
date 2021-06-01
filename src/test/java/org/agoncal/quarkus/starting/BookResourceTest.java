package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).when().get("/api/books").then().statusCode(200)
                .body("size()", is(4));
    }

    @Test
    public void ShouldCountAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).when().get("/api/books/count").then().statusCode(200)
                .body(is("4"));
    }

    @Test
    public void ShouldGetABook() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).pathParam("id", 3).when().get("/api/books/{id}")
                .then().statusCode(200).body("title", is("Effective Java")).body("yearOfPublication", is(2001))
                .body("genre", is("IT"));
    }
}