

package com.w2a.RestAssured.API;


import static io.restassured.RestAssured.*;

import io.restassured.response.Response;


public class deleteRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		baseURI = "https://api.stripe.com";
		basePath = "/v1";
		deleteCustomer();
	}

	
	public static void deleteCustomer() {
		
		String id ="cus_G8AgwV3rAf7Emc";
		Response resp =given().auth()
		.basic("sk_test_oicpF8tiVKiLX0hPXDstp1Uu00A9FCJB6N", "").
		delete("https://api.stripe.com/v1/customers/cus_G8BR1LwN5ECmEr");
		//.then().statusCode(200);
		
		System.out.println("code "+resp.getStatusCode());
		System.out.println("response "+resp.asString());
	}
}
