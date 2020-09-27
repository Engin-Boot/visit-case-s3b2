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
public class senderExecutable {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
		String file=args[0];
		//String pwd=System.getProperty("user.dir");
		//System.out.println(pwd);
		Path p=Paths.get("E:","Github-Repos","visit-case-s3b2","src","main","resources",file);
		IUtilitiesForFootFallData v=new csvUtilitiesForFootFallData();
		v.writeFootFallDataToConsoleAsAString(p);
		}
		catch(IOException e)
		{
			System.out.println("error");
		}
	}

}
