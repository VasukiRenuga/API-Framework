package com.test.simpleCRUDwithTekarchAPI;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.test.constants.EndPoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GetUserDataTest {
	//LoginToAPI log=new LoginToAPI();
	@Test
	public static void getAllUsers()
	{
		if(LoginToAPI.token1==null)
		{
			LoginToAPI.loginPojo();
		}
		
		Header header1=new Header("token",LoginToAPI.token1);
		Response response=	RestAssured.
				given().
				header(header1).
				when().get(EndPoints.BASE_URI+EndPoints.GET_DATA);
		
			System.out.println(response.getBody().asPrettyString());
				System.out.println("First acc.no-"+response.jsonPath().get("[0].accountno"));
				response.then().assertThat().statusCode(200);
				//response.then().assertThat().time(Matchers.lessThan(3000L));
				response.then().assertThat().contentType(ContentType.JSON);
				System.out.println(response.jsonPath().get("$.size()"));
				System.out.println("End of GetUser");
	}
}