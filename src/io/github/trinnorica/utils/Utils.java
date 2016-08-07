package io.github.trinnorica.utils;

import java.awt.Color;
import java.awt.Graphics;

import res.ExternalFile;

public class Utils {
	
	private static Version version;
	
	public static void start() {
		version = ExternalFile.getVersion__BOOT_ONLY__();
	}


	public static void drawOutlineString(Graphics g, String string, int x, int y, Color text, Color outline, int thickness){
		g.setColor(outline);
		for(int i=1;i!=thickness+1;i++){
			g.drawString(string, x-i, y-i);
			g.drawString(string, x-i, y+i);
			g.drawString(string, x+i, y-i);
			g.drawString(string, x+i, y+i);
		}
		
		g.setColor(text);
		g.drawString(string, x, y);
	}


	public static String getVersion() {
		return version.getVersion();
	}

	

}
