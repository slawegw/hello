package kurs;

import java.util.*;
import java.text.DateFormat;

public class CheckSystemTime implements Runnable {
	
	public void run(){
		
		Date rightNow;
		Locale currentLocale;
		DateFormat timeFormatter;
		String timeOutput;
				
		timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, new Locale("en"));
		timeOutput = timeFormatter.format(new Date());
		
		System.out.println("Time: " + timeOutput);
		
	}
	
}

