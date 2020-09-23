package com.philips.footfallVisitCounter.sender;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 
public class FootfallTimpstampsCSVReader {
	
	
	public List<String> readFootfallDataFromCSVFile()
	{  
	String line = " "; 
	List<String> footfallData = new ArrayList<String>();
	
	try   
	{  
	  
	BufferedReader br = new BufferedReader(new FileReader("footfallData.csv"));  
	while ((line = br.readLine()) != null)    
	{  
	footfallData.add(line);
			
	}  
	}   
	catch (IOException e)   
	{  
	e.printStackTrace();  
	}  
	return footfallData;
	}  

}
