package com.learning.computers;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import GenericUtility.ListenersUtility;
import ObjectRepository.HomePage;


@Listeners(ListenersUtility.class)
public class TC_DWS_010_Test extends BaseClass{
	
	@Test
	public void clickOnComputers() {
		test.log(Status.INFO, "User Logged in Successfully");
		hp= new HomePage(driver);
		hp.getComputersLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers","Computers page is not displayed");
		test.log(Status.PASS, "Computers page is displayed");
	}

}
