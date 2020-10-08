package visitcase.receiver;
import java.util.*;
import   visitcase.receiver.csvFootFallUtils.*;
public class csvAggregatesForFootFallData implements IAggregatesForFootFallData
{
	
	
	
	//@Override
	
	public String peakdailyfootfalls(String st)
	{
			Map<Integer,Map<Integer,Integer>> treeMapOfDayHourCount=mapsForFootFallData.makeTreeMapOfDayHourCountForFootFallData(st);
			int peakDailyFootFall=0;
			int temp;
			Set<Map.Entry<Integer,Map<Integer,Integer>>> s = treeMapOfDayHourCount.entrySet();
			
			for (Map.Entry<Integer,Map<Integer,Integer>> it: s)
			{
				temp=getTotalfootFallsInADay(it.getValue());
				if(temp>peakDailyFootFall) peakDailyFootFall=temp;
			}
			return String.valueOf(peakDailyFootFall);
	}
public String avghours(String st)
{
	Map<Integer,Map<Integer,Integer>> m=mapsForFootFallData.makeTreeMapOfDayHourCountForFootFallData(st);
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
	  return Arrays.toString(averageDailyFootFallInAWeek);
	 
	
}
public String getAverageFootFallPerHourInAMonth(String st)
{
	Map<Integer,Map<Integer,Integer>> m= mapsForFootFallData.makeTreeMapOfDayHourCountForFootFallData(st);
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
return Arrays.toString(averageFootFallPerHourInAMonth);}
public int getTotalfootFallsInADay(Map<Integer,Integer> mapOfHourCountForThatDay)
{
	int temp=0;
	Set<Map.Entry<Integer, Integer>> innerS=mapOfHourCountForThatDay.entrySet();
	for(Map.Entry<Integer, Integer> innerIterator:innerS)
	{
		temp=temp+innerIterator.getValue();
	}
	return temp;
}
}
