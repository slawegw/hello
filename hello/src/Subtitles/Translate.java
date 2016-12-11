package Subtitles;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class Translate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<DatabaseRegister> loadedWordsList = new ArrayList<DatabaseRegister>();
		ReadFileToArray friend = new ReadFileToArray();
		Database wordsDatabase;
		String temporaryLine = " ";
		String newLine = "";
		String tempWord = "";
		String newWord = "";
		StringTokenizer st;
		

		//wordsDatabase.loadsWordsFromFile("wordsDatabase.txt");
		wordsDatabase = new Database("wordsDatabase.txt");
		wordsDatabase.loadsWordsFromFile("the.big.bang.theory.txt");
		
		
		//friend.loadFileToArray("the.big.bang.theory.txt");  // laduje plik do glownej listy
		
		//friend.printLineFromArray(2);
			

		int index;
		//wordsDatabase.printAll();
		
		System.out.println("-----------------------------");

		for(DatabaseRegister curr : wordsDatabase.getDescendingOrder() ){
			System.out.println(curr.getEnglishWord() + " Occ: " + curr.getOccurences());
		}
		//index = wordsDatabase.findWord("not");
		//wordsDatabase.getWord(index);
		
		//wordsDatabase.getWord(wordsDatabase.findWord("is"));
		
		System.out.println();
		//System.out.println(index);

	}  //End of Main
	


}
