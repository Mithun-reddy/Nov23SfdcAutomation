package utils;

import java.io.File;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class RestUtils {

	/**
	 * @param headers
	 * @param payload
	 * @param endPoint
	 * @return
	 */
	public Response post(HashMap<String, String> headers, Object payload, String endPoint) {
		return RestAssured.given().headers(headers).body(payload).when().post(endPoint);
	}

	/**
	 * @param header
	 * @param endPoint
	 * @return
	 */
	public Response get(HashMap<String, String> header, String endPoint) {
		return RestAssured.given().headers(header).when().get(endPoint);
	}

	public Response put(HashMap<String, String> headers, HashMap<String, String> payload, String endPoint) {
		return RestAssured.given().headers(headers).body(payload).when().put(endPoint);
	}

	public void validateSchema(Response res, File schema) {

		res.then().assertThat().body(matchesJsonSchema(schema)).extract().response();

	}

}
