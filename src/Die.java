/*
 * Author:                 Sujan Rokad
 * Authorship statement:   I, Sujan Rokad, 000882948, certify that this material is my original work.
 *                         No other person's work has been used without due acknowledgement.
 * Purpose:                Define a Die class to represent a six-sided die and its operations.
 */

import java.util.Random;

/**
 * The Die class represents a six-sided die and provides methods for rolling it,
 * getting the number of sides, and getting the current side.
 */
public class Die {
    private int numSides; // Number of sides of the die
    private int currentSide; // Current side of the die

    /**
     * Constructs a new Die object with the given number of sides and rolls it.
     *
     * @param numSides The number of sides for the die.
     */
    public Die(int numSides) {
        this.numSides = numSides;
        this.roll(); // Set the current side to a random value between 1 and numSides
    }

    /**
     * Returns the number of sides of the die.
     *
     * @return The number of sides.
     */
    public int getNumSides() {
        return numSides;
    }

    /**
     * Returns the current side that the die is showing.
     *
     * @return The current side.
     */
    public int getCurrentSide() {
        return currentSide;
    }

    /**
     * Rolls the die by generating a random number between 1 and numSides and sets the current side to that number.
     */
    public void roll() {
        Random rand = new Random();
        currentSide = rand.nextInt(numSides) + 1;
    }

    /**
     * Returns a string representation of the die in the format of dX=Y where X is numSides and Y is currentSide.
     *
     * @return A string representation of the die.
     */
    @Override
    public String toString() {
        return "d" + numSides + "=" + currentSide + " |";
    }
}
