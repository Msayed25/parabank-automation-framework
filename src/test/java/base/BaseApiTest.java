package base;
//import config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utilities.ConfigReader;

//import static io.restassured.RestAssured.config;

public class BaseApiTest {
    protected String baseUrl;
    protected String username;
    protected String password;

    @BeforeClass
    public void setupApi() {
        baseUrl = ConfigReader.getProperty("api.base.url");
        username = ConfigReader.getProperty("default.username");
        password = ConfigReader.getProperty("default.password");
        RestAssured.baseURI = baseUrl;
    }
}

