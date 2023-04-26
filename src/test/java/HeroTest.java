import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class HeroTest {

    @BeforeSuite
    public void beforeSuite() {
        JSONObject jasonObject = new JSONObject();
        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri("http://localhost:8080")
                .body(jasonObject.toString()).log().all()//before request
                .post("calculator/insert")
                .then().log().all();//response log
        System.out.println(response.extract().body().jsonPath().get("data.token").toString());
    }

    public void InsertHeroRecord(){
        JSONObject jasonObject = new JSONObject();
        jasonObject.put("birthday", birthday);
    }
}
