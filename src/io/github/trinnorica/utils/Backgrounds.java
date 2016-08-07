package io.github.trinnorica.utils;

import java.awt.Image;

import res.ExternalFile;

public enum Backgrounds {
	
	MAIN("backgrounds/menu-background.png"),
	GRASS("backgrounds/grass-background.png");
	
	String image;
	
	Backgrounds(String image){
		this.image = image;
	}
	
	public Image getImage(){
		return ExternalFile.loadTexture(image);
	}

}
