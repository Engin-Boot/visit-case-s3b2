package com.philips.footfallVisitCounter.reciever;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.philips.footfallVisitCounter.sender.footFallTimeStampCSVReader;

public class Reciever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		footFallTimeStampCSVReader reader =new footFallTimeStampCSVReader();
		AggregateFunctions aggregate=new AggregateFunctions();
		List<String> footfalltimestamps=new ArrayList<String>();
		footfalltimestamps=reader.readFootfallDataFromCSVFile();
		HashMap<Date, Float> averagefootfallperHour = new HashMap<>();
		averagefootfallperHour=aggregate.averageFootfallperHourOveraDay(footfalltimestamps); 
		System.out.println("Date   "+"Average Footfall per hour in a day");
		 for (Map.Entry<Date, Float> e : averagefootfallperHour.entrySet()) 
	        	System.out.println(e.getKey()+"   "+ e.getValue());
		
	}

}
© 2020 GitHub, Inc.
