package com.test.simpleCRUDwithTekarchAPI;

import org.testng.annotations.Test;

import com.test.constants.EndPoints;
import com.test.models.DeleteUserPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class DeleteUserDataTest {
	@Test
	public void deleteUserPojo()
	{
		if(LoginToAPI.token1==null)
		{
			LoginToAPI.loginPojo();
		}
		DeleteUserPojo obj=new DeleteUserPojo();
		obj.setId("UQ4mAZflfHE3eWBjNhTH");
		obj.setUserid("taGX4XQQfXD3Z76sI1Xn");
		Header header1=new Header("token",LoginToAPI.token1);
		Response res=RestAssured.given().
		contentType(ContentType.JSON).
		header(header1).
		body(obj).
		when().delete(EndPoints.BASE_URI+EndPoints.DELETE_DATA);
		String val=res.jsonPath().get("status");
		System.out.println("deletion success msg="+val);
		res.then().statusCode(200);
		System.out.println("End of Delete");
	}
}