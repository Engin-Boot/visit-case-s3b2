package visitcounter1.visitcounter1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FootfallCSVfileReader {
	private String filepath;
	public  FootfallCSVfileReader(String filepath)
	{
		this.filepath=filepath;
	}
	public List<String[]> readCSVfile(){
	String line = "";  
	String splitBy = ""; 
	List<String[]> footfallData = new ArrayList<String[]>();
	try   
	{  
		
	BufferedReader reader = new BufferedReader(new FileReader(filepath));  
	while ((line = reader.readLine()) != null)  
	{  
	String[] data = line.split(splitBy);  
	if(data.length>1) 
	{
		footfallData.add(data);
	}
	}
	}   
	catch (IOException e)   
	{  
	e.printStackTrace();
	}
	return footfallData;
	}
}
	


