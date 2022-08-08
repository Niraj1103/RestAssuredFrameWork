package trelloTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_GET_TrelloBoard {
	// 62e55da2d9dd201926fb0a5d

	@Test
	void getBoard() {

		RestAssured.baseURI = "https://api.trello.com";
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("key", "6898bbc641f73c5d49c8f6c68f2ccfd0");
		requestParams.put("token", "4861184e96003b9230b03d46d8e87c1cd7e3f6f61c36a74c82221b1b4787b935");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		System.out.println(requestParams);

		Response response1 = httpRequest.request(Method.GET, "/1/boards/62efc8e574309800a4d08f0c");

		// Print Response in consol
		String responseBody = response1.getBody().asString();
		System.out.println(responseBody);

		// status code validation
		int statusCode = response1.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);

		String statusLine = response1.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
