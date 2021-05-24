package restassuredCRUD;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//PUT , PATCH AND DELETE 
public class PutPatchAndDelete {//for put just need to update so most part is the same as post 
	@Test
	public void Test1_Put() {//to update 
		JSONObject request3= new JSONObject();
		request3.put("name", "Pamela");
		request3.put("job", "Teacher");
		
		given()	
		       .header("Content-Type", "application/json; charset=utf-8") 
		       .contentType(ContentType.JSON)
		       .accept(ContentType.JSON)
		       .body(request3.toJSONString()).
		when()												
		       .put("https://reqres.in/api/users/2").
		then() 												
		       .statusCode(200)
		       .log().all();
		//to print the response 
		
	}
	@Test
	public void Test2_Patch() {// partial update 
		JSONObject request3= new JSONObject();
		request3.put("name", "Pamela");
		request3.put("job", "Teacher");
		
		given()	
		       .header("Content-Type", "application/json; charset=utf-8") 
		       .contentType(ContentType.JSON)
		       .accept(ContentType.JSON)
		       .body(request3.toJSONString()).
		when()												
		       .patch("https://reqres.in/api/users/2").
		then() 												
		       .statusCode(200)
		       .log().all();
		//to print the response 
		
	}
	@Test
	public void Test3_Delete() {// to delete
		when()												
		       .delete("https://reqres.in/api/users/2").
		then() 												
		       .statusCode(204) //204 is the code for delete /no content
		       .log().all();
	

}
}
