package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errormsg;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void login(String UN,String PW)
	{
		username.sendKeys(UN);
		password.sendKeys(PW);
		loginbtn.click();
	}
	
	public String errormessage()
	{
		return errormsg.getText();
		
	}

}
