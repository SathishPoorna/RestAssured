package com.w2a.RestAssured.API;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class sendPostRequest {
	
	public static String endPoint = "/customers";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		baseURI = "https://api.stripe.com";
		basePath = "/v1";
		
		//getCustomerList();
		postCreateCust();
		//postUsingJsonString();
		//postUsingJsonFile();
		//postjson();
		//postJsonAPI();
		//postPOJO();
		//parseResp();
	}
	
	
	public static void postCreateCust() {
		
		Response resp = 	given().auth()
				.basic("sk_test_oicpF8tiVKiLX0hPXDstp1Uu00A9FCJB6N", "")
				.formParam("email","testauto3@automation.com" )
				.formParam("name", "testAuto3")
				.formParam("description","testauto3")
				.post(baseURI+basePath+endPoint);
			
		
		resp.prettyPrint();
				System.out.println(resp.contentType());
				System.out.println(resp.getStatusCode());
				System.out.println(resp.asString());
	}
	
	public static void postUsingJsonString() {
		
		String json = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		Response resp = 	given().contentType("application/json").log().all().body(json)				
				.post("https://reqres.in/api/users");
			
		
		resp.prettyPrint();
				System.out.println(resp.contentType());
				System.out.println(resp.getStatusCode());
				System.out.println(resp.asString());
				
				
	}
	
public static void postUsingMap() {
	
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("name", "morpheus");
	map.put("job", "leader");
	
		
		//String json = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		Response resp = 	given().contentType("application/json").body(map)				
				.post("https://reqres.in/api/users");
			
		
		resp.prettyPrint();
				System.out.println(resp.contentType());
				System.out.println(resp.getStatusCode());
				System.out.println(resp.asString());
				
				
	}


public static void postUsingJsonFile() {
	
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("name", "morpheus");
	map.put("job", "leader");
	
		
		//String json = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		Response resp = 	given().contentType("application/json").log().all().body(new File("./sampledata.json"))				
				.post("https://reqres.in/api/users");
			
		
		resp.prettyPrint();
				System.out.println(resp.contentType());
				System.out.println(resp.getStatusCode());
				System.out.println(resp.asString());
				
	}


public static void postjson() {
	
	/*http://localhost:8080/swagger-ui.html#/user-controller/getAllUsersUsingGET
	  {
    "firstName": "Rahul",
    "lastName": "Arora",
    "address": {
        "country": "India",
        "flatNo": "A-131",
        "city": "New Delhi",
        "State": "Delhi"
    },
    "education": [
        {
            "year": 2009,
            "course": "BE"
        },
        {
            "year": 2010,
            "course": "BE"
        }
    ],
    "mobile": [
        234324234,
        234323422
    ],
    "primaryskills": [
        "c++",
        "Java",
        "Selenium"
    ],
    "email": "rahul@gmail.com"
}**/
	
	HashMap<String,Object> map = new HashMap<String,Object>();
	map.put("email", "sathishpoorna@gmail.com");
	map.put("firstName", "sathish");
	map.put("lastName", "poorna");
	
	ArrayList<Integer> listOfMoibleNos = new ArrayList<Integer>();
	listOfMoibleNos.add(234324234);
	listOfMoibleNos.add(234323422);
	
	map.put("mobile", listOfMoibleNos);
	
	HashMap<String,String> address = new HashMap<String,String>();
	address.put("flatNo", "A131");
	address.put("city", "chennai");
	address.put("State", "TN");
	address.put("country", "India");
	
	map.put("address", address);
	
	ArrayList<String> primarySkills = new ArrayList<String>();
	primarySkills.add("c++");
	primarySkills.add("Java");
	primarySkills.add("Selenium");
	map.put("primaryskills", primarySkills);
	
	ArrayList<HashMap> education = new ArrayList<HashMap>();
	
	HashMap<String,Object> eduction1 = new HashMap<String,Object>();
	eduction1.put("course", "BE");
	eduction1.put("year", 2009);
	
	HashMap<String,Object> eduction2 = new HashMap<String,Object>();
	eduction2.put("course", "BE");
	eduction2.put("year", 2010);
	
	education.add(eduction1);
	education.add(eduction2);
	map.put("education", education);
	
	
Response response = given().contentType(ContentType.JSON).body(map).log().all().post("http://localhost:8080/api/users");
	response.prettyPrint();
	System.out.println(response.getStatusCode());
	
}

public static void postJsonAPI() {
	
	JSONObject jsonobj = new JSONObject();
	jsonobj.put("email", "sathish@gmail.com");
	jsonobj.put("firstName", "sathish");
	jsonobj.put("lastName", "poorna");
	
	JSONArray listOfMoibleNos = new JSONArray();

	listOfMoibleNos.put(234324234);
	listOfMoibleNos.put(234323422);
	jsonobj.put("listOfMoibleNos", listOfMoibleNos);
	
	Response response = given().contentType(ContentType.JSON).body(jsonobj.toString()).log().all().post("http://localhost:8080/api/users");
	response.prettyPrint();
	System.out.println(response.getStatusCode());
	//System.out.println(response.asString());
}


public static void postPOJO() {
	
UserDetails details = new UserDetails("sathish@gmail.com", "sathish", "poorna");
	
	Response response = given().contentType(ContentType.JSON).body(details).log().all().post("http://localhost:8080/api/users");
	response.prettyPrint();
	System.out.println(response.getStatusCode());
	//System.out.println(response.asString());
}


public static void parseResp() {
	
	Response resp = 	given().auth()
			.basic("sk_test_oicpF8tiVKiLX0hPXDstp1Uu00A9FCJB6N", "")
			.formParam("email","testauto1@automation.com" )
			.formParam("name", "testAuto1")
			.formParam("description","testauto1")
			.post(baseURI+basePath+endPoint);
		
	
	resp.prettyPrint();
			System.out.println(resp.contentType());
			System.out.println(resp.getStatusCode());
			System.out.println(resp.asString());
			
			System.out.println(resp.jsonPath().get("id"))	;
			System.out.println(resp.jsonPath().get("created"))	;
			System.out.println(resp.jsonPath().get("description"))	;
			System.out.println(resp.jsonPath().get("sources.object"))	;
			
}


}
