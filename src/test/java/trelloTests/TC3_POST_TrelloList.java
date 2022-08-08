package trelloTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC3_POST_TrelloList   {
	
	
	@Test
	void postList() {
		
		//specify base URI
		RestAssured.baseURI = "https://api.trello.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "List1");
		requestParams.put("idBoard", "62efc8e574309800a4d08f0c");
		requestParams.put("key", "6898bbc641f73c5d49c8f6c68f2ccfd0");
		requestParams.put("token", "4861184e96003b9230b03d46d8e87c1cd7e3f6f61c36a74c82221b1b4787b935");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "/1/lists");
		
		
		//Print Response in consol
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
