package restassuredCRUD;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

//AUTOMATION TESTING FOR MULTIPLE SETS OF DATA
public class Parameterization_DataProvider_API_Testing {

    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost() {
////       Object [][] data= new Object[5][4]; //to accept all data types
////
////        data [0][0]= "Pooja";
////        data [0][1]= "Cannellio";
////        data [0][2]= 1;
////        data [0][3]= 6;
////
////        data [1][0]= "Amy";
////        data [1][1]= "Byer";
////        data [1][2]= 1;
////        data [1][3]= 1;
////
////        data [2][0]= "Rachel";
////        data [2][1]= "Real";
////        data [2][2]= 1;
////        data [2][3]= 2;
////
////        data [3][0]= "Justin";
////        data [3][1]= "Stevenson ";
////        data [3][2]= 1;
////        data [3][3]= 7;
////
////        data [4][0]= "Sam";
////        data [4][1]= "Steve";
////        data [4][2]= 2;
////        data [4][3]= 8;

//        return data;
        return new Object[][]{
                {"Alice", "Lewis", 1, 9},
                {"Qicey", "Chu", 2, 10}
        };
    }

    @Test(dataProvider = "DataForPost")
    public void Test2_Post(String firstName, String lastName, int SubjectID, int id) { //to add new entries -->using key and value pairs
        JSONObject request = new JSONObject();
        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("SubjectID", SubjectID);
        request.put("id", id);

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


    @DataProvider( name ="dataForDelete")
    public Object[][] dataForDelete() {
        return new Object[][]{
                {"Alice", "Lewis", 1, 9},
               {"Qicey", "Chu", 2, 10}
        };
    }
    @Test(dataProvider = "dataForDelete")
    public void test3_delete(String firstName, String lastName, int SubjectID, int id){
    baseURI = "http://localhost:3000/";
        when()
                .delete("/users/"+id).
        then()
                .statusCode(200)
                .log().all();

    }
}
