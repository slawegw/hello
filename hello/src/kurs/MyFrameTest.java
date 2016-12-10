package kurs;

import java.awt.EventQueue;

public class MyFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable(){
		@Override
		public void run(){
			new MyFrame();
		}
		});
		
		

	}

}
