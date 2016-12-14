package Subtitles.Graph;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Subtitles.MainFrame;
import Subtitles.Translate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainPanel extends JPanel implements ActionListener {
	
	private JButton loadFile, saveFile;
	private JButton close;
	
	private JTextArea textArea;
	
	public MainPanel(){
		
		//setPreferredSize(new Dimension(800,200));
		//this.setSize(800, 600);
		this.setBackground(Color.decode("#DBE3DE"));
		
		loadFile = new JButton("Zaladuj plik");
		close = new JButton("Zamknij");
		saveFile = new JButton("Zapisz");
		
		textArea = new JTextArea();
		textArea.setBounds(50, 50, 300, 50);
		//JScrollPane scrollPane = new JScrollPane(textArea);
		//scrollPane.setBounds(50, 50, 200, 100);
		
		loadFile.addActionListener(this);
		
		close.addActionListener(this);
		saveFile.addActionListener(this);
		
		add(loadFile);
		add(saveFile);
		add(close);
		add(textArea);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		Object source = e.getSource();
		
		if(source == loadFile){
			//new Translate();
		
			JFileChooser subFile = new JFileChooser();
			
			if (subFile.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
				File sFile = subFile.getSelectedFile();
				
				new Translate(sFile.getAbsolutePath());
								
				//JOptionPane.showMessageDialog(null, "Wybran plik" + sFile.getAbsolutePath());
			}
		}
		
		else if(source == saveFile){
			JFileChooser subFile = new JFileChooser();
			if(subFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
				File sFile = subFile.getSelectedFile();
				JOptionPane.showMessageDialog(null, "Plik zapisano w "+sFile.getAbsolutePath());
			}
			
		}
		
		else if(source == close) 
		System.exit(0);
	
			
		
		
	}
	
	
	
	

}
