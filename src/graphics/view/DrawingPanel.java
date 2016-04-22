package graphics.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;

import graphics.controller.GraphicsController;

import javax.swing.*;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private ShapePanel shapePanel;
	private SpringLayout baseLayout;
	private JButton drawButton;
	private ArrayList<Rectangle> rectangleList;

	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		drawButton = new JButton("This adds rectangles");
		rectangleList = new ArrayList<Rectangle>();
		shapePanel = new ShapePanel();


		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLACK);
		this.add(drawButton);
		this.add(shapePanel);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, drawButton, 153, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -50, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{
		drawButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * getWidth());
				int yPosition = (int)(Math.random() * getHeight());
				int width = (int)(Math.random() * 100);
				int height = (int)(Math.random() * 100);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		mainGraphics.setStroke(new BasicStroke(20));
		mainGraphics.setColor(Color.CYAN);
		
		mainGraphics.drawRect(50, 90, 300, 500);
		
		for(Rectangle current : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			
			mainGraphics.setStroke(new BasicStroke((int)(Math.random() * 30)));
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.draw(current);
		}
	}

}
