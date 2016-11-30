package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFunctions {
	
	public static String getTimeScreenShot(){
		
		return new SimpleDateFormat("HH_mm_ss").format(new Date().getTime());				
		 
	}

}
