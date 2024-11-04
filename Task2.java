
import java.util.Random;
import java.util.Scanner;

public class Task2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Generate a random number between 1 and 100
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfAttempts = 0;
        int userGuess = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        // Loop until the user guesses the correct number
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Your guess is too low. Try again!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Your guess is too high. Try again!");
            } else {
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly!");
            }
        }

        // Display the number of attempts it took to guess the number
        System.out.println("It took you " + numberOfAttempts + " attempts to guess the number.");
        
        scanner.close();
    }
}