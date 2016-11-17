package Subtitles;

import java.util.*;



public class Database extends ReadFileToArray{
	
	ArrayList<DatabaseRegister> wordsList = new ArrayList<DatabaseRegister>();
	//ArrayList<String> polishWord = new ArrayList<String>();
	//ArrayList<Integer> isKnown = new ArrayList<Integer>();
	//ArrayList<Integer> index = new ArrayList<Integer>();
	//private static int currentIndex;
	
	//DatabaseRegister newWord = new DatabaseRegister(newEnglishWord, newPolishWord, isKnown);
	//newWord.createRegister(newEnglishWord, newPolishWord, isKnown);
	
	DatabaseRegister printWord = new DatabaseRegister();
	DatabaseRegister newWord;
	
	public void addNewWord(String newEnglishWord, String newPolishWord, int isKnown) {
		wordsList.add(new DatabaseRegister(newEnglishWord, newPolishWord, isKnown));
	}	
	
	public void loadsWordsFromFile(String fileName) {
		
		wordsList.addAll(ReadDatabaseFileToArray(fileName));
		//wordsList.add(new DatabaseRegister(newEnglishWord, newPolishWord, isKnown));
	}	
	
	public void getWord(int index){
		printWord = wordsList.get(index);
		System.out.println(printWord.getPolishWord());
	}
	
	public String getPolishWordWithIndex(int index){
		printWord = wordsList.get(index);
	//	System.out.println(printWord.getPolishWord());
		return printWord.getPolishWord();
	}
	
	public int getStateOfWordWithIndex(int index){
		printWord = wordsList.get(index);
	//	System.out.println(printWord.getPolishWord());
		return printWord.getState();
	}
	
	public void printAll() {
		for (DatabaseRegister cos : wordsList) {
			System.out.println(cos.getEnglishWord());
		}
	}
	
	//Check if word exist in database and return index
	public int findWord(String word){
		int state = -1;
		for (DatabaseRegister curWord : wordsList){
			if (curWord.getEnglishWord().equalsIgnoreCase(word)){
				state = curWord.getIndex();
				break;
			}
			//else {
			//	System.out.println("nie ma");
				//currentIndex = -1;
			//}
		}
		return state;
	}
	

	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		
	
	}

}
