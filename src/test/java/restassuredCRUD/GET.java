package restassuredCRUD;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET {
	@Test
	public void test1() {
		
		//get the api url
		Response response1= get("https://reqres.in/api/users?page=2");
		
		//run queries/calls using .get()
		
		System.out.println(response1.getBody()); //to get body 
		System.out.println(response1.getStatusCode()); //to get status code 
		System.out.println(response1.asString()); //to print the response
		System.out.println(response1.getStatusLine()); 
		System.out.println(response1.getHeader("content-type")); 
		System.out.println(response1.getTime()); 
		
		//how to use assertions:example validate status code 
		int statusCode= response1.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	@Test 
	//BDD way of writing 
	public void test2() {
		given()
		     .get("https://reqres.in/api/users?page=2")
		.then()
		     .statusCode(200)
		     .body("data.id[2]", equalTo(9));
	}

}


