package sender;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.*;
import java.util.*;
public class csvUtilitiesForFootFallData implements IUtilitiesForFootFallData {
	@Override
	public List<String> getAllFootFallRecordsAsAListOfStrings(Path pathToFootFallDataFile) throws IOException{
		try
		{
			return Files.readAllLines(pathToFootFallDataFile);
		}
		catch(IOException e)
		{
			List<String> emptyList=Collections.<String>emptyList();
			return emptyList;
		}
	}
	@Override
	public void writeFootFallDataToConsoleAsAString(Path pathToFootFallDataFile) throws IOException
	{
		try {
		List<String> allFootFallRecords=getAllFootFallRecordsAsAListOfStrings(pathToFootFallDataFile);
		System.out.println(allFootFallRecords);
		String S="";
		for(String FootFallRecord:allFootFallRecords)
		{
			S=S+FootFallRecord+'\n';
			//System.out.println(FootFallRecord);
		}
		System.out.print(S);
		
		}
		catch(IOException e)
		{
			System.out.println("IOException");
		}
	}

}
