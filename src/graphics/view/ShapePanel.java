package graphics.view;

import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	
	public ShapePanel()
	{
		rectList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
	}
	
	
	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * 600);
		int yPosition = (int)(Math.random() * 400);
		int width = (int)(Math.random() * 250);
		int height = (int)(Math.random() * 600);
		
		Rectangle currentRectangle = new Rectangle(xPosition, yPosition, width, height);
		rectList.add(currentRectangle);
	}
	
	public void addSquare()
	{
		int xPosition = (int)(Math.random() * 600);
		int yPosition = (int)(Math.random() * 400);
		int width = (int)(Math.random() * 100);
		int height = width;
		
		Rectangle currentSquare = new Rectangle(xPosition, yPosition, width, height);
		squareList.add(currentSquare);
	}
	
	public void addCircle()
	{
		int xPosition = (int)(Math.random() * 600);
		int yPosition = (int)(Math.random() * 400);
		int width = (int)(Math.random() * 100);
		int height = width;
		
		Ellipse2D currentCircle = new Ellipse2D.Double(xPosition, yPosition, width, height);
		circleList.add(currentCircle);
	}
	
	public void addEllipse()
	{
		int xPosition = (int)(Math.random() * 600);
		int yPosition = (int)(Math.random() * 400);
		int width = (int)(Math.random() * 250);
		int height = (int)(Math.random() * 600);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
		ellipseList.add(currentEllipse);
	}
	public void addTriangle()
	{
		int [] xPoints = new int[3];
		xPoints[0] = (int)(Math.random() * 150);
		xPoints[1] = (int)(Math.random() * 250);
		xPoints[2] = (int)(Math.random() * 550);
		
		int [] yPoints = {(int)(Math.random() * 350),(int)(Math.random() * 50),(int)(Math.random() * 650)};
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		triangleList.add(triangle);
	}

	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 9) + 3;
		int [] xPoints = new int [numberOfSides];
		int [] yPoints = new int [numberOfSides];
		
		for(int side = 0; side < numberOfSides; side++)
		{
			yPoints[side] = (int)(Math.random() * 2000);
			xPoints[side] = (int)(Math.random() * 2000);
		}
		
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(Polygon currentTriangle : triangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentTriangle);
		}
		
		for(Polygon currentPolygon : polygonList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red, green, blue));
			
			mainGraphics.fill(currentPolygon);
			
			
		}
		for(Ellipse2D currentEllipse : ellipseList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentEllipse);
		}
		for(Ellipse2D currentCircle : circleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentCircle);
		}
		
		for(Rectangle currentSquare : squareList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red, green, blue));
			
			mainGraphics.fill(currentSquare);
		}
		
		for(Rectangle currentRectangle: rectList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentRectangle);
		}
	}
	
}
