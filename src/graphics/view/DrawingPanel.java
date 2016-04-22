package graphics.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.controller.GraphicsController;

import javax.swing.*;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private SpringLayout baseLayout;
	private JButton drawButton;
	
	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		drawButton = new JButton("This adds stuff");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
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
}
