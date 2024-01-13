/*
 * Author:                 Sujan Rokad
 * Authorship statement:   I, Sujan Rokad, 000882948, certify that this material is my original work.
 *                         No other person's work has been used without due acknowledgement.
 * Purpose:                Define a DiceCollection class to represent a collection of dice and perform various operations.
 */

import java.util.Arrays;

import static java.util.Arrays.fill;

/**
 * The DiceCollection class represents a collection of dice and provides methods for rolling them,
 * calculating the minimum, maximum, and current values, and generating a histogram of rolls.
 */
public class DiceCollection {
    private Die[] dice; // An array to save individual die
    private int[] numSides; // An array to save the number of sides each die has
    private int minValue; // The minimum possible value of dice
    private int maxValue; // The maximum possible value of dice
    private int[] histogram; // An array to save the histogram of rolls

    /**
     * Constructs a DiceCollection object with dice of specified numbers of sides.
     *
     * @param numSides An array representing the number of sides for each die in the collection.
     */
    public DiceCollection(int[] numSides) {
        this.numSides = numSides;
        this.dice = new Die[numSides.length];
        for (int i = 0; i < numSides.length; i++) {
            this.dice[i] = new Die(numSides[i]);
        }
        setMinValue();
        setMaxValue();
    }

    /**
     * Sets the minimum possible value that can be rolled by the dice.
     */
    public void setMinValue() {
        this.minValue = numSides.length;
    }

    /**
     * Returns the minimum possible value that can be rolled by the dice.
     *
     * @return The minimum possible value.
     */
    public int getMinValue() {
        return minValue;
    }

    /**
     * Sets the maximum possible value that can be rolled by the dice.
     */
    public void setMaxValue() {
        this.maxValue = 0;
        for (int i = 0; i < numSides.length; i++) {
            this.maxValue += numSides[i];
        }
    }

    /**
     * Returns the maximum possible value that can be rolled by the dice.
     *
     * @return The maximum possible value.
     */
    public int getMaxValue() {
        return this.maxValue;
    }

    /**
     * Returns the current value of the dice, which is the sum of the value of each die.
     *
     * @return The current value of the dice.
     */
    public int getCurrentValue() {
        int sumOfSides = 0;
        for (Die die : dice) {
            sumOfSides += die.getCurrentSide();
        }
        return sumOfSides;
    }

    /**
     * Rolls all the dice in the collection.
     */
    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }

    /**
     * Generates a histogram of rolls by rolling the dice a given number of times.
     *
     * @param totalRolls The total number of rolls to generate the histogram.
     * @return An array representing the histogram of rolls.
     */
    public int[] histogram(int totalRolls) {
        int[] rolls = new int[totalRolls];
        for (int i = 0; i < totalRolls; i++) {
            rollDice();
            rolls[getCurrentValue()]++;
        }
        return rolls;
    }

    /**
     * Returns a string representation of the dice collection, including the values of each die,
     * the minimum, maximum, and current values.
     *
     * @return A string representation of the dice collection.
     */
    @Override
    public String toString() {
        String result = "Dice Collection: ";
        for (Die die : dice) {
            result += die.toString() + " ";
        }
        result += "\nMin = " + getMinValue() + " | ";
        result += "Max = " + getMaxValue() + " | ";
        result += "Current = " + getCurrentValue() + "\n";
        return result;
    }
}
