package Subtitles;

import java.util.StringTokenizer;

public class Translate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadFileToArray friend = new ReadFileToArray();
		String temporaryLine = " ";
		String newLine = "";
		String tempWord = "";
		StringTokenizer st;
		
		
		friend.loadFileToArray();
		
		//friend.printLineFromArray(2);
			
		for (int i = 0; i < friend.getLength(); i++){
			
			newLine = "";
			temporaryLine = friend.getLineFromArray(i);
			st = new StringTokenizer(temporaryLine);
			StringBuffer newLineBuffer = new StringBuffer("");
			
			while(st.hasMoreTokens()){
				
				tempWord = st.nextToken();
				
				//tempWord = database.translate(tempWord);
				
				newLineBuffer.append(tempWord);
				newLineBuffer.append(" ");
				newLine = newLineBuffer.toString();
			}
			System.out.println(newLine);
			
		}
		

	}

}
