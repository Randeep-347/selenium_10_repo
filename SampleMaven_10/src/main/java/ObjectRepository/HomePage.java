package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText="Log out")
	private WebElement logoutLink;
	
	@FindBy(linkText="BOOKS")
	private WebElement booksLink;
	
	@FindBy(linkText="COMPUTERS")
	private WebElement computersLink;
	
	@FindBy(linkText="ELECTRONICS")
	private WebElement electronicsLink;
	
	@FindBy(xpath="//a[text()='14.1-inch Laptop']/../..//input[@value='Add to cart']")
	private WebElement addToCartButton;
	
	@FindBy(id="topcartlink")
	private WebElement shoppingCartLink;
	
	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	
}
