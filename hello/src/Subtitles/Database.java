package Subtitles;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;



public class Database{
	
	private ArrayList<DatabaseRegister> databaseWordsList = new ArrayList<DatabaseRegister>(); //lista slow zaladowanych z bazy danych
	private ArrayList<DatabaseRegister> wordsList = new ArrayList<DatabaseRegister>();         //lista slow zaladowanych z pliku z napisami
	
	DatabaseRegister printWord = new DatabaseRegister();
	DatabaseRegister newWord;
	ReadFileToArray databaseFromFile;     //baza znanych i nieznanych slow zaladowana z pliku
	ReadFileToArray wordsLoadedFromFile;   //slowa zaladowane z pliku z napisami
	
	
	/**
	 * Create empty database
	 * @param words
	 */
	public Database(){
		
	}
	
	/**
	 * Create Database with predefined known and not known words.
	 * @param wordsDatabaseFileName path to words database file
	 */
	public Database(String wordsDatabaseFileName){
		databaseFromFile = new ReadFileToArray(wordsDatabaseFileName);	
		this.loadsDatabaseWordsFromFile(wordsDatabaseFileName);
		//wordsLoadedFromFile = new ReadFileToArray();	
	}

	
	
	/**
	 * Add new word to ArrayList database
	 * @param newEnglishWord 
	 * @param newPolishWord
	 * @param isKnown Define whether word is 1:known, 2:unknown or 0:undefined
	 */
	public void addNewWord(String newEnglishWord, String newPolishWord, int isKnown) {
		wordsList.add(new DatabaseRegister(newEnglishWord, newPolishWord, isKnown));
	}	
	
	/**
	 * Load words from subtitles file to DatabaseRegister
	 * @param fileName Path to the file with subtitles.
	 */
	public void loadsWordsFromFile(String fileName) {
		
		String temporaryLine = " ";
		String newLine = "";
		String tempWord = "";
		String newWord = "";
		StringTokenizer st;
		int tempIndex = 0;
		
		wordsLoadedFromFile = new ReadFileToArray(fileName);
		wordsLoadedFromFile.loadFileToArray();	
		
		for (int i = 0; i < wordsLoadedFromFile.getLength(); i++){
			newLine = ""; //czyszczenie kontenera dla nowej lini
			temporaryLine = wordsLoadedFromFile.getLineFromArray(i);
			st = new StringTokenizer(temporaryLine);
			
			//Petla po kazdym slowie w linii
			while(st.hasMoreTokens()){
				
				tempWord = st.nextToken();  // osobne slowa
				
				//if (onlyWordsRegex(tempWord)){
								
				if(this.checkOccurence(tempWord, wordsList) == -1) {  //czy slowo sie juz pojawilo w napisach
					
					newLine += translateKnownWords(tempWord)[0];
					if (onlyWordsRegex(tempWord)) this.addNewWord(tempWord, translateKnownWords(tempWord)[1], 1);			
				}				
				else {			
					newLine += translateKnownWords(tempWord)[0];
				}
			//}
			}
			System.out.println(newLine);  //test
		}		
	}
	
	/**
	 * Load words from database file to DatabaseRegister
	 * @param fileName
	 */
	public void loadsDatabaseWordsFromFile(String fileName) {
		databaseWordsList.addAll(databaseFromFile.ReadDatabaseFileToArray(fileName));
		//wordsList.add(new DatabaseRegister(newEnglishWord, newPolishWord, isKnown));
	}	
	
	public void getWord(int index, ArrayList<DatabaseRegister> wordsListPoint){
		printWord = wordsListPoint.get(index);
		System.out.println(printWord.getPolishWord());
	}
	
	public String getPolishWordWithIndex(int index, ArrayList<DatabaseRegister> wordsListPoint){
		printWord = wordsListPoint.get(index);
	//	System.out.println(printWord.getPolishWord());
		return printWord.getPolishWord();
	}
	
