package com.philips.footfallVisitCounter.reciever;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AggregateFunctions {
public  HashMap<Date,Float> averageFootfallperHourOveraDay(List<String> footfallTimstamp ) {
		

        HashMap<Date, Float> averagefootfallperHour = new HashMap<>();
       
        ConvertStringintoTimestamp timestamp=new ConvertStringintoTimestamp();
       
        Date date=new Date();
        for (String str : footfallTimstamp) 
        {
        	date=timestamp.convertStringIntoTimestamp(str);
        if( averagefootfallperHour.containsKey(date))
        {
        averagefootfallperHour.put(date,averagefootfallperHour.get(date)+1);
        }
        else
        {
        	 averagefootfallperHour.put(date,1.0f);
        }
        }
        for (Map.Entry<Date, Float> e : averagefootfallperHour.entrySet()) 
        	averagefootfallperHour.put(e.getKey(), e.getValue()/24.0f);
            
        return averagefootfallperHour;
	}
	public HashMap<String,Float> averageDailyfootfallsperWeek(HashMap<Date,Float> footfallTimestamp)
	{
	 	
	}
	public float PeakDailyfootfallinTheMonth( HashMap<Date,Float> footfalls,int month)
	{
		Float peakvalue=0.0f;
		HashMap<Integer,Float> PeakDailyFootfallinGivenMonths=new HashMap<>;
		
		for (Map.Entry<Date, Float> e : footfalls.entrySet()) 
		{
        	int getmonth =e.getKey().getMonth();
		if(month==getmonth)
		{
			 if( Peakvalue < e.getValue())
		        {
		        
		}
		}
		
	}

}
