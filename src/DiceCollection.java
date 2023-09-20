//@Sujan Rokad, 000882948
import java.util.Arrays;

import static java.util.Arrays.fill;

public class DiceCollection {
    private Die[] dice; //an array to save individual die
    private int[] numSides; //an array to save number of sides each die has
    private int minValue; //the minimum possible value of dice
    private int maxValue; //the maximum possible value of dice
    private int[] histogram; //an array to save histogram rolls

    //constructor that creates a DiceCollection object
    public DiceCollection(int[] numSides){
        this.numSides = numSides;
        this.dice = new Die[numSides.length];
        for(int i = 0; i< numSides.length; i++){
            this.dice[i] = new Die(numSides[i]);
        }
        setMinValue();
        setMaxValue();
    }

    //sets minimum possible value that can be rolled by dice
    public void setMinValue() {
        this.minValue = numSides.length;
    }

    //returns minimum possible value that can be rolled by dice
    public int getMinValue() {
        return minValue;
    }

    //sets maximum possible value that can be rolled by dice
    public void setMaxValue() {
        this.maxValue = 0;
        for(int i = 0; i< numSides.length; i++){
            this.maxValue+=numSides[i];
        }
    }

    //returns maximum possible value that can be rolled by dice
    public int getMaxValue() {
        return this.maxValue;
    }

    //returns the current value of dice which is the sum of the value of each die
    public int getCurrentValue() {
        int sumOfSides = 0;
        for (Die die: dice) {
            sumOfSides += die.getCurrentSide();
        }
        return sumOfSides;
    }

    //roll all the dice
    public void rollDice(){
        for (Die die: dice) {
            die.roll();
        }
    }

    //generates histogram of rolls by rolling the dice given number of times
    public int[] histogram ( int total_Rolls){
        int[] rolls = new int[total_Rolls];
        for (int i = 0; i < total_Rolls; i++) {
            rollDice();
            rolls[getCurrentValue()]++;
        }
        return rolls;
    }

    //returns a string representation of the dice collection with showing the values of each die as well as the
    // minimum, maximum and current values.
    @Override
    public String toString() {
        String result = "Dice Collection: ";
        for (Die die: dice) {
            result += die.toString() + " ";
        }
        result += "\nMin = " + getMinValue() + " | ";
        result += "Max = " + getMaxValue() + " | ";
        result += "Current = " + getCurrentValue() + "\n";
        return result;
    }
}