	public int getStateOfWordWithIndex(int index, ArrayList<DatabaseRegister> wordsListPoint){
		printWord = wordsListPoint.get(index);
	//	System.out.println(printWord.getPolishWord());
		return printWord.getState();
	}
	
	public void printAll() {
		for (DatabaseRegister cos : wordsList) {
			System.out.println(cos.getEnglishWord());
		}
	}
	
	
	/**
	 * Returns words list sorted in ascending order
	 * @return
	 */
	public ArrayList<DatabaseRegister> getAscendingOrder(){		
		ArrayList<DatabaseRegister> wordsSortedAscending = new ArrayList<DatabaseRegister>();  
		wordsSortedAscending.addAll(wordsList);
		 Collections.sort(wordsSortedAscending);
		return wordsSortedAscending;
	}
	
	/**
	 * Returns words list sorted in scending order
	 * @return
	 */
	public ArrayList<DatabaseRegister> getDescendingOrder(){		
		ArrayList<DatabaseRegister> wordsSortedDescending = new ArrayList<DatabaseRegister>();  
		wordsSortedDescending.addAll(wordsList);
		 Collections.sort(wordsSortedDescending);
		 Collections.reverse(wordsSortedDescending);
		return wordsSortedDescending;
	}
	
	/**
	 * Appends translation to words in brackets
	 * @param word English word to translation
	 * @return English word with polish translation in brackets.
	 */
	public String[] translateKnownWords(String word){
		
		int tempIndex = -1; 
		String newWord = "";
		String[] words = new String[2];
		StringBuffer newLineBuffer = new StringBuffer("");
		
		//Jesli slowo istnieje w predefiniowanej bazie danych pobierz jego index i dodaj tlumaczenie
		tempIndex = this.findWord(word, databaseWordsList); // Get word index from Database if exist, else -1
		//state = this.getStateOfWordWithIndex(tempWordIndex);				
		if (tempIndex >= 0 
				//&& (this.getStateOfWordWithIndex(tempWordIndex, databaseWordsList) == 1 || 
				//this.getStateOfWordWithIndex(tempWordIndex, databaseWordsList) == 2)
			){ //1 pomin slowa znane					
			newWord = this.getPolishWordWithIndex(tempIndex, databaseWordsList);						
			newLineBuffer.append(word);
			newLineBuffer.append("(");
			newLineBuffer.append(newWord);
			newLineBuffer.append(") ");			
		}
		else {
			newLineBuffer.append(word);
			newLineBuffer.append(" ");
		}
		words[0] = newLineBuffer.toString();
		words[1] = newWord;
		return words;
	}
	
	//Check if word exist in database
	public boolean checkIfWordExist(String word, ArrayList<DatabaseRegister> wordsListPoint){
		boolean state = false;
		for (DatabaseRegister curWord : wordsListPoint){
			if (curWord.getEnglishWord().equalsIgnoreCase(word)){
				state = true;
				break;
			}
			else {
			//	System.out.println("nie ma");
				//currentIndex = -1;
				state = false;
			}
		}
		return state;
	}
	
	//Check if word exist in database and return index
	public int findWord(String word, ArrayList<DatabaseRegister> wordsListPoint){
		int state = -1;
		for (DatabaseRegister curWord : wordsListPoint){
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
	
	//Check if word exist in database and return index
	public int checkOccurence(String word, ArrayList<DatabaseRegister> wordsListPoint){
		int state = -1;
		for (DatabaseRegister curWord : wordsListPoint){
			if (curWord.getEnglishWord().equalsIgnoreCase(word)){
				state = curWord.getIndex();
				if(onlyWordsRegex(word)){
					curWord.addOccurence();
				}
				//System.out.println("Occurence("+ curWord.getEnglishWord() +"):"+curWord.getOccurences());
				break;
			}
			//else {
			//	System.out.println("nie ma");
				//currentIndex = -1;
			//}
		}
		return state;
	}

	public static boolean onlyWordsRegex(String str2Check){
		boolean state = false;
		Pattern checkRegex = Pattern.compile("[a-zA-Z]");
		
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
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		
	
	}

}
