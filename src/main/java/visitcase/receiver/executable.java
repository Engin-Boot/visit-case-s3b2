package visitcase.receiver;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption; 
public class executable {

	public static void main(String[] args) throws IOException{
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//String s=reader.readLine();
		//System.out.println(s);
		HLM hlm=new HLM();
		hlm.setLLM(new LLM());
		String st="2020/01/24,10:50:45\r\n"
				+ "2020/01/24,11:30:50\r\n"
				+ "2020/01/24,14:05:18\r\n"
				+ "2020/01/25,22:19:59\r\n"
				+ "2020/01/25,05:10:30\r\n"
				+ "2020/01/25,06:10:39\r\n"
				+ "2020/01/2506:10:45";
		String s=hlm.peakhourly(st);
		String s1=hlm.avghours(st);
	String s2=hlm.getAverageFootFallPerHourInAMonth(st);
	//System.out.println();
	//System.out.println(s1);
	//System.out.println(s2);
	Path path=Paths.get("E:","Github-Repos","visit-case-s3b2","src","main","resources","receiver");
	//	String pwd=System.getProperty("user.dir");
	
	Path outputPath=Paths.get(path.toString(),"output-peakDailyFootFallInLastMonth.csv");
	Path outputPath1=Paths.get(path.toString(),"output-avgFootFallsPerWeekInLastMonth.csv");
	Path outputPath2=Paths.get(path.toString(),"output-avgHourlyFootFallOverLastMonth.csv");
	//System.out.println(outputPath);
	Charset charset = Charset.forName("UTF-8");
	try  {
		BufferedWriter writer = Files.newBufferedWriter(outputPath, charset,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING,StandardOpenOption.WRITE);
		writer.write(s, 0, s.length());
	    writer.close();
	    writer = Files.newBufferedWriter(outputPath2, charset,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING,StandardOpenOption.WRITE);
	    writer.write(s2, 0, s2.length());
	    writer.close();
	    writer = Files.newBufferedWriter(outputPath1, charset,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING,StandardOpenOption.WRITE);
	    writer.write(s1, 0, s1.length());
	    writer.close();
	    
	} catch (IOException x) {
	    System.err.format("IOExceptiommn: %s%n", x);
	}
	}
		
	}


