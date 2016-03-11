package scott.emmett;

public class Tile {

	private int state;
	private char symbol; //Temp, for text-based
	public Tile(){
		state = 0;
		refreshSymbol();
	}
	
	public void setTile(String s){
		if(s.equals("Red")){
			state = 1;
		}
		else if(s.equals("Yellow")){
			state = 2;
		}
		refreshSymbol();
		
	}
	private void refreshSymbol(){
		if(state == 0){
			symbol = '_';
		}
		else if(state == 1){
			symbol = 'O';
		}
		else{
			symbol = 'X';
		}
	}

	public int getState(){
		return state;
	}
	public char getChar(){
		return symbol;
	}
	
}
