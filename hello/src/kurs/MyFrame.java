package kurs;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class MyFrame extends JFrame{
	
	public MyFrame(){
		super("new frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//setLocation(200,100);
		//setSize(300,200);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//add(new JButton("Przycisk"));
		//add(new JButton("Przycisk1"));
		
		JPanel panel = new MyPanel();
		
		//JPanel dupeczka = new PicturePanel();
		//add(dupeczka);
		
		
		add(panel);
		pack();
		
	}

}
