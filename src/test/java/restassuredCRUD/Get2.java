package restassured1;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get2 {
	
	@Test
	public void Test_1_printAllResponse() {
		given()
		        .get("https://reqres.in/api/users?page=2")
		.then().log().all();//this prints entire response 
	}
	@Test
	public void Test_2_validateStatusCodeAndBody() {
		given()
		       .get("https://reqres.in/api/users?page=2")
		.then().statusCode(200)
		       .body("data.email[0]", equalTo("michael.lawson@reqres.in"))
		       .body("data.first_name", hasItems("Tobias", "George"));//in case you want
		//to check particular value present example certain first name 
		       	       
	}
	@Test
	public void Test3_usingHeadersAndParam() {
		given()
		       .header("Content-Type", "application/json; charset=utf-8")
		       .param("key", "value")
		       .get("https://reqres.in/api/users?page=2")
		.then()
		        .statusCode(200);
		    	
	}

}
