package restassuredCRUD;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

                             //AUTOMATING API REQUESTS WITH EXAMPLES
public class AutomationExamples {
    @Test
    public void Test1_Get() { //to get response
        baseURI = "http://localhost:3000/"; //name of the local host as it is common for all cases
        given()
                .get("/users").          // the remaining path
                then()
                .statusCode(200)
                .log().all()
                .body("users.id[0]", equalTo(1));
    }

    @Test
    public void Test2_Post() { //to add new entries -->using key and value pairs
        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "Jones");
        request.put("SubjectID", 5);
        request.put("id", 5);

        baseURI = "http://localhost:3000/";
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .post("/users").
                then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void Test3_PutORPatch() { //to update entries
        JSONObject request = new JSONObject();
        request.put("firstName", "Rachel");
        request.put("lastName", "Jones");
        request.put("SubjectID", 5);
        request.put("id", 5);

        baseURI = "http://localhost:3000/";
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when()
                .put("/users/5").  //5 refers to id 5
        then()
                .statusCode(200)
                .log().all();

    }
    @Test
    public void Test4_delete() { //to delete entries
        baseURI = "http://localhost:3000/";
        when()
                .delete("/users/5").
                then()
                .statusCode(200)
                .log().all();

    }
}
