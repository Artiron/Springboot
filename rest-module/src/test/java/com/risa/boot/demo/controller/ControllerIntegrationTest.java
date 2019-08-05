package com.risa.boot.demo.controller;

import com.risa.boot.demo.model.BookDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@ActiveProfiles("test")
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
        BookDto result = saveBook(book);
        Assert.assertEquals(result.getCountPage(), book.getCountPage());
        Assert.assertEquals(result.getBookName(), book.getBookName());
        Assert.assertEquals(result.getYear(), book.getYear());
        Assert.assertNotNull(result.getId());
    }

    @Test
    public void getBookTest() {
        BookDto bookDto = new BookDto();
        bookDto.setBookName("DROCUI");
        bookDto.setCountPage(99);
        bookDto.setYear(1999);
        BookDto dto = saveBook(bookDto);
        BookDto result = given().pathParam("id", dto.getId())
                .when().get("/rest/books/{id}")
                .then().extract().body().as(BookDto.class);
        Assert.assertEquals(result, dto);
    }

    private BookDto saveBook(BookDto bookDto) {
        return given().body(bookDto).contentType(ContentType.JSON)
                .post("/rest/books/save")
                .then().extract().body().as(BookDto.class);
    }

    @Test
    public void deleteBookTest() {
        BookDto book = new BookDto();
        book.setBookName("Ebala");
        book.setCountPage(99);
        book.setYear(1994);
        BookDto dto = saveBook(book);
        given().pathParam("id", dto.getId())
                .when().delete("/rest/books/delete/{id}")
                .then().statusCode(HttpStatus.OK.value());
        given().pathParam("id", dto.getId())
                .when().get("/rest/books/{id}")
                .then().statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void getBooksTest() {
        BookDto[] bookDtos = given()
                .when().get("/rest/books/")
                .then().extract().body().as(BookDto[].class);
        Assert.assertEquals(bookDtos.length, 0);
    }
}


