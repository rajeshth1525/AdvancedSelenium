package TestNgAttribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class EnabledTest {
	
	
	//This test will run because default enabled = true
	@Test
	public void a11()
	{
		Reporter.log("a11 done", true);
	}
	
	//This test will be skipped because enabled = false
	
	@Test(enabled = false)
	public void a32()
	{
		Reporter.log("a32 done", true);
	}
	
	
	
	//This test will also run because enabled is not written,
    // but by default it is true
	@Test
	public void a12()
	{
		Reporter.log("a12 done", true);
	}

}
