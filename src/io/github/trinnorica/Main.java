package io.github.trinnorica;

import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.Button;
import io.github.trinnorica.utils.Clickable;
import io.github.trinnorica.utils.Utils;

public class Main {
	
	private static List<Clickable> clickables = new ArrayList<>(); 
	
	
	public static void main(String[] args){
		Utils.start();
		new Window();
		
	}
	
	public static void setBoard(int board){
		if(board == Board.MAIN){
			clickables.add(new Button(50, 50, 50, 10, "test", null));
		}
	}
	
	public static List<Clickable> getClickables(){
		return clickables;
		
	}

}
