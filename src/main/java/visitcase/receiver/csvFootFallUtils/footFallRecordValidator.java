package visitcase.receiver.csvFootFallUtils;
import java.util.*;
public class footFallRecordValidator {
	public static boolean validateMonth(int month)
	{return 1<=month&&month<=12;}
	public static boolean validateYear(int year)
	{return year>=0;}
	public static boolean validateDate(int date)
	{
		return 1<=date&&date<=31;
	}
	public static boolean validateHours(int hrs)
	{return 0<=hrs&&hrs<24;}
	public static boolean validateMinutes(int mts)
	{return 0<=mts&&mts<=59;}
	public static boolean validateSeconds(int sec)
	{return 0<=sec&&sec<60;}
	public static boolean validateDate(String s) throws NumberFormatException
	{
		String temp[]=s.split("/");
		
						if(temp.length==3) 
						{
							try{int temp_year=Integer.parseInt(temp[0]);
							int temp_month=Integer.parseInt(temp[1]);
							int temp_date=Integer.parseInt(temp[2]);
							return (validateMonth(temp_month))&&validateDate(temp_date);
							} catch(NumberFormatException e) {return false;}
							
						}
						else
							return false;
					
				}
	
	public static boolean validateTime(String s) throws NumberFormatException
	{
		String temp[]=s.split(":");
		//System.out.println(temp.length);
			if(temp.length==3) 
			{
				try{int temp_hours=Integer.parseInt(temp[0]);
				int temp_minutes=Integer.parseInt(temp[1]);
				int temp_seconds=Integer.parseInt(temp[2]);
				return (validateHours(temp_hours))&&(validateMinutes(temp_minutes))&&(validateSeconds(temp_seconds));
				} catch(NumberFormatException e) {return false;}
				
			}
			else
				return false;
	}
	
	public static boolean validateFootFallRecord(String date,String time)
	{return validateDate(date)&&validateTime(time);}
}
