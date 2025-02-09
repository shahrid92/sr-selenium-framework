package api;
import common.utilities.RetryAnalyzer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TestAPI {

    public String generateStringFromResource(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));
    }

    @BeforeMethod
    public void setupREST(){
        RestAssured.baseURI = "https://79237dcd-8cc2-4180-8fdd-2fcee45847e6.mock.pstmn.io";

        // Enable debug mode globally
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        // Optional: Set detailed debug logging
        RestAssured.config = RestAssured.config()
                .logConfig(RestAssured.config().getLogConfig()
                        .enablePrettyPrinting(true));
    }

    @Test(enabled = true,retryAnalyzer = RetryAnalyzer.class)
    public void test_api_get() throws IOException{

        String jsonBody = generateStringFromResource("C:\\Users\\shahr\\Shah Workspace\\01 Practice\\sr-selenium-framework\\sr-selenium-practice\\src\\test\\resources\\test-api-resources\\TestAPI_POST_BODY.json");

        RequestSpecification httpRequest = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .log().all();

        Response response = httpRequest.post();

        response.then().log().all()
                .statusCode(201);

        System.out.println(response.getBody().print());

    }


    @Test(enabled = false)
    public void TestAPI2(){
        RestAssured.baseURI = "https://79237dcd-8cc2-4180-8fdd-2fcee45847e6.mock.pstmn.io";

        String requestBody = "{test:'test'}";


        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post()
                .then()
                .statusCode(400)
                .extract().response();

        System.out.println(response.getBody().prettyPrint());


    }


}
