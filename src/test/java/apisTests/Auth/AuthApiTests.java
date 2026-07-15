package apisTests.Auth;

import api.clients.AuthApiClient;
import base.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Feature("Authentication API")
public class AuthApiTests extends BaseApiTest {

    private final AuthApiClient authApiClient = new AuthApiClient();

    @Test
    @Description("Verify login API with valid username and password")
    public void verifyLoginWithValidCredentials() {

        Response response = authApiClient.login(username, password);

        response.prettyPrint();

        assertEquals(response.statusCode(), 200, "Status code should be 200");
        assertTrue(response.asString().contains("id"), "Response should contain customer id");
        assertTrue(response.asString().contains("firstName"), "Response should contain firstName");
        assertTrue(response.asString().contains("lastName"), "Response should contain lastName");
    }

    @Test
    @Description("Verify login API with invalid password")
    public void verifyLoginWithInvalidPassword() {

        Response response = authApiClient.login(username, "WrongPassword123");

        response.prettyPrint();

        assertNotEquals(response.statusCode(), 200, "Invalid login should not return 200");
    }
}