package Subtitles.Graph;

import java.awt.EventQueue;



public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		EventQueue.invokeLater(new Runnable(){
		@Override
		public void run(){
			new MainFrame();
		}
		});

	}

}
