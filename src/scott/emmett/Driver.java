package scott.emmett;

import java.util.Scanner;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		
		
		
		int turn = 2;
		Boolean ai = false;
		Boolean gameEnd = false;
		int aiColumn = 0;
		
		
		System.out.println("Welcome to Craptacular Connect 4.");
		System.out.println("Do you want AI? true/false");
		
		
		ai = in.nextBoolean();
		
		System.out.println("AI is " + ai);
		
		while(gameEnd == false){
			
			Grid grid = new Grid();
			takeInput(grid);
			
			if ((turn == 1)&&(ai == false)){
				turn = 2;
			}
			else if (turn == 2){
				turn = 1;
			}
			else{
				Random rand = new Random();
				aiColumn = 1 + (int)(Math.random() * ((7 - 1) + 1));
				turn = 3;
			}
			if (turn < 3){
				System.out.println("Player " + turn + "'s turn!");
				Input.promptInput("Which column do you want to go in?");
			}
			else{
				System.out.println("AI's turn! [^+^] ");
				System.out.println("The AI went in column " + aiColumn);
			}
			
		}
		
	}
	
	
	
	//for testing
	private static void takeInput(Grid grid){
		System.out.println("Enter \"print\" to print the grid");
		String input = Input.nextInput();
		if(input.equals("print")){
			grid.printBoard();
		}
		else if(input.equals("move")){
			grid.move(1);
		}
	}

}
