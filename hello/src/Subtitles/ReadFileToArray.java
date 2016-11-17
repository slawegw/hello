package Subtitles;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class ReadFileToArray {

	private FileReader readFile = null;
	private String linia = " ";
	ArrayList<String> lista = new ArrayList<String>(); // glowna lista
	private BufferedReader bfr;
	
	DatabaseRegister tempDatabaseFromFile;
	ArrayList<DatabaseRegister> tempWordsList = new ArrayList<DatabaseRegister>();
	
	String tempLine = "";
	String[] lineSeparated = new String[3];
	private int tempIsKnown = 0;
	ArrayList<DatabaseRegister> dictWordsList = new ArrayList<DatabaseRegister>(); // Lista slownika

	// Otwieranie pliku
	public BufferedReader openTextFile(String fileName) {
		try {
			readFile = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		bfr = new BufferedReader(readFile);

		return bfr;
	}

	// zamykanie pliku
	public void closeTextFile() {
		try {
			bfr.close();
		} catch (IOException e) {
			System.out.println("Blad zamykania pliku");
		}
	}
	
	/**
	 * 
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

	
	// Wczytywanie pliku
	public void loadFileToArray() {

		this.openTextFile("the.big.bang.theory.txt");

		try {
			while ((linia = bfr.readLine()) != null) {

				lista.add(linia);
			}
		} catch (IOException e) {
			System.out.println("Blad odczytu");
		}
		
		closeTextFile();
	}

	// Print
	public void printLineFromArray(int i) {
		System.out.println(lista.get(i));
	}

	// Get specific line
	public String getLineFromArray(int i) {
		return lista.get(i);
	}

	public int getLength() {
		return lista.size();
	}
	
	public static boolean regexChecker(String theRegex, String str2Check){
		boolean state = false;
		Pattern checkRegex = Pattern.compile(theRegex);
		
		Matcher regexMatcher = checkRegex.matcher(str2Check);
		
		while(regexMatcher.find()){
			if(regexMatcher.group().length() != 0){
				//System.out.println(regexMatcher.group().trim());
				state = true;
			}
			else state = false;
			
		}
		return state;
	}

}