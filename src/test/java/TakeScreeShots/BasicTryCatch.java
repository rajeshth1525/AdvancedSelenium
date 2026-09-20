package TakeScreeShots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class BasicTryCatch {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		
		try {
			// Intentionally wrong inspect to get error
			driver.findElement(By.id("WrongElement")).click();
			System.out.println("Test Case pass Screenshot not needed");
			
		} catch (Exception e) {
			System.out.println("Test Failed screenshot captured succesfully");
			try {
				TakesScreenshot ts= (TakesScreenshot)driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest= new File("./ScreenShots/WrongElement.png");
				FileHandler.copy(src, dest);
				//To getting full path where screenshot has been saved
				System.out.println("Screenshot Save at:"+dest.getAbsolutePath());
				
			} catch (IOException io) {
				//its showing the reason of the error(like No such file or directory)
				System.out.println("Failed to save screenshot:"+io.getMessage());
			}
			
		}
		//Always excecuted ->Cleanup
		finally {
			driver.quit();
			System.out.println("Browser safely close");
		}

		
	}

}
