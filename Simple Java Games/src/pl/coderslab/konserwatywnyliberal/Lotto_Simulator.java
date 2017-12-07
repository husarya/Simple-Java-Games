package pl.coderslab.konserwatywnyliberal;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lotto_Simulator {

	private static Scanner scan;

	public static void main (String[] args) {

		Integer[] arr = new Integer[49];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		Collections.shuffle(Arrays.asList(arr));
		
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
	 		lotto[i] = arr[i];
		}
		
		scan = new Scanner(System.in);
		
		int[] coupon = new int[6];
		System.out.println("Enter 6 numbers from 1 - 49, for a chance to become milionare !");
		try {
		for (int i = 0; i < coupon.length; i++) {
			System.out.println("Pick " + (i+1) + " number");
			
			int pickedNumber = scan.nextInt();
			
			while (pickedNumber < 1 || pickedNumber > 49) {
					System.out.println("You must pick numbers from 1 - 49 !");
					pickedNumber = scan.nextInt();
			}
			
			int again = 0;
			for (int j = 0; j < lotto.length; j++) {
				if (pickedNumber == coupon[j]) {
					again++;
		    }			
        }
			
			while(again > 0) {
				again = 0;
				System.out.println("You have picked that number earlier, pick diffrent number");
				pickedNumber = scan.nextInt();
				for(int z = 0; z < lotto.length; z++) {
					if(coupon[z] == pickedNumber) {
						again++;
					}
				}
			}
			coupon[i] = pickedNumber;
			
		}
		
		int hits = 0;
		
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < lotto.length; j++) {
				if (coupon[j] == lotto[i]) {
					hits++;
				}
			}
		}
		Arrays.sort(lotto);
		Arrays.sort(coupon);
		System.out.println("Your selected numbers: " + Arrays.toString(coupon));
		System.out.println("Numbers drawed by Lotto machine are: " + Arrays.toString(lotto));
		
		if (hits == 0 || hits == 1 || hits == 2) {
			System.out.println("You won nothing");
		}else if (hits == 3) {
			System.out.println("Congratulation, you have guessed 3 numbers. You won 10$");
		}else if (hits == 4) {
			System.out.println("Well played, you have guessed 4 numbers. You won 100$");
		}else if (hits == 5) {
			System.out.println("Excellent, you have guessed 5 numbers, so close, atleast you won 1000$");
		}else if (hits == 6) {
			System.out.println("***** You have just become a milionare ! *****");
		}else {
			System.out.println("=== System ERROR ===");
		}
		}catch (InputMismatchException|NumberFormatException e){
			System.out.println("Only numbers from 1 - 49 idiot !");
		}
	}
}