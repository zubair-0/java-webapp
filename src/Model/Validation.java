package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

	public static boolean checkMail(String email)
	{	
		if(isEmpty(email))
		{
			System.out.println("empty email address"); 
			return false;
		}
		
		int atpos=email.indexOf("@");
		int dotpos=email.lastIndexOf(".");
		int dualAtPos=email.lastIndexOf("@");
		
		if(atpos!=dualAtPos)
		{
			System.out.println("More then 1 email addresses detected");
			return false;
		}
		
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length()) {
			System.out.println("@ or .com error");
	        return false;
	    }
		
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		
		if(!email.matches(EMAIL_REGEX))
		{
			System.out.println("special character found");
			return false;
		}
		
		System.out.println("valid email");
		return true;
	}
	
	public static boolean isEmpty(String x)
	{
		if(x.length()==0)
		{
			System.out.println("empty email address"); 
			return true;
		}
		return false;
	}
}
