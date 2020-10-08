package visitcase.receiver.csvFootFallUtils;

import java.util.ArrayList;
import java.util.List;

public class footFallDataUtils 
{
	public static List<String> getstring(String s)
	{
		List <String> temp=new ArrayList<String>();
		String temp_array[]=splitFootFallDataString(s);
				String temp_temp[];
		for(String arr:temp_array)
		{
			temp_temp=arr.split(",");
			if((temp_temp.length==2)&&footFallRecordValidator.validateFootFallRecord(temp_temp[0],temp_temp[1]))
			{
				
				temp.add(arr);
			}
		}
		return temp;
	}
	public static String[] splitFootFallDataString(String s)
	{
		return s.split("\\s+");
	}
}
