package com.philips.footfallVisitCounter.sender;

import java.util.ArrayList;
import java.util.List;

public class Sender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FootfallTimpstampsCSVReader reader =new FootfallTimpstampsCSVReader();
		List<String> footfalltimestamps=new ArrayList<String>();
		footfalltimestamps=reader.readFootfallDataFromCSVFile();
		for( String str :footfalltimestamps)
			System.out.println(str);

	}

}
