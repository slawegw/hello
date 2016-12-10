package Subtitles;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadDatabaseFileToArray extends ReadFileToArray {

	private int tempIsKnown = 0;
	private BufferedReader bfr;
	
	/**
	 * Add defined words from file
	 * @param fileName Name to file with words database
	 * @return Database with english and polish words readed from file
	 */
	public ArrayList<DatabaseRegister> ReadDatabaseFileToArray(String fileName) {

		openTextFile(fileName);

		try {
			while ((tempLine = bfr.readLine()) != null) {
				
				lineSeparated = tempLine.split(";");
				
				try {
					tempIsKnown =  Integer.parseInt(lineSeparated[2]);
				}
				catch (ArrayIndexOutOfBoundsException e){
					tempIsKnown = 0;
				}
//				if(regexChecker("[0-9]",lineSeparated[2])) {
//					tempIsKnown =  Integer.parseInt(lineSeparated[2]);
//				}
//				else {
//					tempIsKnown = 0;
//				}

				tempWordsList.add(new DatabaseRegister(lineSeparated[0], lineSeparated[1],tempIsKnown));
			}
		} catch (IOException e) {
			System.out.println("Blad odczytu");
		}
		
		closeTextFile();
		return tempWordsList;
	}
}
