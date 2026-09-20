package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	WebElement addToCartbtn;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;
	
	@FindBy(className = "inventory_item_name")
	WebElement productName;
	
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart()
	{
		addToCartbtn.click();
	}
	
	public void openCart()
	{
		cartIcon.click();
	}
	
	public String getproductName()
	{
		return productName.getText();
		
	}

}
