package gitTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_GET_VerifyRepo {
	
	TC1_POST_NewRepo tc1 = new TC1_POST_NewRepo();

	@Test
	void verifyRepo() {
		
		RestAssured.baseURI = "https://api.github.com";
		
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("Niraj1103");
		authscheme.setPassword("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");
		RestAssured.authentication = authscheme;
		
		RequestSpecification httpRequest = RestAssured.given();
		
//		JSONObject requestParams = new JSONObject();
//
//		requestParams.put("repo", "RestAssuredNewRepo");
//		httpRequest.header("Content-Type","application/json");
//		httpRequest.body(requestParams.toJSONString());
		
		System.out.println(TC1_POST_NewRepo.RepoName);
		Response response = httpRequest.request(Method.GET, "/repos/Niraj1103/RestAssuredNewRepo");
		
		//Print response
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		
	}
}
