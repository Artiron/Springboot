package com.risa.boot.demo.controller;

import com.risa.boot.demo.model.BookDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class ControllerIntegrationTest {
    @LocalServerPort
    private int port;


    @Before
    public void setup() {

        RestAssured.port = port;
    }

    @Test
    public void saveBookTest() {

        BookDto book = new BookDto();
        book.setBookName("Ebala");
        book.setCountPage(99);
        book.setYear(1994);
        given().contentType(ContentType.JSON).body(book)
                .when().post("/rest/books/save")
                .then().statusCode(HttpStatus.CREATED.value());


        given().pathParam("id", book.getId())
                .when().get("/rest/books/{id}")
                .then().statusCode(HttpStatus.OK.value())
                .and().body("name", equalTo("Joe"));

    }




}


