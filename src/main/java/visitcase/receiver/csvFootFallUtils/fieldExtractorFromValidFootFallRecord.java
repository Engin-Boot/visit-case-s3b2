package visitcase.receiver.csvFootFallUtils;

public class fieldExtractorFromValidFootFallRecord {
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
}
