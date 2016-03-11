package scott.emmett;

import java.util.Scanner;

public class Input {

	private static Scanner in = new Scanner(System.in);
	
	public static String promptInput(String prompt){
		System.out.println(prompt);
		return nextInput();
	}
	public static String nextInput(){
		return in.nextLine();
	}

	
	
	
}
