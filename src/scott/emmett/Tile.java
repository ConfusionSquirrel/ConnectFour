package scott.emmett;

public class Tile {

	private int state;
	public Tile(){
		state = 0;
	}
	
	public void setTile(String s){
		if(s.equals("Red")){
			state = 1;
		}
		else if(s.equals("Blue")){
			state = 2;
		}
		
	}
	public int getState(){
		return state;
	}
	
}
