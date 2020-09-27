package visitcounter1.visitcounter1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SenderTest {
	@Test
	public void footfallDataFileIsEmptyOrNot()
	{
		FootfallCSVfileReader footfall= new FootfallCSVfileReader("E:\\JavaProjects\\emptySampleFile.csv");
		List<String[]> footfallData = new ArrayList<String[]>();
		footfallData =footfall.readCSVfile();
		assertTrue(footfallData.isEmpty()); 
	}
@Test
public void checkDateIsValidOrNot()
{
 DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
DateValidator validator = new DateValidator(dateFormatter);
        
assertTrue(validator.isValid("20190228"));
assertFalse(validator.isValid("20190230"));
}
@Test
public void fetchNoofRecords() {
	FootfallCSVfileReader footfall= new FootfallCSVfileReader("E:\\JavaProjects\\samplefile2.csv");
	List<String[]> footfallData = new ArrayList<String[]>();
	footfallData =footfall.readCSVfile();
	//System.out.println(footfallData.size());
	assertEquals(2,footfallData.size());
	
}
@Test
public void printFootfallDataonConsole() {
	FootfallDataConsoleWriter footfall=new FootfallDataConsoleWriter();
	footfall.consoleWriter();
}

}
