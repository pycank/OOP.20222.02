package GameModel;

import java.util.Arrays;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Model{

	private boolean turnPlayer0 = true;
	
	private BooleanProperty end = new SimpleBooleanProperty(false);

	private boolean big0 = true;
	private boolean big6 = true;
	
	private final String[] cellID = new String[] {"00", "01", "02", "03", "04", "05", "66", "15", "14", "13", "12", "11"};
	private int[] cellGems = new int[] {1, 5, 5, 5, 5, 5, 1, 5, 5, 5, 5, 5};
	
	private IntegerProperty Player0 = new SimpleIntegerProperty(0);
	private IntegerProperty Player1 = new SimpleIntegerProperty(0);
	
	public boolean isTurnPlayer0() {
		return turnPlayer0;
	}
	
	public void changeTurn() {
		this.turnPlayer0 = !turnPlayer0;
	}
	
	public BooleanProperty getEnd() {
		return end;
	}
	
	public void Ended() {
		this.end.set(true);
	}
	
	public boolean hasBig0() {
		return big0;
	}
	
	public void changeBig0() {
		big0 = !big0;
	}
	
	public boolean hasBig6() {
		return big6;
	}
	
	public void changeBig6() {
		big6 = !big6;
	}
	
	public String[] getCellID() {
		return cellID;
	}
	
	public int[] getCellIGems() {
		return cellGems;
	}
	
	public void add(String id) {
		int index = Arrays.asList(cellID).indexOf(id);
		
		cellGems[index] = cellGems[index] + 1;
	}
	
	public void rmv(String id) {
		int index = Arrays.asList(cellID).indexOf(id);
		
		cellGems[index] = 0;
	}
	
	public void set(int[] cellGems) {
		this.cellGems = cellGems;
	}
	
	public void addScores(boolean side0, int i) {
		if (side0) {
			Player0.set(Player0.intValue() + i);
		}
		else {
			Player1.set(Player1.intValue() + i);
		}
	}
	
	public IntegerProperty getScore0() {
		return Player0;
	}
	
	public IntegerProperty getScore1() {
		return Player1;
	}
	
	public void setScore0(int i) {
		Player0.set(i);
	}
	
	public void setScore1(int i) {
		Player1.set(i);
	}
}

