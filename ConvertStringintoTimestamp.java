package com.philips.footfallVisitCounter.reciever;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;  

public class ConvertStringintoTimestamp {
	public Date convertStringIntoTimestamp(String footfallData)
	{
		Date date=null;
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy"); 
		try {
			
			 date=formatter.parse(footfallData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}

}
