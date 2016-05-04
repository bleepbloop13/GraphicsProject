package graphics.view;

import java.awt.*;
import javax.swing.*;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
	
	public GraphPanel()
	{
		//initialize graphSource here
		graphSource = new int[] {2,4,213,10,20,12,75};
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(int index = 0; index < graphSource.length; index++)
		{
			int height = this.getHeight()/graphSource.length;
			int width = graphSource[index];
			int xPosition = 0;
			int yPosition = height * index;
			
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(new Rectangle(xPosition, yPosition, width, height));
		}
	}
}
