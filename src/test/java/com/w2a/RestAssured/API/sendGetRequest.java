package com.w2a.RestAssured.API;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;


public class sendGetRequest {
	
	public static String endPoint = "/customers";

//	baseURI = "http://myhost.org";
	
	public static void main(String[] args){
		
	baseURI = "https://api.stripe.com";
	basePath = "/v1";
	
	//getCustomerList();
	getCustomerListwithParm();
	}
	
	public static void getCustomerList() {
		
		Response resp = 	given().auth().basic("sk_test_oicpF8tiVKiLX0hPXDstp1Uu00A9FCJB6N", "")
				.get(baseURI+basePath+endPoint);
			resp.prettyPrint();
				System.out.println(resp.contentType());
				System.out.println(resp.getStatusCode());
				System.out.println(resp.asString());
	}
	
	public static void getCustomerListwithParm() {
		
		Response resp = 	given()
				.header("Authorization", "bearer sk_test_oicpF8tiVKiLX0hPXDstp1Uu00A9FCJB6N")
				.param("limit", 3).get(baseURI+basePath+endPoint);
				
				
				
			resp.prettyPrint();
				System.out.println(resp.contentType());
				System.out.println(resp.getStatusCode());
				System.out.println(resp.asString());
	}
}
