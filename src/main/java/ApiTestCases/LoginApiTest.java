package ApiTestCases;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import ApiTestData.AddUser;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import utils.ApiFileUtils;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class LoginApiTest extends BaseApiTest{
	String token = null;
	
	
	@Test (priority = -1)
	public void loginTest01() throws IOException {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type","application/json");
		
		Object payload = ApiFileUtils.getTestData("$.payload.login");
		
		Response  loginRes = request.post(headers, payload, "login");
		
		request.validateSchema(loginRes, new File(System.getProperty("user.dir")+"/src/main/java/ResponseSchemas/LoginSchema.json"));
		
		assertThat("Status code should match", loginRes.getStatusCode() == 201);
//		assertThat(new String[] {"",""}, con
		
	}
	
	@Test
	public void getDataTest() {
		
		Response getReq =  RestAssured.given()
				.header("Content-Type","application/json")
				.header("token", token)
		.when().get("getdata").then().statusCode(200).extract().response();
		
//		System.out.println(getReq.asPrettyString());
	}
	
	@Test
	public void addUserTest() throws JsonProcessingException {
//		HashMap<String, String> user1 = new HashMap<String, String>();
//		user1.put("accountno", "TA-5781444");
//		user1.put("departmentno", "4");
//		user1.put("salary", "2355");
//		user1.put("pincode", "345667");
//		
//		JsonObject user = new JsonObject();
//		user.addProperty("accountno", "TA-5781444");
//		user.addProperty("departmentno", "4");
//		user.addProperty("salary", "2355");
//		user.addProperty("pincode", "345667");
		AddUser user = new AddUser("TA-5674578", "3", "34566", "678900");
		
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String jString = om.writeValueAsString(user);
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type","application/json");
		headers.put("token", token);
		
		Response getReq =  RestAssured.given().headers(headers)
				.body(jString)
		.when().post("addData").then().statusCode(201).extract().response();
		
		System.out.println(getReq.asPrettyString());
	}

}
