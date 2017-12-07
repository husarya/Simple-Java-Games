package pl.coderslab.konserwatywnyliberal;

import java.util.Scanner;

public class Computer_Guess_Game {


	private static Scanner scan;

	public static void main(String[] args) {

		System.out.println("Think about a number from 1 - 1000 range. Computer will try to guess it in 10 attempts");
		System.out.println("Cheating will make computer cry");
		
		Integer counter = 1;
		Integer number = 500;
		
		do{
			
			scan = new Scanner(System.in);
				
			Integer min = 1;
			Integer max = 1000;
			
			System.out.println("===========================================================================");
			System.out.println("Attempt " + counter);
			System.out.println("Computer says the number you was thinking about is " + number);
			System.out.println("Is the number: smaller | bigger | or maybe I have guessed in first try :D?");
			
			String more = "bigger";
			String less = "smaller";
			String bingo = "bingo";
			String command = "";
			command = scan.next();
			
			if (command.equals(more)) {
				counter++;
				min = number;
				number = (number + max) / 2;
			}else if (command.equals(less)) {
				counter++;
				max = number;
				number = (min + number) / 2;
			}else if (command.equals(bingo)) {
				System.out.println("Computer guessed your number in attempt nr." + counter);
				break;

			}else {
				System.out.println("=== System ERROR ===");
				System.out.println("Invalid command");
				System.out.println("Valid commands are: bigger | smaller | bingo ");
			}	
		  }while (counter<11); 
			    System.out.println("Well it is not polite to cheat, you made computer cry :( ");
		
	}
}