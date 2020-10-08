package visitcase.receiver;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.nio.charset.Charset;

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
	public static int getDayFromValidFootFallRecord(String validFootFallRecord)
	{
		String[] validFootFallRecordAsArray=validFootFallRecord.split(",");
		//List<String> validFootFallRecordAsList=Arrays.asList(validFootFallRecordAsArray);
		String[] temp=validFootFallRecordAsArray[0].split("/");
		
			   int foo = Integer.parseInt(temp[2]);
			
		return foo;
		//return 0;
		}
	public static int getHourFromValidFootFallRecord(String validFootFallRecord)
	{
		String[] validFootFallRecordAsArray=validFootFallRecord.split(",");
		//List<String> validFootFallRecordAsList=Arrays.asList(validFootFallRecordAsArray);
		String[] temp=validFootFallRecordAsArray[1].split(":");
		
			   int foo = Integer.parseInt(temp[0]);
			
		return foo;
		//return 0;
		}
	public static Map<Integer,Map<Integer,Integer>> getMap(String st)
	{
		List<String> s=getstring(st);
		Map<Integer,Map<Integer,Integer>> mapOfFootFallData=new TreeMap<Integer,Map<Integer,Integer>>();
	if(!s.isEmpty())
	{
		Map<Integer,Integer> tempInnerMap;
	int day,hour,count=0;
	for(String FootFallRecord:s)
	{
		System.out.println(FootFallRecord);
		day=getDayFromValidFootFallRecord(FootFallRecord);
		hour=getHourFromValidFootFallRecord(FootFallRecord);
		if(mapOfFootFallData.containsKey(day)) {
			tempInnerMap=mapOfFootFallData.get(day);
			if(!tempInnerMap.containsKey(hour))
				tempInnerMap.put(hour,1);
			else
				tempInnerMap.put(hour,tempInnerMap.get(hour)+1);
		}
		else
		{
			tempInnerMap=new TreeMap<Integer,Integer>();
			tempInnerMap.put(hour,1);
			mapOfFootFallData.put(day, tempInnerMap);
				}
		}
	}
	return mapOfFootFallData;
	}
	public static int peakdailyfootfalls(String st)
	{
			Map<Integer,Map<Integer,Integer>> m=getMap(st);
			int peakDailyFootFall=0;
			int temp;
			Set<Map.Entry<Integer,Map<Integer,Integer>>> s = m.entrySet();
			Set<Map.Entry<Integer, Integer>> innerS;
			for (Map.Entry<Integer,Map<Integer,Integer>> it: s)
			{
				innerS=it.getValue().entrySet();
				temp=0;
				for(Map.Entry<Integer, Integer> innerIterator:innerS)
				{
					temp=temp+innerIterator.getValue();
				}
				if(temp>peakDailyFootFall) peakDailyFootFall=temp;
			}
			return peakDailyFootFall;
	}
	public static void avghours(String st)
	{
		Map<Integer,Map<Integer,Integer>> m=getMap(st);
		Map<Integer,Integer> dailyFootFallOverAMonth=new TreeMap<Integer,Integer>();
		  int temp;
		  Set<Map.Entry<Integer,Map<Integer,Integer>>> s = m.entrySet();
		  Set<Map.Entry<Integer, Integer>> innerS;
		  for (Map.Entry<Integer,Map<Integer,Integer>> it: s)
		  {
		    innerS=it.getValue().entrySet();
		    temp=0;
		    for(Map.Entry<Integer, Integer> innerIterator:innerS)
		    {
		      temp=temp+innerIterator.getValue();
		    }
		    dailyFootFallOverAMonth.put(it.getKey(),temp);
		    //if(temp>peakDailyFootFall) peakDailyFootFall=temp;
		  }
		  //System.out.println(dailyFootFallOverAMonth);
		  float averageDailyFootFallInAWeek[]= {0,0,0,0,0};
		  //System.out.println(averageDailyFootFallInAWeek);
		  innerS=dailyFootFallOverAMonth.entrySet();
		  for(Map.Entry<Integer, Integer> it:innerS)
		  {
			 // System.out.println(it.getKey()/7);
			  //System.out.println(it.getValue());
			  averageDailyFootFallInAWeek[it.getKey()/7]=averageDailyFootFallInAWeek[it.getKey()/7]+it.getValue();
		  }
		  for(int j=0;j<5;j++)
		  {
			  averageDailyFootFallInAWeek[j]=averageDailyFootFallInAWeek[j]/7;
		  }
		  System.out.println(Arrays.toString(averageDailyFootFallInAWeek));
		 
		
	}
	public static void getAverageFootFallPerHourInAMonth(String st)
	{
		Map<Integer,Map<Integer,Integer>> m= getMap(st);
		int temp;
		float[] averageFootFallPerHourInAMonth= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
	Set<Map.Entry<Integer,Map<Integer,Integer>>> s = m.entrySet();
	Set<Map.Entry<Integer, Integer>> innerS;
	for (Map.Entry<Integer,Map<Integer,Integer>> it: s)
	{
		for(temp=0;temp<24;temp++) 
		{
			//System.out.println(it.getValue().get(temp));
			if(it.getValue().get(temp)==null) {;}
			else
			{
				averageFootFallPerHourInAMonth[temp]=averageFootFallPerHourInAMonth[temp]+it.getValue().get(temp);
			}
			//if(System.out.println(it.getValue().get(temp)) != null) System.out.println(it.getValue().get(temp));
			//averageFootFallPerHourInAMonth[temp]=averageFootFallPerHourInAMonth[temp]+it.getValue().get(temp);}
	}

	}
	for(int i=0;i<24;i++)
	{
		averageFootFallPerHourInAMonth[i]=averageFootFallPerHourInAMonth[i]/30;
	}
	System.out.println(Arrays.toString(averageFootFallPerHourInAMonth));}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path=Paths.get("E:","Github-Repos","visit-case-s3b2","src","main","resources","receiver");
		//	String pwd=System.getProperty("user.dir");
		String s=path.toString();
		Path outputPath=Paths.get(s,"output-peakDailyFootFallInLastMonth.csv");
		System.out.println(outputPath);
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(outputPath, charset,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING,StandardOpenOption.WRITE)) {
		    writer.write(s, 0, s.length());
		} catch (IOException x) {
		    System.err.format("IOExceptiommn: %s%n", x);
		}
		}}


