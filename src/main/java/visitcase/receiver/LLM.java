package visitcase.receiver;
import java.util.*;
public class LLM implements ILLM
{
	public  boolean validateDate(String s) throws NumberFormatException
	{
		String temp[]=s.split("/");
		//System.out.println(temp.length);
			if(temp.length==3) 
			{
				try{int temp_year=Integer.parseInt(temp[0]);
				int temp_month=Integer.parseInt(temp[1]);
				int temp_date=Integer.parseInt(temp[2]);
				return (temp_year>=0)&&(1<=temp_month&&temp_month<=12)&&(1<=temp_date&&temp_date<=31);
				} catch(NumberFormatException e) {return false;}
				
			}
			else
				return false;
		
	}
	
	public boolean validateTime(String s) throws NumberFormatException
	{
		String temp[]=s.split(":");
		//System.out.println(temp.length);
			if(temp.length==3) 
			{
				try{int temp_hours=Integer.parseInt(temp[0]);
				int temp_minutes=Integer.parseInt(temp[1]);
				int temp_seconds=Integer.parseInt(temp[2]);
				return (temp_hours>=0&&temp_hours<=23)&&(0<=temp_minutes&&temp_minutes<=60)&&(0<=temp_seconds&&temp_seconds<=60);
				} catch(NumberFormatException e) {return false;}
				
			}
			else
				return false;
	}
	public List<String> getstring(String s)
	{
		List <String> temp=new ArrayList<String>();
		String temp_array[]=s.split("\\s+");
		String temp_temp[];
		for(String arr:temp_array)
		{
			temp_temp=arr.split(",");
			if((temp_temp.length==2)&&validateDate(temp_temp[0])&&validateTime(temp_temp[1]))
			{
				
				temp.add(arr);
			}
		}
		return temp;
	}
	
}
