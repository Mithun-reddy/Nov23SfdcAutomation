package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.JsonPath;

import Constants.FileConstants;

public class ApiFileUtils {
	
	public static String readJsonFileToString() throws IOException {
		byte[] data = Files.readAllBytes(Paths.get(FileConstants.API_TEST_DATA_FILE));
		return new String(data, StandardCharsets.UTF_8);
	}
	
	public static Object getTestData(String jsonPath) throws IOException {
		String testData = "";
		testData = ApiFileUtils.readJsonFileToString();
		Object value = JsonPath.read(testData, jsonPath);
		JsonPath.read(testData, jsonPath);
		return value;
	}

}
