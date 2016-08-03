package io.github.trinnorica.utils;

import java.awt.Color;
import java.awt.Graphics;

public class Utils {
	public static void drawOutlineString(Graphics g, String string, int x, int y, Color text, Color outline, int thickness){
		g.setColor(outline);
		g.drawString(string, x-thickness, y-thickness);
		g.drawString(string, x-thickness, y+thickness);
		g.drawString(string, x+thickness, y-thickness);
		g.drawString(string, x+thickness, y+thickness);
		g.setColor(text);
		g.drawString(string, x, y);
	}

}
