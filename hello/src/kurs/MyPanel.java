package kurs;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	public MyPanel(){
		setPreferredSize(new Dimension(400,400));
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		setBackground(Color.lightGray);
		
		
		//prostokat
		Rectangle2D rectangle = new Rectangle2D.Double(10,10,300,300);
		
		Ellipse2D elipse = new Ellipse2D.Double(10,10,300,300);
		
		
		g2d.draw(rectangle);
		g2d.draw(elipse);
		
	}

	
	
}
