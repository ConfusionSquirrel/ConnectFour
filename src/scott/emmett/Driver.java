package scott.emmett;

import javax.swing.JOptionPane;

public class Driver {

	private static int players;
	private static int playersTurn;
	private static int winner;
	
	private static boolean timeToClick;
	private static boolean gameover;
	private static boolean replay;
	
	public static GUI face;
	private static Grid grid;
	
	public static void main(String[] args) {
		grid = new Grid();
		face = new GUI(grid);
		setPlayers(2);
		startGame(face);
		
	}
	
	private static void startGame(GUI face){
		playersTurn = 2;
		replay = false;
		gameover = false;
		timeToClick = false;
		winner = 5;
		grid.wipe();
		face.wipe();
		while(!gameover){
			if(playersTurn == 1) playersTurn = 2;
			else playersTurn = 1;
			System.out.println("Turn");
			grid.turn(face);
		}
		System.out.println("Game finished");//TEST
		if(winner == 5){
		}
		else if(winner == 3){
			JOptionPane.showMessageDialog(face.getFrame(),
				    "You have tied! Better luck next time!",
				    "",
				    JOptionPane.PLAIN_MESSAGE);
		}
		else if(winner == 2 && players == 2){
			JOptionPane.showMessageDialog(face.getFrame(),
				    "Player 2 wins!",
				    "",
				    JOptionPane.PLAIN_MESSAGE);
		}
		else if(winner == 2){
			JOptionPane.showMessageDialog(face.getFrame(),
				    "Uh oh, the computer wins. Better luck next time!",
				    "",
				    JOptionPane.PLAIN_MESSAGE);
		}
		else if(winner == 1){
			JOptionPane.showMessageDialog(face.getFrame(),
				    "Player 1 wins!",
				    "",
				    JOptionPane.PLAIN_MESSAGE);
		}
		while(!replay){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		startGame(face);
	}

	public static void setPlayers(int num){
		players = num;
	}
	public static void setTimeToClick(boolean b){
		timeToClick = b;
	}
	public static void setGameover(boolean b){
		gameover = b;
		winner = 3;
	}
	public static void setGameover(boolean b, int winPlayer){
		gameover = b;
		winner = winPlayer;
	}
	public static void replay(){
		if(gameover == false){
			gameover = true;
			timeToClick = false;
			replay = true;
		}
		else{
			replay = true;
		}
	}
	public static void setWhoseTurn(int num){
		playersTurn = num;
	}
	
	public static int getPlayers(){
		return players;
	}
	public static int getWhoseTurn(){
		return playersTurn;
	}
	public static boolean isTimeToClick(){
		return timeToClick;
	}
}
