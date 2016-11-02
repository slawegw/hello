package Subtitles;

import java.util.StringTokenizer;

public class Translate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadFileToArray friend = new ReadFileToArray();
		Database wordsDatabase = new Database();
		String temporaryLine = " ";
		String newLine = "";
		String tempWord = "";
		String newWord = "";
		StringTokenizer st;
		
		// Baza danych do testow
		wordsDatabase.addNewWord("List", "Lista", 0);
		wordsDatabase.addNewWord("implementation", "implementacja", 0);
		wordsDatabase.addNewWord("is", "jest", 0);
		wordsDatabase.addNewWord("not", "nie", 0);
		wordsDatabase.addNewWord("size", "rozmiar", 0);
		wordsDatabase.addNewWord("has", "ma", 0);
		wordsDatabase.addNewWord("and", "i", 0);
		wordsDatabase.addNewWord("this", "ten", 0);
		
		friend.loadFileToArray();
		
		//friend.printLineFromArray(2);
			
		for (int i = 0; i < friend.getLength(); i++){
			int tempWordIndex = -1;
			newLine = "";
			temporaryLine = friend.getLineFromArray(i);
			st = new StringTokenizer(temporaryLine);
			StringBuffer newLineBuffer = new StringBuffer("");
			
			while(st.hasMoreTokens()){
				
				tempWord = st.nextToken();
				tempWordIndex = wordsDatabase.findWord(tempWord); // Get word index if exist, else -1
												
				if (tempWordIndex >= 0 ){
					newWord = wordsDatabase.getPolishWordWithIndex(tempWordIndex);
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
			System.out.println(newLine);
		}
		int index;
		//wordsDatabase.printAll();
		//index = wordsDatabase.findWord("not");
		//wordsDatabase.getWord(index);
		
		wordsDatabase.getWord(wordsDatabase.findWord("is"));
		
		System.out.println();
		//System.out.println(index);

	}

}
