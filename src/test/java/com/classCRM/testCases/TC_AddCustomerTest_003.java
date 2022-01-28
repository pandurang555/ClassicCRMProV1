package com.classCRM.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.classicCRM.pageObjects.AddCustomerPage;
import com.classicCRM.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		
		
		logger.info("providing customer details");
		
		addcust.custname("Surya");
		addcust.custgender("male");
		
		addcust.custdob("01","01","1990");
		
		Thread.sleep(3000);
		addcust.custaddress("ShantiKunj");
		addcust.custcity("Jaipur");
		addcust.custstate("Rajsthan");
		addcust.custpin("400120");
		addcust.custtelephoneno("9689555049");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custpassword("abcdef");
		
		addcust.custsubmit();
		Thread.sleep(10000);
		
		logger.info("----validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Case is Passed...");
		}
		else
		{
			logger.info("Test Case is Failed...");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
