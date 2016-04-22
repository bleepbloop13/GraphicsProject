package graphics.view;

import graphics.controller.GraphicsController;
import javax.swing.JFrame;

public class DrawingFrame extends JFrame
{
	private DrawingPanel basePanel;
	private GraphicsController baseController;
	
	public DrawingFrame(GraphicsController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(1200,900);
		this.setTitle("Rectangles lol");
		this.setVisible(true);
	}
}
