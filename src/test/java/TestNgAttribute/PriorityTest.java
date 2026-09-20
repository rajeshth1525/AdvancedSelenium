package TestNgAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityTest {
	@Test(priority = -1)
	public void crickbuzz()
	{
		Reporter.log("CrickBuzz Excecuted", true);
	}
	
	@Test(priority = 0)
	public void amazon()
	{
		Reporter.log("Amazon Excecuted", true);
	}
	
	@Test(priority = 3)
	public void bigBasket()
	{
		Reporter.log("BigBasket Excecuted", true);
	}
	
	@Test(priority = 3)
	public void zepto()
	{
		Reporter.log("Zepto ExceCuted", true);
	}
	
	@Test(priority = -2)
	public void swiggy()
	{
		Reporter.log("Swiggy Excecuted", true);
	}
	
	@Test
	public void filipcart()
	{
		Reporter.log("FilpCart Excecuted", true);
	}
	

}
