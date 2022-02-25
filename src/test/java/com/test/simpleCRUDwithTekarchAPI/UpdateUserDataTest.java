package com.test.simpleCRUDwithTekarchAPI;

import org.testng.annotations.Test;

import com.test.constants.EndPoints;
import com.test.models.UpdateUserPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UpdateUserDataTest {
	@Test
	public void updateUserPojo()
	{
		if(LoginToAPI.token1==null)
		{
			LoginToAPI.loginPojo();
		}
		UpdateUserPojo obj=new UpdateUserPojo();
		obj.setAccountno("TA-93333335");
		obj.setDepartmentno("3");
		obj.setSalary("00003");
		obj.setPincode("000003");
		obj.setUserid("taGX4XQQfXD3Z76sI1Xn");
		obj.setId("UQ4mAZflfHE3eWBjNhTH");
		Header header1=new Header("token",LoginToAPI.token1);
		Response res=RestAssured.given().
		contentType(ContentType.JSON).
		header(header1).
		body(obj).
		when().put(EndPoints.BASE_URI+EndPoints.UPDATE_DATA);
		String value=res.jsonPath().get("status");
		System.out.println(value);
		res.then().statusCode(200);
		System.out.println("End Of Update");
	}
}