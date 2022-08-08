package gitTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_POST_NewRepo {

	public static String RepoName;
	public static String FullRepoName;
	
	@Test
	public static void newRepo() {
		
		RestAssured.baseURI = "https://api.github.com";
		
		//basic authentication
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("Niraj1103");
		authscheme.setPassword("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");
		RestAssured.authentication = authscheme;
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "RestAssuredNewRepo");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST	,"/user/repos");
		
		//Print response
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(response.getStatusCode(), 201);
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		
		JsonPath jsonpath = response.jsonPath();
		RepoName = jsonpath.get("name");
		FullRepoName = jsonpath.get("full_name");
		System.out.println(RepoName);
	}
}
