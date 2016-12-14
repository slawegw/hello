package Subtitles;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Subtitles.Graph.MainPanel;
//import kurs.MyFrame;

import java.util.Collections;

public class Translate {

	//  public static void main(String[] args) {
		
		public Translate(String filePath) {
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
		//wordsDatabase.loadsWordsFromFile("the.big.bang.theory.txt");
		wordsDatabase.loadsWordsFromFile(filePath);
	

		//wordsDatabase.printAll();
		
		System.out.println("-----------------------------");

		for(DatabaseRegister curr : wordsDatabase.getDescendingOrder() ){
			System.out.println(curr.getEnglishWord() + " Occ: " + curr.getOccurences());
		}
		//index = wordsDatabase.findWord("not");
		//wordsDatabase.getWord(index);
		
//		EventQueue.invokeLater(new Runnable(){
//		@Override
//		public void run(){
//			new MyFrame();
//		}
//		});
		
		//wordsDatabase.getWord(wordsDatabase.findWord("is"));
		
		System.out.println();
		//System.out.println(index);

	}  //End of Main
	


}
