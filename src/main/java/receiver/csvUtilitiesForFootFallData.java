package receiver;
import java.lang.*;
import java.util.*;
public class csvUtilitiesForFootFallData {
private List<String> FootFallData;
public void setFootFallData(List<String> FootFallData)
{
	this.FootFallData=FootFallData;
	}
public static Map<Integer,Map<Integer,Integer>>getTreeMapOfFootFallData(List<String> FootFallData)
{
	Map<Integer,Map<Integer,Integer>> mapOfFootFallData=new TreeMap<Integer,Map<Integer,Integer>>();
	Map<Integer,Integer> tempInnerMap;
	int day,hour,count=0;
	for(String FootFallRecord:FootFallData)
	{
		day=csvUtilitiesForFootFallRecord.getDayFromFootFallRecord(FootFallRecord);
		hour=csvUtilitiesForFootFallRecord.getHourFromFootFallRecord(FootFallRecord);
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
	return mapOfFootFallData;
	}
public static void main(String args[])
{
	List <String> FootFallData=new ArrayList <String>();
	FootFallData.add("2020-09-18,12:30:35");
	FootFallData.add("2020-09-17,12:30:35");
	FootFallData.add("2020-09-17,12:30:38");
	FootFallData.add("2020-09-17,13:30:35");
	
	FootFallData.add("2020-09-18,12:30:35");
	System.out.println(csvUtilitiesForFootFallData.getTreeMapOfFootFallData(FootFallData));
}
}
