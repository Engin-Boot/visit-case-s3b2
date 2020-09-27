package receiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class aggregateUtiltiesForFootFallData {
public static void getpeakDailyFootFall(Map<Integer,Map<Integer,Integer>> mapOfFootFallData)
{
	int peakDailyFootFall=0;
	int temp;
	Set<Map.Entry<Integer,Map<Integer,Integer>>> s = mapOfFootFallData.entrySet();
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
	System.out.println(peakDailyFootFall);
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
	aggregateUtiltiesForFootFallData.getpeakDailyFootFall(csvUtilitiesForFootFallData.getTreeMapOfFootFallData(FootFallData));
	//aggregateUtiltiesForFootFallData.getAverageDailyFootFallInAWeek(csvUtilitiesForFootFallData.getTreeMapOfFootFallData(FootFallData));
}
}
