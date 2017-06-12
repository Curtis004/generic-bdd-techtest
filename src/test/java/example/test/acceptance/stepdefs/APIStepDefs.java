package example.test.acceptance.stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java8.En;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.options;
import static io.restassured.RestAssured.request;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

public class APIStepDefs implements En {
    Response response;

    @Before("@APIAcceptanceTest")
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation(); // As we're going over HTTPS (fastest way to just make this work).
        RestAssured.baseURI = "https://restcountries.eu"; // Externalise
    }

    public APIStepDefs() {
        Given("^([^\"]*) supports ([^\"]*) requests$", (String url, String method) ->
            when()
                .options(url)
            .then()
                    .assertThat().statusCode(200)
                    .and()
                    .assertThat().body(containsString(method))
        );
        Given("^([^\"]*) does not support ([^\"]*) requests$", (String url, String method) ->
            when()
                .options(url)
            .then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().body(not(containsString(method)))
        );
        When("^a ([^\"]*) request is made to ([^\"]*)$", (String method, String url) ->
            response = request(
                Method.valueOf(method), url
            )
        );
        Then("^the status code returned should be (\\d+)$", (Integer statusCode) ->
            response.then().assertThat().statusCode(statusCode)
        );
    }
}
