package AdvansedMainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.nio.CharBuffer;


public class BounceEntity implements Runnable {
	private static final int MIN_RADIUS = 3;
	private static final int MAX_RADIUS = 40;
	private static final int MAX_SPEED = 50;
	private BounceField field = new BounceField();
	private int radius = 0;
	private int speed;
	private int speedX;
	private int speedY;
	private Color color;
	private double x = 0;
	private double y = 0;

	public BounceEntity(BounceField bounceField) {
		this.field = bounceField;
		radius = new Double(Math.random()*(MAX_RADIUS - MIN_RADIUS)).intValue() + MIN_RADIUS;
		speed = new Double(Math.round(5*MAX_SPEED / radius)).intValue();
		if (speed>MAX_SPEED) {
			speed = MAX_SPEED;
		}
		double angle = Math.random()*2*Math.PI;
		speedX = (int) (3*Math.cos(angle));
		speedY = (int) (3*Math.sin(angle));
		
		color = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
		
		x = Math.random()*(bounceField.getSize().getWidth()-2*radius) + radius;
		y = Math.random()*(bounceField.getSize().getHeight()-2*radius) + radius;
		
		Thread thisThread = new Thread(this);
		thisThread.start();
		

	}

	public void paint(Graphics2D canvas) {
		canvas.setColor(color);
		canvas.setPaint(color);
		Ellipse2D.Double ball = new Ellipse2D.Double(x - radius, y - radius,
		2*radius, 2*radius);
		canvas.draw(ball);
		canvas.fill(ball);
	}
	
	private void goMoving() {
		if (x + speedX <= radius) {
			speedX = -speedX;
			x = radius;
		} else
			if (x + speedX >= field.getWidth() - radius) {
				speedX = -speedX;
				x=new Double(field.getWidth()-radius).intValue();
			} else
				if (y + speedY <= radius) {
					speedY = -speedY;
					y = radius;
				} else
					if (y + speedY >= field.getHeight() - radius) {
						speedY = -speedY;
						y=new Double(field.getHeight()-radius).intValue();
					} else {
						x += speedX;
						y += speedY;
					}
		
	}
	
	
	@Override
	public void run() {
		try {
			while(true) {
				goMoving();
				Thread.sleep(10);
			}
		} catch (InterruptedException ex) {
		}
	}

}
