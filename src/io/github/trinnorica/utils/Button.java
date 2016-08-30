package io.github.trinnorica.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;

public class Button implements Clickable {
	
	String name;
	//Button's position will refer to the CENTER of the polygon
	int x;
	int y;
	int width;
	int height;
	Runnable method;
	Polygon bounds;
	boolean hover = false;
	boolean active = false;
	
	public Button(int x, int y, int width, int height, String name, Runnable method){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
		this.method = method;
		bounds = new Polygon(new int[] {x-width/2, x+width/2,x+width/2,x-width/2}, new int[] {y+height/2,y+height/2,y-height/2,y-height/2}, 4);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		hover = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		hover = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		method.run();
		active = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		active = false;
	}

	@Override
	public Polygon getPolygon() {
		return bounds;
	}

	@Override
	public Polygon drawPolygon(Graphics g) {
		if(!active){
			if(hover)
				g.setColor(Color.decode("#99db45"));
			else g.setColor(Color.decode("#c2e298"));
			g.fillPolygon(bounds);
			g.setColor(Color.WHITE);
			g.drawString(name, x-g.getFontMetrics().stringWidth(name)/2, y+(g.getFontMetrics().getHeight()/4));
			g.drawRect((int)getPolygon().getBounds().getX(), (int)getPolygon().getBounds().getY(), (int)getPolygon().getBounds().getWidth(), (int)getPolygon().getBounds().getHeight());
			return null;
		} else {
			 g.setColor(Color.WHITE);
			g.fillPolygon(bounds);
			g.setColor(Color.decode("#99db45"));
			g.drawString(name, x-g.getFontMetrics().stringWidth(name)/2, y+(g.getFontMetrics().getHeight()/4));
			g.drawRect((int)getPolygon().getBounds().getX(), (int)getPolygon().getBounds().getY(), (int)getPolygon().getBounds().getWidth(), (int)getPolygon().getBounds().getHeight());
			return null;
		}
	}
	
}