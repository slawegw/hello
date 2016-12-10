package Subtitles;

import java.util.ArrayList;
import java.util.StringTokenizer;

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
			
//		for (int i = 0; i < friend.getLength(); i++){
//			int tempWordIndex = -1;
//			newLine = "";
//			temporaryLine = friend.getLineFromArray(i);
//			st = new StringTokenizer(temporaryLine);
//			StringBuffer newLineBuffer = new StringBuffer("");
//			
//			while(st.hasMoreTokens()){
//				
//				tempWord = st.nextToken();
//				tempWordIndex = wordsDatabase.findWord(tempWord); // Get word index if exist, else -1
//												
//				if (tempWordIndex >= 0 && wordsDatabase.getStateOfWordWithIndex(tempWordIndex) != 1){ //1 pomin slowa znane
//					newWord = wordsDatabase.getPolishWordWithIndex(tempWordIndex);
//					newLineBuffer.append(tempWord);
//					newLineBuffer.append("(");
//					newLineBuffer.append(newWord);
//					newLineBuffer.append(") ");
//				}
//				else {
//					newLineBuffer.append(tempWord);
//					newLineBuffer.append(" ");
//				}
//				newLine = newLineBuffer.toString();
//			}
//			System.out.println(newLine);
//		}
		int index;
		//wordsDatabase.printAll();
		//index = wordsDatabase.findWord("not");
		//wordsDatabase.getWord(index);
		
		//wordsDatabase.getWord(wordsDatabase.findWord("is"));
		
		System.out.println();
		//System.out.println(index);

	}  //End of Main
	


}
