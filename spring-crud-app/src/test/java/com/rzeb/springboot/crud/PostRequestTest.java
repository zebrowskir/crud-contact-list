package com.rzeb.springboot.crud;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostRequestTest {

	@Test
	void postContact() {
		
		//base URI
		
		//request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstName", "John");
		requestParams.put("lastName", "Newman");
		requestParams.put("email", "john@newman.com");
		
		httpRequest.header("Content-Type","application/json");		
		httpRequest.body(requestParams.toJSONString());
		

		Response response = httpRequest.request(Method.POST, "/api/contacts");				
		
		//log response		
		String responseBody = response.getBody().asString();
		System.out.println("Reseponse body: "+ responseBody);
		
		Assert.assertEquals(responseBody.contains("John"), true);
		Assert.assertEquals(responseBody.contains("Newman"), true);
		Assert.assertEquals(responseBody.contains("@newman.com"), true);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);		
	}	
}
