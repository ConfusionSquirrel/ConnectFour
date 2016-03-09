package scott.emmett;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Grid grid = new Grid();
		
		takeInput(grid);
	}
	
	//for testing
	private static void takeInput(Grid grid){
		System.out.println("Enter \"print\" to print the grid");
		String input = Input.humanInput();
		if(input.equals("print")){
			grid.printBoard();
		}
	}

}
