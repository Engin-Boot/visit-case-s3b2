package visitcase.receiver.csvFootFallUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class mapsForFootFallData {
	public static Map<Integer,Map<Integer,Integer>> makeTreeMapOfDayHourCountForFootFallData(String st)
	{
		List<String> s=visitcase.receiver.csvFootFallUtils.footFallDataUtils.getstring(st);
		Map<Integer,Map<Integer,Integer>> treeMapOfDayHourCountForFootFallData=new TreeMap<Integer,Map<Integer,Integer>>();
	if(!s.isEmpty())
	{
		Map<Integer,Integer> treeMapOfHourCountForThatDay;
	int day,hour,count=0;
	for(String FootFallRecord:s)
	{
		System.out.println(FootFallRecord);
		day=visitcase.receiver.csvFootFallUtils.fieldExtractorFromValidFootFallRecord.getDayFromValidFootFallRecord(FootFallRecord);
		hour=visitcase.receiver.csvFootFallUtils.fieldExtractorFromValidFootFallRecord.getHourFromValidFootFallRecord(FootFallRecord);
		if(treeMapOfDayHourCountForFootFallData.containsKey(day)) {
			treeMapOfHourCountForThatDay=treeMapOfDayHourCountForFootFallData.get(day);
			if(!treeMapOfHourCountForThatDay.containsKey(hour))
				treeMapOfHourCountForThatDay.put(hour,1);
			else
				treeMapOfHourCountForThatDay.put(hour,treeMapOfHourCountForThatDay.get(hour)+1);
		}
		else
		{
			insertAPairIntoTreeMapOfDayHourCount(treeMapOfDayHourCountForFootFallData,day,hour,1);
				}
		}
	}
	return treeMapOfDayHourCountForFootFallData;
	}
	public static Map<Integer,Integer> makeMapOfHourCount(int i,int j)
	{
		Map<Integer,Integer> m=new TreeMap<Integer,Integer>();
		m.put(i,j);
		return m;
	}
	public static void insertAPairIntoTreeMapOfDayHourCount(Map<Integer,Map<Integer,Integer>> m,int day,int hour,int count)
	{
		Map<Integer,Integer> temp=makeMapOfHourCount(hour,count);
		m.put(day,temp);		
	}
}
