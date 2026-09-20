package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	//Random number (unique run ID साठी)
	public int getrandomNumber()
	{
		Random r= new Random();
		return r.nextInt(1000);	
	}
	
	// System date (logs/report साठी)
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	
	
	// Formatted date (login logs neat format साठी)
	public String getFormatDate()
	{
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	
	}
	
	// Unique string तयार करणे (Order_123, User_456)
	public String getuniqueString(String base)
	{
		int randomNum = getrandomNumber();
		return base +"_"+ randomNum;
	}
	
	

}
