package org.example.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class CommonService {

    private static final String BASE_URI = "https://petstore.swagger.io/v2/";

    private final RequestSpecification requestSpecification;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = RestAssured.given().baseUri(BASE_URI);
        setCommonParams(requestSpecification);
    }

    protected void setCommonParams(RequestSpecification requestSpecification) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("api_key", "special-key");
        requestSpecification.headers(headers);
    }

    protected Response getRequest(String uri) {
        return RestAssured.given(requestSpecification).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(uri);
    }

    protected Response postRequest(String uri, Object body) {
        return RestAssured.given(requestSpecification).body(body).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().post(uri);
    }

    protected void deleteRequest(String uri) {
        RestAssured.given(requestSpecification).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().delete(uri);
    }
}
