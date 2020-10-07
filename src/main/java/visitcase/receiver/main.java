package visitcase.receiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
	public static boolean validateDate(String s) throws NumberFormatException
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
	public static boolean validateTime(String s) throws NumberFormatException
	{
		String temp[]=s.split(":");
		System.out.println(temp.length);
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
	public static List<String> getstring(String s)
	{
		List <String> temp=new ArrayList<String>();
		String temp_array[]=s.split("\\s+");
		String temp_temp[];
		for(String arr:temp_array)
		{
			//System.out.println(arr);
			//temp.add(arr);
			//System.out.println(temp);
			temp_temp=arr.split(",");
			if((temp_temp.length==2)&&validateDate(temp_temp[0])&&validateTime(temp_temp[1]))
			{
				//System.out.println(temp_temp[0]);
				//System.out.println(temp_temp[1]);
				temp.add(arr);
				
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		String s="24:0:0";
		List<String> temp=getstring("2020/01/24,10:50:45\r\n"
				+ "2020/01/24,11:30:50\r\n"
				+ "2020/01/24,14:05:18\r\n"
				+ "2020/01/25,:19:59\r\n"
				+ "2020/-5/25,05:10:30\r\n"
				+ ",06:10:39\r\n"
				+ "06:10:45");
		System.out.println(temp);
		
	}

}
