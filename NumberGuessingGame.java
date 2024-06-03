package com.pkg1;

import java.util.*;

/*
 TASK 1

QUESTION: (NUMBER GAME) GENERATE A RANDOM NUMBER. 
ASK THE USER TO GUESS A NUMBER BETWEEN
1 TO 100 AND COMPARE THE NUMBER WITH THE RANDOM NUMBER GENERATED, 
PROVIDE FEEDBACK ON WHETHER THE GUESS MADE IS CORRECT OR NOT.

*/

public class NumberGuessingGame  {

	int roundsPlayed, roundsWon;
	int maxAttempts;

	Scanner sc;

	NumberGuessingGame () {
		roundsPlayed = 1;
		roundsWon = 0;
		maxAttempts = 5;
		sc = new Scanner(System.in);
	}

	// Function to take a number guessed by the player/user as input
	int getInputNumber() {
		System.out.println("Guess a number:");
		return sc.nextInt();
	}

	// Function to generate a random number
	int getRandomNumber() {
		return (int) (Math.random() * 100);
	}

	/*
	 * Function which provides appropriate feedback on the guessed number after
	 * comparing it with the random number
	 */

	void play() {
		int userInputNumber, randomNumber;
		int currentAttempt = 1;
		String tryAgainOption;

		randomNumber = getRandomNumber();
		System.out.println("Please guess a number between 1 to 100");
		

		do {
			
			userInputNumber = getInputNumber();

			if (userInputNumber > randomNumber) {
				System.out.println("Too high!\n");
				currentAttempt++;
			} else if (userInputNumber < randomNumber) {
				System.out.println("Too low! \n");
				currentAttempt++;
			} else if (userInputNumber == randomNumber) {
				System.out.println("Congrats! You guessed the correct number. \n");
				roundsWon++;
				displayScore();
				System.out.println(" To play another round please enter 1 and to exit enter 0.");
				int choice = sc.nextInt();
				if (choice == 1) {
					currentAttempt = 1;
					roundsPlayed++;
					displayMaxAttempts();

					play();
				} else {
					return;
				}
			}

		} while ((userInputNumber != randomNumber) && (currentAttempt <= maxAttempts));

		// when user lost the game
		
		if (currentAttempt > maxAttempts) {
			displayScore();
			System.out.println("You lost the game!!!");
			System.out.println("To play another round please enter : TRY AGAIN");
			sc.nextLine();
			tryAgainOption = sc.nextLine();

			if (tryAgainOption.equalsIgnoreCase("TRY AGAIN")) {
				currentAttempt = 1;
				roundsPlayed++;
				displayMaxAttempts();
				play();
			}
		}

	}

	public void displayScore() {
		System.out.println("CURRENT SCORE \n Total Rounds played : " + roundsPlayed + "\n Rounds Won : " + roundsWon);
	}

	public void displayMaxAttempts() {
		System.out.println("You have " + maxAttempts + " attempts to guess your number.");
	}

	public static void main(String[] args) {

		NumberGuessingGame  game = new NumberGuessingGame ();
		game.displayMaxAttempts();
		game.play();
		System.out.println("Game Completed");

	}

}