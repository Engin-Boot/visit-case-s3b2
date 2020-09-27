package receiver;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class receiverExecutable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
		String footFallData=reader.readLine();
		List<String> footFallDataAsList=new ArrayList<String>();
		String[] temp=footFallData.split("\\s+");
		for(int i=0;i<temp.length;i++)
		{
			footFallDataAsList.add(temp[i]);
		}
		//System.out.println(footFallDataAsList);
		Map<Integer,Map<Integer,Integer>> footFallDataParametersAsMap=csvUtilitiesForFootFallData.getTreeMapOfFootFallData(footFallDataAsList);
		aggregateUtiltiesForFootFallData.getpeakDailyFootFall(footFallDataParametersAsMap);
		aggregateUtiltiesForFootFallData.getAverageDailyFootFallInAWeek(footFallDataParametersAsMap);
		aggregateUtiltiesForFootFallData.getAverageFootFallPerHourInAMonth(footFallDataParametersAsMap);
	}

}
