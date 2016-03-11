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
	//Prints the grid
	public void move(int playerNum){
		boolean goodInput = false;
		String input = "";
		int inputCol = 8;
		while(!goodInput){
			input = Input.promptInput("Which column would you like to place your piece in? (1-7):");
			try{
				inputCol = Integer.valueOf(input) - 1;
			}catch(Exception e){}
			if(inputCol < 8 && inputCol >= 0){
				if(firstOpen(inputCol) != 8){
					goodInput = true;
				}
			}
		}
		int row = firstOpen(inputCol);
		String playerColour;
		if(playerNum == 1){
			playerColour = "Red";
		}
		else{
			playerColour = "Yellow";
		}
		columns.get(inputCol-1).get(row).setTile(playerColour);
		printBoard();
	}
	
	//Alternate; works if you have pre-checked column and row
	public void move(int playerNum, int column, int row){
		String playerColour;
		if(playerNum == 1){
			playerColour = "Red";
		}
		else{
			playerColour = "Yellow";
		}
		columns.get(column).get(row).setTile(playerColour);
		printBoard();
	}
	
	//Temp text-based

	//prints board to screen
	public void printBoard(){
		for(int i = 5; i >= 0; i--){
			for(int j = 0; j < 7; j++){
				System.out.print(columns.get(j).get(i).getChar() + " ");
			}
			System.out.println("");
		}
	}
}
