package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.acme.service.LoadService;


@QuarkusTest
public class ApplicationTest {

    @InjectMock
    LoadService service;

    @BeforeEach
    public void setup(){
        Mockito.doNothing().when(service).readAllData();
    }

    @Test
    public void testRunEndpoint() {
        given()
        .contentType(ContentType.JSON)
          .when().post("/run")
          .then()
             .statusCode(200)
             .body(is("{\"message\":\"Success\"}"));
    }

}