package visitcounter1.visitcounter1;

import java.util.ArrayList;
import java.util.List;

public class FootfallDataConsoleWriter {
	public void consoleWriter() {
	FootfallCSVfileReader footfall= new FootfallCSVfileReader("E:\\JavaProjects\\inputfile.csv");
	List<String[]> footfallData = new ArrayList<String[]>();
	footfallData =footfall.readCSVfile();
	System.out.println("Date         Time");
	for (String[] data : footfallData) {
	    System.out.println(data[0]+"   "+data[1]);
	}
	
	
	}
	

}
