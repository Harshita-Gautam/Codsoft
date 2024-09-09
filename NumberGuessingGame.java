import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(int rangeStart, int rangeEnd, int maxAttempts) {
            Random random = new Random();
            int targetNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            Scanner scanner = new Scanner(System.in);
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("Guess a number between " + rangeStart + " and " + rangeEnd);

            while (attempts < maxAttempts && !isCorrect) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("\nCorrect! You've guessed the number in " + attempts + " attempts.");
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber);
            }
        }

        public static void startGame() {
            Scanner scanner = new Scanner(System.in);
            int rangeStart = 1;
            int rangeEnd = 100;
            int maxAttempts = 7;
            int roundsWon = 0;
            int totalRounds = 0;

            boolean playAgain = true;
            while (playAgain) {
                totalRounds++;
                main(rangeStart, rangeEnd, maxAttempts);

                System.out.print("Do you want to play again? (yes/no): ");
                String response = scanner.next().toLowerCase();
                playAgain = response.equals("yes");

                if (response.equals("yes")) {
                    roundsWon++;
                }
            }

            System.out.println("Game Over! You played " + totalRounds + " rounds and won " + roundsWon + " rounds.");
        }

        public static void main(String[] args) {
            System.out.println("Welcome to the Number Guessing Game!");
            startGame();
        }
    }

