package visitcounter1.visitcounter1.reciever;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import visitcounter1.visitcounter1.FootfallCSVfileReader;

public class WeeklyAvg {
	public List<String[]> readData() throws IOException { 
	    int count = 0;
	    String file = "E:\\JavaProjects\\inputfile.csv";
	    List<String[]> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(" "));
	        }
	    } catch (FileNotFoundException e) {
	      //Some error logging
	    }
	    return content;
	}
	
	public void week() throws IOException
	{
//	FootfallCSVfileReader footfall= new FootfallCSVfileReader("E:\\JavaProjects\\inputfile.csv");
	
	List<String[]> footfallData =readData();
	
//	footfallData =footfall.readCSVfile();
	
	for (String[] strings : footfallData) {
	    System.out.println(strings);
	}
}
}
