import java.util.*;
import java.lang.RuntimeException;
import java.lang.Exception;
import java.io.*;

public class pascala {
	
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		getAFile("teast.txt");
				
	}
	
	public static void getAFile(String fileName){
		try
		{
			FileInputStream file = new FileInputStream(fileName);
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Sorry can't find that file");
		}
		
	}

	
}
