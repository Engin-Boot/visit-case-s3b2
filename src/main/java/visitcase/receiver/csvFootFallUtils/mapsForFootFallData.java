package visitcase.receiver.csvFootFallUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class mapsForFootFallData {
	public static Map<Integer,Map<Integer,Integer>> makeTreeMap(String st)
	{
		List<String> s=visitcase.receiver.csvFootFallUtils.footFallDataUtils.getstring(st);
		Map<Integer,Map<Integer,Integer>> mapOfFootFallData=new TreeMap<Integer,Map<Integer,Integer>>();
	if(!s.isEmpty())
	{
		Map<Integer,Integer> tempInnerMap;
	int day,hour,count=0;
	for(String FootFallRecord:s)
	{
		System.out.println(FootFallRecord);
		day=visitcase.receiver.csvFootFallUtils.fieldExtractorFromValidFootFallRecord.getDayFromValidFootFallRecord(FootFallRecord);
		hour=visitcase.receiver.csvFootFallUtils.fieldExtractorFromValidFootFallRecord.getHourFromValidFootFallRecord(FootFallRecord);
		if(mapOfFootFallData.containsKey(day)) {
			tempInnerMap=mapOfFootFallData.get(day);
			if(!tempInnerMap.containsKey(hour))
				tempInnerMap.put(hour,1);
			else
				tempInnerMap.put(hour,tempInnerMap.get(hour)+1);
		}
		else
		{
			tempInnerMap=makeMapOfHourAndCount(hour,1);
			
			mapOfFootFallData.put(day, tempInnerMap);
				}
		}
	}
	return mapOfFootFallData;
	}
	public static Map<Integer,Integer> makeMapOfHourAndCount(int i,int j)
	{
		Map<Integer,Integer> m=new TreeMap<Integer,Integer>();
		m.put(i,j);
		return m;
	}
}
