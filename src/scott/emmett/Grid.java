package scott.emmett;

import java.util.ArrayList;

public class Grid {

	private ArrayList<ArrayList<Tile>> columns = new ArrayList<>();
	
	
	public Grid(){
		generateGrid();
	}
	
	//fills the columns arraylist
	private void generateGrid(){
		for(int i = 0; i < 7; i++){
			ArrayList<Tile> column = new ArrayList<>();
			for(int j = 0; j < 6; j++){
				column.add(new Tile());
			}
			columns.add(column);
		}
	}
	
	//Returns the row number of the first open row in a column. Returns 8 if the column is full
	public int firstOpen(int column){
		ArrayList<Tile> thisColumn = new ArrayList<>();
		thisColumn = columns.get(column);
		for(int i = 0; i < 6; i++){
			if(thisColumn.get(i).getState() == 0){
				return i;
			}
		}
		return 8;
	}
	
	//Beginning of turn processing. Takes input for which column to play a piece in, and keeps
		//asking until input is valid
	//Sets the first open space in selected column to the symbol of the specified player
		//"red" (O) for player 1, "yellow" (X) for player 2
	
	public void turn(GUI face){
		face.togglePlayerLabelHighlight();
		if(Driver.getPlayers() == 1 && Driver.getWhoseTurn() == 2){
			
		}
		else{
			Driver.setTimeToClick(true);
			System.out.println("okay we got this far");
			while(Driver.isTimeToClick()){
				try {
				    Thread.sleep(100);
				}catch(Exception e){}
			}
		}
	}
	public void drop(int col){
		if(firstOpen(col) != 8){
			int row = firstOpen(col);
			columns.get(col).get(row).fillTile();
			int[] coord = {col,row};
			Driver.face.fillSpot(coord);
			Driver.setTimeToClick(false);
			
			if(isTie()){
				Driver.setGameover(true);
			}
			else if(isWin(coord)){
				Driver.setGameover(true, Driver.getWhoseTurn());
			}
		}
	}
	private boolean isTie(){
		boolean allFull = true;
		for(int i = 0; i < 7; i++){
			if(firstOpen(i) != 8) allFull = false;
		}
		return allFull;
	}
	private boolean isWin(int[] coord){		
		int[] xMods = {0,1,1,1,0,(Integer)(-1),(Integer)(-1),(Integer)(-1)};
		int[] yMods = {1,1,0,(Integer)(-1),(Integer)(-1),(Integer)(-1),0,1};
		int[] totals = new int[8];
		int curTarget = Driver.getWhoseTurn();
		for(int i = 0; i < 8; i++){
			int curX = coord[0];
			int curY = coord[1];
			int total = 0;
			boolean lineStop = false;
			for(int j = 0; j < 3; j++){
				if(!lineStop){
					curX += xMods[i];
					curY += yMods[i];
					try{
						if(columns.get(curX).get(curY).getState() == curTarget){
							total += 1;
						}
						else{
							lineStop = true;
						}
					}catch(Exception e){}
				}
			}
			totals[i%4] += total;
		}
		for(int i : totals){
			if(i >= 3){
				return true;
			}	
		}
		return false;
	}

	public void wipe(){
		for(ArrayList<Tile> a : columns){
			for(Tile t : a){
				t.wipe();
			}
		}
	}
}
