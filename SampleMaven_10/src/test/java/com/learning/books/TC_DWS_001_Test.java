
package com.learning.books;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import GenericUtility.ListenersUtility;
import ObjectRepository.HomePage;

@Listeners(ListenersUtility.class)
public class TC_DWS_001_Test extends BaseClass{
	
	@Test
	public void clickOnBooks() {
		hp= new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Book", "BooksPage is not displayed");
		test.log(Status.PASS, "Books Page is displayed");
		
	}

}
