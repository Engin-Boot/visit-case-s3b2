package receiver;
import java.util.*;
public class csvUtilitiesForFootFallRecord {
public static int getDayFromFootFallRecord(String validFootFallRecord)
{
	String[] validFootFallRecordAsArray=validFootFallRecord.split(",");
	//List<String> validFootFallRecordAsList=Arrays.asList(validFootFallRecordAsArray);
	String[] temp=validFootFallRecordAsArray[0].split("/");
	
		   int foo = Integer.parseInt(temp[2]);
		
	return foo;
	//return 0;
	}
public static int getHourFromFootFallRecord(String validFootFallRecord)
{
	String[] validFootFallRecordAsArray=validFootFallRecord.split(",");
	//List<String> validFootFallRecordAsList=Arrays.asList(validFootFallRecordAsArray);
	String[] temp=validFootFallRecordAsArray[1].split(":");
	
		   int foo = Integer.parseInt(temp[0]);
		
	return foo;
	//return 0;
	}
public static boolean validateFootFallRecord(String FootFallRecord)
{
	String[] temp=FootFallRecord.split(",");
	if (temp.length==2) return validateDateOfFootFallRecord(temp[0])&&validTimeOfFootFallRecord(temp[1]);
	else return false;}
public static boolean validateDateOfFootFallRecord(String Date)
{
	return true;
}
public static boolean validTimeOfFootFallRecord(String Time)
{
return true;	
}
public static void main(String args[])
{
	System.out.println(getHourFromFootFallRecord("2020-09-17,12:30:35"));
}

}
