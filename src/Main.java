/*
 * Author:                 Sujan Rokad
 * Authorship statement:   I, Sujan Rokad, 000882948, certify that this material is my original work.
 *                         No other person's work has been used without due acknowledgement.
 * Purpose:                A program that allows the user to create a DiceCollection,
 *                         roll the dice, and display results or histograms based on user choices.
 */

import java.util.Scanner;

/**
 * The Main class provides a user interface to create and interact with DiceCollection objects.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for the number of dice and their number of sides
        System.out.print("How many dice do you want? ");
        int num_Of_Dice = input.nextInt();

        int[] sides = new int[num_Of_Dice]; // Defining an Array to save the user-entered input

        // For loop to allow the user to enter the number of sides
        for (int i = 0; i < num_Of_Dice; i++) {
            System.out.printf("Enter the number of sides for dice %d: ", i + 1);
            sides[i] = input.nextInt();
            if (sides[i] < 1) {
                System.out.println("Error: the number of sides must be greater than 0");
                i--;
            }
        }

        // Creates a DiceCollection object using input
        DiceCollection diceCollection = new DiceCollection(sides);
        System.out.println(" ");
        System.out.println(diceCollection); // Prints DiceCollection

        // Present the user with three options: roll once, roll 100000 times, and quit
        boolean finish = false;
        while (!finish) {
            System.out.print("Choose any option from below \n1: Roll once, 2: Roll 100000 times, 3: Quit ");
            int options = input.nextInt();

            switch (options) {
                case 1: // Roll the dice once and print the result
                    diceCollection.rollDice();
                    System.out.println(diceCollection);
                    break;
                case 2: // Roll the dice 100000 times and print a histogram
                    int[] histogram = diceCollection.histogram(100000);
                    for (int i = 0; i < histogram.length; i++) {
                        if (histogram[i] != 0) {
                            System.out.printf("%2d: %2d%n", i, histogram[i]);
                        }
                    }
                    break;
                case 3: // Exits the loop
                    finish = true;
                    break;
                default:
                    System.out.println("Mmm, invalid choice, Try again!! ");
                    break;
            }
        }
        System.out.println("Ciao!! ");
    }
}
