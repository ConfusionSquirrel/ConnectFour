package scott.emmett;

public class Tile {

	private int state;
	public Tile(){
		state = 0;
	}
	
	public void fillTile(){
		state = Driver.getWhoseTurn();	
	}
	
	public void wipe(){
		state = 0;
	}

	public int getState(){
		return state;
	}
	
}
