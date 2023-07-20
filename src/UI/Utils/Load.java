package UI.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import GameModel.Model;


public class Load {
	
	public Load(Model m) throws FileNotFoundException {
		
		File file = new File("src/Resources/GameState/gamestate.txt");
		
		try (Scanner reader = new Scanner(file)) {
			
			if (!m.isTurnPlayer0() == reader.nextBoolean()) {
				m.changeTurn();
			}
			
			if (!m.hasBig0() == reader.nextBoolean()) {
				m.changeBig0();
			}
			
			if (!m.hasBig6() == reader.nextBoolean()) {
				m.changeBig6();
			}
			
			int[] CellGems = new int[12];
			for (int i = 0; i < 12; i++) {
				CellGems[i] = reader.nextInt();
			}
			m.set(CellGems);
			
			m.setScore0(reader.nextInt());
			m.setScore1(reader.nextInt());
			
		}
	}
	
	
	

}