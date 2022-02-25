package com.test.simpleCRUDwithTekarchAPI;

import com.test.constants.EndPoints;
import com.test.models.LoginObjectPojo;
import com.test.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import pojos.LoginPojo;

public class LoginToAPI {
	static String token1;
	public static void loginPojo() 
	{
		LoginObjectPojo obj=new LoginObjectPojo();
		obj.setUsername(Utils.getApplicationProperty("username"));
		obj.setPassword(Utils.getApplicationProperty("password"));
		Response response=	RestAssured.
				given().
				contentType(ContentType.JSON).
				body(obj).
				when().post(EndPoints.BASE_URI+EndPoints.lOGIN);
		
			//response.prettyPrint();
			token1=response.jsonPath().get("[0].token");
			System.out.println("End Of Login");
	}
}