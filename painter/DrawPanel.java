package painter;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{

	private Shape shapes[];
	private int numShapes;
	private int x1, y1, x2, y2;
	private Color color;
	private Color color2;
	private boolean filled;
	
	
	private final int MAX = 100;
	
	private int shapeType=1;
	private final int SHAPES = 3;
	private final int RECT = 1;
	private final int OVAL = 2;
	private final int VTRIANGLE = 3;
	
	private int vtriType;
	
	public DrawPanel(){
		super();
		shapes = new Shape[MAX];
		//randgen(10);
	}
	
	public void setColor(Color color){
		this.color = color;
		System.out.println(color);
	}
	
	public void setColor2(Color color2){
		this.color2 = color2;
		System.out.println(color2);
	}
	
	public void clear(){
		numShapes = 0;
		repaint();
	}
	
	public void addShape(int shapeType){
		Random rand = new Random();
		x1 = rand.nextInt(500);
		y1 = rand.nextInt(500);
		x2 = rand.nextInt(500);
		y2 = rand.nextInt(500);
		filled = rand.nextBoolean();
		vtriType = rand.nextInt(4)+1;
		switch(shapeType){
		case RECT:
			shapes[numShapes++] = new Rect(x1,y1,x2,y2,color,color2, filled);		
			break;
		case OVAL:
			shapes[numShapes++] = new Oval(x1,y1,x2,y2,color,color2, filled);	
			break;
		case VTRIANGLE:
			shapes[numShapes++] = new VTriangle(x1,y1,x2,y2,color,filled,vtriType);	
			break;	
		}
		repaint();

	}
	
	public void randgen(int num){
		Random rand = new Random();
		
		for(int i=0;i<num;i++){
			x1 = rand.nextInt(500);
			y1 = rand.nextInt(500);
			x2 = rand.nextInt(500);
			y2 = rand.nextInt(500);
			color = new Color(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));
			filled = rand.nextBoolean();
			shapeType = rand.nextInt(SHAPES)+1;
			switch(shapeType){
			case RECT:
				shapes[numShapes++] = new Rect(x1,y1,x2,y2,color,filled);		
				break;
			case OVAL:
				shapes[numShapes++] = new Oval(x1,y1,x2,y2,color,filled);	
				break;
			}
			
		}		
		repaint();
	}
	
	public void randgenVtri(int num){
		Random rand = new Random();
		
		for(int i=0;i<num;i++){
			x1 = rand.nextInt(500);
			y1 = rand.nextInt(500);
			x2 = rand.nextInt(500);
			y2 = rand.nextInt(500);
			color = new Color(rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));
			filled = rand.nextBoolean();
			vtriType = rand.nextInt(4)+1;
			shapes[numShapes++] = new VTriangle(x1,y1,x2,y2,color,filled,vtriType);					
		}		
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0;i<numShapes;i++){
			shapes[i].draw(g);
			System.out.println(shapes[i]);
		}
	}
	
}
