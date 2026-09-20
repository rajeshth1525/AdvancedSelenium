package TakeScreeShots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotDemo {
	public static void main(String[] args) throws IOException {
		//Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		//Casting driver to TakesScreenshot
		TakesScreenshot ts= (TakesScreenshot)driver;
		// Capture Screenshot (temporary file)
		File src = ts.getScreenshotAs(OutputType.FILE);
		// Save Screenshot (permanent location)
		File dest= new File("./ScreenShots/Homepage.png");
		//
		// Copy screenshot from temp file to destination
		FileHandler.copy(src, dest);
		driver.quit();
		System.out.println("Screenshot Capture Successfully");
		
	
	}

}
