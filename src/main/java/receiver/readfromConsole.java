package receiver;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
public class readfromConsole {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
		String s=reader.readLine();
		System.out.println(s+"kikikikki");
		//catch(IOException e) {System.out.println("error");}
		
	}
}
