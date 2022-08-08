package gitTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC3_DEL_delRepo {

	@Test
	void deleteRepo() {
		
		RestAssured.baseURI = "https://api.github.com";
		
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("Niraj1103");
		authscheme.setPassword("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");
		RestAssured.authentication = authscheme;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		
		//requestParams.put("owner", "Niraj1103");
		//requestParams.put("repo", "RestAssuredNewRepo");
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.DELETE, "/repos/Niraj1103/RestAssuredNewRepo");
		
		//Print response
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(response.getStatusCode(), 204);
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 204 No Content");
		
	}
}
