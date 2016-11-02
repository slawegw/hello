import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;


public class Main 
{
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		String test;
		String[] test2 = new String[100];
		String[] por = {"cos", "tam"};
		
		Scanner in = new Scanner(Paths.get("test.txt"));

		while(in.hasNextLine()) {
		test = in.nextLine();
		
		
		StringTokenizer st = new StringTokenizer(test);
		System.out.println("Liczba tokenow: " + st.countTokens()); 
		
		int i = 0;		
		while(st.hasMoreTokens()){
			
			test2[i] = st.nextToken();
			if (test2[i].equals(por[0])){
				test2[i] = por[0] + " (dupa)";
			}
			
			System.out.print(test2[i] + " ");
			i++;
		}
		System.out.println();
		
		}
		
	}

}
