import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int roundsWon = 0;

            System.out.print("Do you want to play a round? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing!");
                break;
            }

            while (true) {
                System.out.print("Guess the number (1-100): ");

                int userGuess;
                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                    roundsWon++;
                    break;
                }

                if (attempts >= 10) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
                    break;
                }
            }

            System.out.println("Rounds won: " + roundsWon);
        }

        scanner.close();
    }
}
