package pl.coderslab.konserwatywnyliberal;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Guess_A_Number_Game {

	private static Scanner scan;

	public static void main(String[] args) {

		Random rand = new Random();

		while (true) {
			try {

				scan = new Scanner(System.in);
				System.out.println("Input number between 1 - 100: ");

				String input = "";
				input = scan.nextLine();
				int finalInput = Integer.parseInt(input);
				int randomedNumber = rand.nextInt(100) + 1;

				if (finalInput < 1 || finalInput > 100) {
					System.out.println("Pick a number beetwen 1 and 100 idiot...");
				}
				if (finalInput > randomedNumber) {
					System.out.println("Pick smaller number ! ");

				}else if (finalInput < randomedNumber) {
					System.out.println("Pick bigger number !");

				}else {
					scan.close();
					System.out.println(" !!!!! You won !!!!!");
					break;

				}
		    }catch (NumberFormatException e) {
				System.out.println("That's not a number idiot !");

			} 

		}

	}

}
