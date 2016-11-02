package Subtitles;

import java.util.*;



public class Database {
	
	ArrayList<DatabaseRegister> englishWord = new ArrayList<DatabaseRegister>();
	//ArrayList<String> polishWord = new ArrayList<String>();
	//ArrayList<Integer> isKnown = new ArrayList<Integer>();
	//ArrayList<Integer> index = new ArrayList<Integer>();
	private static int currentIndex;
	
	DatabaseRegister newWord = new DatabaseRegister();
	DatabaseRegister printWord = new DatabaseRegister();
	
	private void addNewWord(String newEnglishWord, String newPolishWord, int isKnown) {
		
		newWord.createRegister(newEnglishWord, newPolishWord, isKnown);
		englishWord.add(newWord);
		
		
		
	}
	
	
	public void getWord(int index){
		
		printWord = englishWord.get(index);

		System.out.println(printWord.getPolishWord());
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Database newRegister = new Database();
		
		newRegister.addNewWord("I", "ja", 0);
		newRegister.addNewWord("am", "jestem", 0);
		newRegister.addNewWord("Marian", "Marina", 0);
		
		newRegister.getWord(0);
		
		
		
		
	
	}

}
