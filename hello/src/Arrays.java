import java.util.*;
import java.io.*;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader readFile = null;
		String linia = " ";
		ArrayList<String> lista = new ArrayList<String>();  // glowna lista
		
		// Otwieranie pliku
		try {
			readFile = new FileReader("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		BufferedReader bfr = new BufferedReader(readFile);
		
		// Wczytywanie pliku
		try {
			while ((linia = bfr.readLine()) != null) {

				lista.add(linia);
			}
		} catch (IOException e) {
			System.out.println("Blad odczytu");
		}
		
		// zamykanie pliku
		try {
			bfr.close();
		}catch (IOException e){
			System.out.println("Blad zamykania pliku");
		}
		
		// Print
		System.out.println(lista.get(1));

	}

}
