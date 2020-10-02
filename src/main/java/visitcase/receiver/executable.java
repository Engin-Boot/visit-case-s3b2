package visitcase.receiver;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader; 
public class executable {

	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s=reader.readLine();
		System.out.println(s);
		HLM hlm=new HLM();
		hlm.setV(new csv());
		String listofrecords=hlm.getstring();
	Map <> m=	hlm.getmap(listofrecords);
	hlm.avgdailyfootfalls();
	hlm.avhhourlyfootfalls();
	hlm.peakfootfalls();
	}
		
	}


