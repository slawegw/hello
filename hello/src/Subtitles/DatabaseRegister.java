package Subtitles;

public  class DatabaseRegister {
	
	private  String polishWord = "";
	private  String englishWord = "";
	private  int isKnownState = -1; // 0 - new, 1 - unknown, 2 - known
	
	
	
	public void createRegister(String newEnglishWord, String newPolishWord, int isKnown) {
		
		this.polishWord = newPolishWord;
		this.englishWord = newEnglishWord;
		this.isKnownState = isKnown;
	}
	
	public String getPolishWord(){
		return this.polishWord;
	}
	
	public String getEnglishWord(){
		return this.polishWord;
	}
	
	public int getState(){
		return this.isKnownState;
	}
	

}
