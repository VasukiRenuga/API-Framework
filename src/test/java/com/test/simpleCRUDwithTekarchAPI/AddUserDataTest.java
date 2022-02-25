package com.test.simpleCRUDwithTekarchAPI;

import org.testng.annotations.Test;

import com.test.constants.EndPoints;
import com.test.models.AddUserPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
//import pojos.AddUserPojo;

public class AddUserDataTest {

	@Test
	public static void addUserPojo()
	{
		if(LoginToAPI.token1==null)
		{
			LoginToAPI.loginPojo();
		}
		AddUserPojo obj=new AddUserPojo();
		obj.setAccountno("TA-93333334");
		obj.setDepartmentno("3");
		obj.setSalary("00003");
		obj.setPincode("000003");
		Header header1=new Header("token",LoginToAPI.token1);
		Response res=RestAssured.
				given().
		header(header1).
		contentType(ContentType.JSON).
		body(obj).
		when().
		post(EndPoints.BASE_URI+EndPoints.ADD_DATA);
		res.then().statusCode(201);
		String value=res.jsonPath().get("status");
		System.out.println(value);
		System.out.println("End of AddUser");
	}
}