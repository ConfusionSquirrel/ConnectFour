package scott.emmett;

import java.util.ArrayList;

public class Grid {

	private ArrayList<ArrayList<Tile>> columns = new ArrayList<>();
	
	public Grid(){
		generateGrid();
	}
	
	private void generateGrid(){
		for(int i = 0; i < 7; i++){
			ArrayList<Tile> column = new ArrayList<>();
			for(int j = 0; j < 6; j++){
				column.add(new Tile());
			}
			columns.add(column);
		}
	}
	
	public Tile firstOpen(int column){
		ArrayList<Tile> thisColumn = new ArrayList<>();
		thisColumn = columns.get(column);
		for(int i = 0; i < 6; i++){
			if(thisColumn.get(i).getState() == 0){
				return thisColumn.get(i);
			}
		}
		return null;
	}
	
	
	//Temp text-based

	public void printBoard(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				System.out.print(columns.get(j).get(i).getChar());
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
