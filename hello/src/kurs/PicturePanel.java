package kurs;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class PicturePanel extends JPanel {

	private BufferedImage image;
	
	public PicturePanel(){
		super();
		
		File imageFile = new File("aa.jpg");
		try{
			image = ImageIO.read(imageFile);
		} catch(IOException e){
			System.err.println("B³¹d odczytu pliku");
			e.printStackTrace();
		}
		
		setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));	
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
	}
	
}
