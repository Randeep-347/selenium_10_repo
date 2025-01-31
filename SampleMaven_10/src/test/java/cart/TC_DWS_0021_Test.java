package cart;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import GenericUtility.ListenersUtility;
import ObjectRepository.HomePage;

@Listeners(ListenersUtility.class)
public class TC_DWS_0021_Test extends BaseClass{
	
	@Test
	public void addToCart() throws IOException {
		hp= new HomePage(driver);
		hp.getAddToCartButton().click();
		
		hp.getShoppingCartLink().click();
		String prodName = fUtil.getDataFromProperty("productName");
		Assert.assertEquals(prodName,"14.1-inch Laptop","Product has not been added to Cart");
		test.log(Status.PASS, "Item added in cart");
	}

}
