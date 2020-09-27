package receiver;
import java.util.*;
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
public static void getAverageDailyFootFallInAWeek(Map<Integer,Map<Integer,Integer>> mapOfFootFallData)
{
  //int peakDailyFootFall=0;
  Map<Integer,Integer> dailyFootFallOverAMonth=new TreeMap<Integer,Integer>();
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
    dailyFootFallOverAMonth.put(it.getKey(),temp);
    //if(temp>peakDailyFootFall) peakDailyFootFall=temp;
  }
  System.out.println(dailyFootFallOverAMonth);
  float averageDailyFootFallInAWeek[]= {0,0,0,0,0};
  System.out.println(averageDailyFootFallInAWeek);
  innerS=dailyFootFallOverAMonth.entrySet();
  for(Map.Entry<Integer, Integer> it:innerS)
  {
	  System.out.println(it.getKey()/7);
	  System.out.println(it.getValue());
	  averageDailyFootFallInAWeek[it.getKey()/7]=averageDailyFootFallInAWeek[it.getKey()/7]+it.getValue();
  }
  for(int j=0;j<5;j++)
  {
	  averageDailyFootFallInAWeek[j]=averageDailyFootFallInAWeek[j]/7;
  }
  System.out.println(Arrays.toString(averageDailyFootFallInAWeek));
 
  //averageDailyFootFallInAWeek
  //System.out.println(peakDailyFootFall);
}
public static void getAverageFootFallPerHourInAMonth(Map<Integer,Map<Integer,Integer>> mapOfFootFallData)
{
	int temp;
	float[] averageFootFallPerHourInAMonth= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
Set<Map.Entry<Integer,Map<Integer,Integer>>> s = mapOfFootFallData.entrySet();
Set<Map.Entry<Integer, Integer>> innerS;
for (Map.Entry<Integer,Map<Integer,Integer>> it: s)
{
	for(temp=0;temp<24;temp++) 
	{
		//System.out.println(it.getValue().get(temp));
		if(it.getValue().get(temp)==null) {;}
		else
		{
			averageFootFallPerHourInAMonth[temp-1]=averageFootFallPerHourInAMonth[temp-1]+it.getValue().get(temp);
		}
		//if(System.out.println(it.getValue().get(temp)) != null) System.out.println(it.getValue().get(temp));
		//averageFootFallPerHourInAMonth[temp]=averageFootFallPerHourInAMonth[temp]+it.getValue().get(temp);}
}

}
System.out.println(Arrays.toString(averageFootFallPerHourInAMonth));
}
public static void main(String args[])
{
	List <String> FootFallData=new ArrayList <String>();
	FootFallData.add("2020-09-18,12:30:35");
	FootFallData.add("2020-09-17,12:30:35");
	FootFallData.add("2020-09-17,12:30:38");
	FootFallData.add("2020-09-17,13:30:35");
	
	FootFallData.add("2020-09-18,12:30:35");
	//System.out.println(csvUtilitiesForFootFallData.getTreeMapOfFootFallData(FootFallData));
	//aggregateUtiltiesForFootFallData.getpeakDailyFootFall(csvUtilitiesForFootFallData.getTreeMapOfFootFallData(FootFallData));
	//aggregateUtiltiesForFootFallData.getAverageDailyFootFallInAWeek(csvUtilitiesForFootFallData.getTreeMapOfFootFallData(FootFallData));
	aggregateUtiltiesForFootFallData.getAverageFootFallPerHourInAMonth(csvUtilitiesForFootFallData.getTreeMapOfFootFallData(FootFallData));
}
}
