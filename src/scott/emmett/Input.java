package scott.emmett;

import java.util.Scanner;

public class Input {

	private static Scanner in = new Scanner(System.in);
	
	public static String promptInput(String prompt){
		System.out.println(prompt);
		return in.nextLine();
	}
	public static String nextInput(){
		return in.nextLine();
	}
	public static int moveInput(){
		String s = promptInput("Please enter the number of a column (1-7):");
		int i = 8;
		try{
			i = Integer.valueOf(s);
		}catch(Exception e){
			
		}
		return i;
	}
	
	
	
}
