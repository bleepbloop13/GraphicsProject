package graphics.view;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

import graphics.controller.GraphicsController;

import javax.swing.*;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	private SpringLayout baseLayout;
	private JButton rectButton;
	private JButton squareButton;
	private JButton triangleButton;
	private JButton polyButton;
	private JButton ellipseButton;
	private JButton circleButton;
	private JButton graphButton;
	private ArrayList<Rectangle> rectangleList;

	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		rectButton = new JButton("This adds rectangles");
		triangleButton = new JButton("This adds triangles");
		polyButton = new JButton("This adds random polygons");
		ellipseButton = new JButton("Add an ellipse!");
		circleButton = new JButton("Add a circle!");
		graphButton = new JButton("Make a Graph!");
		squareButton = new JButton("add a Square!");
		rectangleList = new ArrayList<Rectangle>();
		shapePanel = new ShapePanel();
		graphPanel = new GraphPanel();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLACK);
		this.add(rectButton);
		this.add(triangleButton);
		this.add(polyButton);
		this.add(graphButton);
		this.add(squareButton);
		this.add(ellipseButton);
		this.add(circleButton);
		this.add(shapePanel);
		this.add(graphPanel);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, rectButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, rectButton, 133, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, polyButton, 0, SpringLayout.NORTH, rectButton);
		baseLayout.putConstraint(SpringLayout.WEST, polyButton, 6, SpringLayout.EAST, triangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, triangleButton, 0, SpringLayout.NORTH, rectButton);
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 6, SpringLayout.EAST, rectButton);
		baseLayout.putConstraint(SpringLayout.EAST, triangleButton, 150, SpringLayout.EAST, rectButton);
		baseLayout.putConstraint(SpringLayout.NORTH, graphButton, 0, SpringLayout.NORTH, rectButton);
		baseLayout.putConstraint(SpringLayout.WEST, graphButton, 6, SpringLayout.EAST, polyButton);
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 27, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 22, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -48, SpringLayout.NORTH, rectButton);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -6, SpringLayout.WEST, shapePanel);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 27, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -166, SpringLayout.NORTH, rectButton);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -23, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 358, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, ellipseButton, 0, SpringLayout.WEST, triangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, ellipseButton, -6, SpringLayout.NORTH, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 20, SpringLayout.EAST, ellipseButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, circleButton, -6, SpringLayout.NORTH, polyButton);
		baseLayout.putConstraint(SpringLayout.NORTH, squareButton, 0, SpringLayout.NORTH, ellipseButton);
		baseLayout.putConstraint(SpringLayout.EAST, squareButton, 0, SpringLayout.EAST, rectButton);
	}

	private void setupListeners()
	{
		rectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				shapePanel.repaint();
			}
		});
		graphButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				graphPanel.repaint();
			}
		});
		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				shapePanel.repaint();
			}
		});
		squareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				shapePanel.repaint();
			}
		});
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				shapePanel.repaint();
			}
		});
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				shapePanel.repaint();
			}
		});
		polyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				shapePanel.repaint();
			}
		});
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{
				
			}
			public void mouseDragged(MouseEvent dragged)
			{
				int xPosition = dragged.getX();
				int yPosition = dragged.getY();
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

		for(Rectangle current : rectangleList)
		{
			
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.setStroke(new BasicStroke((int)(Math.random() * 30)));
			mainGraphics.draw(current);
		}
	}

}
