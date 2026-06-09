package lab.lab5;

import java.util.Random;
import java.util.Scanner;

public class Lab5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int number = 0; 
		int randomNumber = random.nextInt(100) + 1; 
		boolean flag = true;
		int numTries = 0;
		
		while (flag) {
			System.out.println("Please enter a number from 0 to 100 (-1 to exit):");
			number = scanner.nextInt(); 
			if (number == -1) {
				flag = false;
			} else if (number < 0 || number > 100) {
				System.out.println("Please enter a number from 0 to 100");
			} else {
				number++;
				if (number > randomNumber) {
					System.out.println("Please enter a smaller number");
				} else if (number < randomNumber) {
					System.out.println("Please enter a bigger number");
				} else {
					flag = false;
                    System.out.println("Congratulations! You've found the number " + number + " in " + numTries + " tries.");
				}
			}
		}

		System.out.println("Exiting program...");
		scanner.close();
	}

}
