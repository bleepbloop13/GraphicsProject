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
	private SpringLayout baseLayout;
	private JButton drawButton;
	private ArrayList<Rectangle> rectangleList;

	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		drawButton = new JButton("This adds rectangles");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLACK);
		this.add(drawButton);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, drawButton, 153, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawButton, -10, SpringLayout.SOUTH, this);
	}

	private void setupListeners()
	{
		drawButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{
				
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
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(current);
		}
	}

}
