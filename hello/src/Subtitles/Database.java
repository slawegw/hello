package Subtitles;

import java.util.*;



public class Database{
	
	private ArrayList<DatabaseRegister> databaseWordsList = new ArrayList<DatabaseRegister>(); //lista slow zaladowanych z bazy danych
	private ArrayList<DatabaseRegister> wordsList = new ArrayList<DatabaseRegister>();         //lista slow zaladowanych z pliku z napisami
	//ArrayList<String> polishWord = new ArrayList<String>();
	//ArrayList<Integer> isKnown = new ArrayList<Integer>();
	//ArrayList<Integer> index = new ArrayList<Integer>();
	//private static int currentIndex;
	
	//DatabaseRegister newWord = new DatabaseRegister(newEnglishWord, newPolishWord, isKnown);
	//newWord.createRegister(newEnglishWord, newPolishWord, isKnown);
	
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
			int tempWordIndex = -1;
			newLine = "";
			temporaryLine = wordsLoadedFromFile.getLineFromArray(i);
			st = new StringTokenizer(temporaryLine);
			StringBuffer newLineBuffer = new StringBuffer("");
			
			//Petla po kazdym slowie w linii
			while(st.hasMoreTokens()){
				
				tempWord = st.nextToken();  // osobne slowa
			//	tempIndex = this.checkOccurence(tempWord, wordsList);
				
				// sprawdz czy slowo juz istnieje
//				if(tempIndex != -1) {
//				System.out.println("Istnieje");
//					//wordsList.get(tempIndex).addOccurence();
//				}
				if(this.checkOccurence(tempWord, wordsList) == -1) {
					
					//Jesli slowo istnieje w predefiniowanej bazie danych pobierz jego index i dodaj tlumaczenie
					tempWordIndex = this.findWord(tempWord, databaseWordsList); // Get word index from Database if exist, else -1
					//state = this.getStateOfWordWithIndex(tempWordIndex);				
					if (tempWordIndex >= 0 
							//&& (this.getStateOfWordWithIndex(tempWordIndex, databaseWordsList) == 1 || 
							//this.getStateOfWordWithIndex(tempWordIndex, databaseWordsList) == 2)
						){ //1 pomin slowa znane					
						newWord = this.getPolishWordWithIndex(tempWordIndex, databaseWordsList);						
						newLineBuffer.append(tempWord);
						newLineBuffer.append("(");
						newLineBuffer.append(newWord);
						newLineBuffer.append(") ");			
					}
					else {
						newLineBuffer.append(tempWord);
						newLineBuffer.append(" ");
					}
					newLine = newLineBuffer.toString();
					this.addNewWord(tempWord, newWord, 1);
					
				}				
				else {
					
					//Jesli slowo istnieje w predefiniowanej bazie danych pobierz jego index i dodaj tlumaczenie
					tempWordIndex = this.findWord(tempWord, databaseWordsList); // Get word index from Database if exist, else -1
					//state = this.getStateOfWordWithIndex(tempWordIndex);				
					if (tempWordIndex >= 0 
							//&& (this.getStateOfWordWithIndex(tempWordIndex, databaseWordsList) == 1 || 
							//this.getStateOfWordWithIndex(tempWordIndex, databaseWordsList) == 2)
						){ //1 pomin slowa znane					
						newWord = this.getPolishWordWithIndex(tempWordIndex, databaseWordsList);						
						newLineBuffer.append(tempWord);
						newLineBuffer.append("(");
						newLineBuffer.append(newWord);
						newLineBuffer.append(") ");
					}
					else {
						newLineBuffer.append(tempWord);
						newLineBuffer.append(" ");
					}
				
					newLine = newLineBuffer.toString();
				}
				

			}
			System.out.println(newLine);  //test
		}
		
		// test occurences
	//	tempIndex = this.findWord("the", wordsList);
	//	wordsList.get(1).getOccurences();
	//	System.out.println(wordsList); 
		
		//wordsList.addAll(new ReadFileToArray().ReadDatabaseFileToArray(fileName));
		//wordsList.add(new DatabaseRegister(newEnglishWord, newPolishWord, isKnown));
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
				curWord.addOccurence();
				System.out.println("Occurence("+ curWord.getEnglishWord() +"):"+curWord.getOccurences());
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
