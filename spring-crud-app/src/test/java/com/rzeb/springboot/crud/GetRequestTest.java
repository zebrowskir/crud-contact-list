package com.rzeb.springboot.crud;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequestTest {

	@Test
	void getContact() {
		
		//base URI
		
		//request obj
		RequestSpecification httpRequest = RestAssured.given();
		
		//response obj
		Response response = httpRequest.request(Method.GET, "/api/contacts");		
		
		//log response
		
		String responseBody = response.getBody().asString();
		System.out.println("Reseponse body: "+ responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		 
	}
	
	
}
