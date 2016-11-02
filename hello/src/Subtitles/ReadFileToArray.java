package Subtitles;

import java.util.*;
import java.io.*;

public class ReadFileToArray {

	private FileReader readFile = null;
	private String linia = " ";
	ArrayList<String> lista = new ArrayList<String>(); // glowna lista
	private BufferedReader bfr;

	// Otwieranie pliku
	private BufferedReader openTextFile() {
		try {
			readFile = new FileReader("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		bfr = new BufferedReader(readFile);

		return bfr;
	}

	// zamykanie pliku
	private void closeTextFile() {
		try {
			bfr.close();
		} catch (IOException e) {
			System.out.println("Blad zamykania pliku");
		}
	}

	// Wczytywanie pliku
	public void loadFileToArray() {

		this.openTextFile();

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

}