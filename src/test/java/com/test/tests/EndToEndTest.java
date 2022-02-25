package com.test.tests;

import org.testng.annotations.Test;

import com.test.simpleCRUDwithTekarchAPI.*;

public class EndToEndTest {
	AddUserDataTest add=new AddUserDataTest();
	DeleteUserDataTest delete=new DeleteUserDataTest();
	GetUserDataTest get=new GetUserDataTest();
	LoginToAPI login=new LoginToAPI();
	UpdateUserDataTest update=new UpdateUserDataTest();
	@Test
	public void endToEnd() 
	{
		login.loginPojo();
		//add.addUserPojo();
		//get.getAllUsers();
		//update.updateUserPojo();
		//delete.deleteUserPojo();
		
		
	}

}

