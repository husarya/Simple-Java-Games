package pl.coderslab.konserwatywnyliberal;

import java.util.Scanner;

public class Computer_Guess_Game {


	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		
		Integer number = 500;
		Integer min = 1;
		Integer max = 1000;
		Integer counter = 1;
		
		String input = "";
		String bigger = "more";
		String smaller = "less";
		String luckyStrike = "bingo";
		
		System.out.println("Think about a number from 1 - 1000 range. Computer will try to guess it in 10 attempts");
		System.out.println("Cheating will make computer cry");
		System.out.println("========================================================================================");

		while (true) {
			
			System.out.println("Attempt " + counter);
			System.out.println("Computer says your imagined number is " + number + " ?");
			System.out.println("Type: | more | less | bingo |");
			System.out.println("=======================================================");
			
			input = scan.next();
			System.out.println("");
			
			if (input.equals(bigger)) {
				counter++;
				min = number;
				number = (number + max) / 2;
				
			}else if (input.equals(smaller)) {
				counter++;
				max = number;
				number = (min + number) / 2;
				
			}else if (input.equals(luckyStrike)) {
				System.out.println("Computer guessed in " + counter + " attempts");
				System.out.println("");
				System.exit(0);
				scan.close();
					
			}else {
				System.out.println("Invalid command");
				System.out.println("");
			
			}	
		while (counter > 10) {
			System.out.println("You cheated ! You made computer cry :'(");
			System.out.println("");
			scan.close();
			System.exit(0);
		}
		}
		
	}
}
