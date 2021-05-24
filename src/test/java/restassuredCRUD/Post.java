package restassuredCRUD;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

/*note to create post queries you need to create body--
 * it is done in 2 ways 
 * 1) By using Map class (key , value pairs in java) //this one is not best practice
 * 2)using json libraries */
 
public class Post{
	@Test
	public void Test1_PostUsingMap() {
		Map <String, Object> map= new HashMap <String, Object>();
		map.put("\"name\"", "Tommy");
		map.put("\"job\"", "Doctor");
		System.out.println(map);
    }
	
	@Test
	public void Test2_PostUisngLibraries() {
		
		JSONObject request1= new JSONObject();
		request1.put("name", "Tommy");
		request1.put("job", "Doctor");
		System.out.println(request1.toJSONString());//to convert response to String values 
		
    }
	@Test
	public void Test3_PostUsingBDD(){
		JSONObject request2= new JSONObject();
		request2.put("name", "Sam");
		request2.put("job", "Painter");
		
		given()												//to send request 
		       .body(request2.toJSONString()).
		when()												// mention the location 
		       .post("https://reqres.in/api/users").
		then() 												//validate if object is created
		       .statusCode(201);
	}
	@Test
	public void Test4_PostUsingBDDAndHeaders(){
		JSONObject request3= new JSONObject();
		request3.put("name", "Pamela");
		request3.put("job", "Teacher");
		
		given()	
		       .header("Content-Type", "application/json; charset=utf-8") 
		       .contentType(ContentType.JSON)
		       .accept(ContentType.JSON)
		       .body(request3.toJSONString()).
		when()												
		       .post("https://reqres.in/api/users").
		then() 												
		       .statusCode(201)
		       .log().all();
	}
}