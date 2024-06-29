package Project;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalScore = 0;
        int numberOfRounds = 3; // Number of rounds
        int maxAttempts = 5;    // Max attempts per round

        System.out.println("Welcome to Guess the Number Game!");

        for (int round = 1; round <= numberOfRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + round + " of " + numberOfRounds);
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    int points = maxAttempts - attempts + 1; // Points based on remaining attempts
                    totalScore += points;
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts. You earned " + points + " points.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is lower than the number.");
                } else {
                    System.out.println("Your guess is higher than the number.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        scanner.close();
    }
}


