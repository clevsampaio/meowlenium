package br.com.meowlenium.framework.utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class Rest {
    private String url;

    public Rest(String url) {
        this.url = url;
    }

    public ValidatableResponse get(String path, int statusCode) {
        return RestAssured.given().
            when().
                get(this.url + path).
            then().
                statusCode(statusCode);
    }

    public ValidatableResponse post(String path, int statusCode, Class object) {
        return RestAssured.given().
                body(object).
            when().
                post(this.url + path).
            then().
                statusCode(statusCode);
    }

    public ValidatableResponse post(String path, int statusCode, String json) {
        return RestAssured.given().
                body(json).
            when().
                post(this.url + path).
            then().
                statusCode(statusCode);
    }

    public ValidatableResponse put(String path, int statusCode, Class object) {
        return RestAssured.given().
                body(object).
            when().
                put(this.url + path).
            then().
                statusCode(statusCode);
    }

    public ValidatableResponse patch(String path, int statusCode, Class object) {
        return RestAssured.given().
                body(object).
            when().
                patch(this.url + path).
            then().
                statusCode(statusCode);
    }

    public ValidatableResponse delete(String path, int statusCode) {
        return RestAssured.given().
            when().
                delete(this.url + path).
            then().
                statusCode(statusCode);
    }
}