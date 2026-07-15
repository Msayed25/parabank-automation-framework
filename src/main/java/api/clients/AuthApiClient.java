package api.clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApiClient {

    public Response login(String username, String password) {
        return given()
                .accept("application/json")
                .pathParam("username", username)
                .pathParam("password", password)
                .when()
                .get("/login/{username}/{password}");
    }
}
