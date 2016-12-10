package Subtitles;



public  class DatabaseRegister {
	
	private  String polishWord = "";
	private  String englishWord = "";
	private  int isKnownState = -1; // 0 - new, 1 - unknown, 2 - known
	private static int currentIndex = 0;
	private int wordIndex = 0;
	
	public DatabaseRegister(){}
	
	/**
	 * 
	 * @param newEnglishWord
	 * @param newPolishWord
	 * @param isKnown
	 */
	public DatabaseRegister(String newEnglishWord, String newPolishWord, int isKnown) {
		
		this.polishWord = newPolishWord;
		this.englishWord = newEnglishWord;
		this.isKnownState = isKnown;
		this.wordIndex = currentIndex;
		currentIndex++;
	}
	
	public void createRegister(String newEnglishWord, String newPolishWord, int isKnown) {
		
		this.polishWord = newPolishWord;
		this.englishWord = newEnglishWord;
		this.isKnownState = isKnown;
	}
	
	public String getPolishWord(){
		return this.polishWord;
	}
	
	public String getEnglishWord(){
		return this.englishWord;
	}
	
	public int getState(){
		return this.isKnownState;
	}
	
	public int getIndex(){
		return wordIndex;
	}
	

}
