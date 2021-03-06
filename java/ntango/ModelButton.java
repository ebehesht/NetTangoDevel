package ntango;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import touch.TouchFrame;

public class ModelButton extends Button {

	//	protected boolean highlighted;
	protected double highlightedCounter = 0;

	public ModelButton(String action) {
		super(action);
		//		highlighted = false;
		// TODO Auto-generated constructor stub
	}

	public ModelButton(int x, int y, int w, int h, String action) {
		this(new RoundRectangle2D.Float(x, y, w, h, h/2, h/2), action);		
	}

	public ModelButton(Shape shape, String action) {
		super(shape, action);
		this.label = null;
	}


	public void loadImage(){

	}



	public void newMethod ()
	{

	}

	public void draw(Graphics2D g, boolean highlighted)
	{
		if (!visible) return;

		Rectangle rect = shape.getBounds();
		int bx = (int)rect.getX();
		int by = (int)rect.getY();
		int bw = (int)rect.getWidth();
		int bh = (int)rect.getHeight();


		int iw = image.getWidth();
		int ih = image.getHeight();
		
		// make the background flash if the model is highlighted
		if(highlighted){
			// calculate an always positive number for the counter
			double highlightTicks = Math.abs(80 + Math.sin(highlightedCounter) * 100);
//			double highlightTicks = Math.sin(highlightedCounter) * 255;
			Color bgcolor = new Color(0, 0, 255, (int)highlightTicks);
			highlightedCounter += .4;
			g.drawImage(image, bx + bw/2 - iw/2, by + bh/2 - ih/2, bgcolor, null);
		} else{
			g.drawImage(image, bx + bw/2 - iw/2, by + bh/2 - ih/2, null);
		}
	}
	
	

}


