package Subtitles.Graph;

import java.awt.Dimension;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	public MainFrame(){
		
		super("Subtitles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLocation(200,200);
		setPreferredSize(new Dimension(800,600));
		//this.setSize(800,600);
		
		JPanel mainPanel = new MainPanel();
		
		add(mainPanel);
		
		pack();
		
		
	}
	
	

}
