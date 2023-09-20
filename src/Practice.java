// Sujan Rokad, 000882948, Mohawk College
// Source: Discrete Mathematics for Computer Science
//
//import javax.swing.*;
//import java.util.Scanner;
//
//public class Practice {
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int type;
//        while (true){
//            type = Integer.parseInt(JOptionPane.showInputDialog("Choose the poker type you want to count: \n(1) pair, (2) 2 pair, (3) 3-of-a-kind, (4) 4-of-a-kind or (5) QUIT: "));
//            int count = 0;
//            switch (type) {
//                case 1:
//                    count = countPairs();
//                    break;
//                case 2:
//                    count = countTwoPairs();
//                    break;
//                case 3:
//                    count = countThreeOfAKind();
//                    break;
//                case 4:
//                    count = countFourOfAKind();
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Invalid input. Please enter one of the following: (1) pair, (2) 2 pair, (3) 3-of-a-kind, (4) 4-of-a-kind or (5) QUIT: ");
//                    return;
//            }
//            System.out.println("The number of different ways to get a " + type + " is: " + count);
//        }
//
//    }
//
//    public static int countPairs() {
//        int count = 0;
//        for (int i = 1; i <= 13; i++) {
//            count += choose(4, 2) * choose(48, 3);
//        }
//        return count;
//    }
//
//    public static int countTwoPairs() {
//        int count = 0;
//        for (int i = 1; i <= 13; i++) {
//            for (int j = i + 1; j <= 13; j++) {
//                count += choose(4, 2) * choose(4, 2) * choose(44, 1);
//            }
//        }
//        return count;
//    }
//
//    public static int countThreeOfAKind() {
//        int count = 0;
//        for (int i = 1; i <= 13; i++) {
//            count += choose(4, 3) * choose(48, 2);
//        }
//        return count;
//    }
//
//    public static int countFourOfAKind() {
//        int count = 0;
//        for (int i = 1; i <= 13; i++) {
//            count += choose(4, 4) * choose(48, 1);
//        }
//        return count;
//    }
//
//    public static int choose(int a, int b) {
//        int result = 1;
//        for (int i = 0; i < b; i++) {
//            result *= (a - i);
//            result /= (i + 1);
//        }
//        return result;
//    }
//}

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        // Ask user for the number of dice and the number of sides of each die
//        System.out.print("How many dice? ");
//        int numDice = input.nextInt();
//
//        int[] sides = new int[numDice];
//        System.out.print("Enter the number of sides of each die: ");
//        for (int i = 0; i < numDice; i++) {
//            sides[i] = input.nextInt();
//        }
//
//        // Create the DiceCollection object
//        DiceCollection diceCollection = new DiceCollection(sides);
//
//        // Print the initial state of the DiceCollection object
//        System.out.println(diceCollection);
//
//        // Main loop of the program
//        while (true) {
//            // Ask user for the action to take
//            System.out.print("1=roll once, 2=roll 100000 times, 3=quit: ");
//            int choice = input.nextInt();
//
//            if (choice == 1) {
//                // Roll the dice once
//                diceCollection.rollAll();
//
//                // Print the result of the roll
//                System.out.println(diceCollection);
//            } else if (choice == 2) {
//                // Roll the dice 100000 times and display the histogram
//                int[] histogram = diceCollection.histogram(100000);
//
//                // Print the non-zero elements of the histogram
//                System.out.println();
//                System.out.println("Histogram:");
//                for (int i = 0; i < histogram.length; i++) {
//                    if (histogram[i] != 0) {
//                        System.out.printf("%2d: %5d\n", i, histogram[i]);
//                    }
//                }
//                System.out.println();
//            } else if (choice == 3) {
//                // Quit the program
//                System.out.println("BYE!!!");
//                break;
//            } else {
//                // Invalid choice
//                System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }

 //DieCollection
//    public DiceCollection(int[] numSides) {
//        dice = new Die[numSides.length];
//        for (int i = 0; i < numSides.length; i++) {
//            dice[i] = new Die(numSides[i]);
//        }
//
//        int numPossibleSums = 1;
//        for (int sides : numSides) {
//            numPossibleSums *= sides;
//        }
//        possibleSums = new int[numPossibleSums];
//        for (int i = 0; i < possibleSums.length; i++) {
//            possibleSums[i] = -1;
//        }
//    }
//
//    public int getCurrentSum() {
//        int sum = 0;
//        for (Die die : dice) {
//            sum += die.getCurrentSide();
//        }
//        return sum;
//    }
//
//    public int getMinPossibleSum() {
//        int min = 0;
//        for (int sides : dice) {
//            min += 1;
//        }
//        return min;
//    }
//
//    public int getMaxPossibleSum() {
//        int max = 0;
//        for (int sides : dice) {
//            max += sides;
//        }
//        return max;
//    }
//
//    public void rollAll() {
//        for (Die die : dice) {
//            die.roll();
//        }
//        int sum = getCurrentSum();
//        if (possibleSums[sum - 1] == -1) {
//            possibleSums[sum - 1] = 1;
//        } else {
//            possibleSums[sum - 1]++;
//        }
//    }
//
//    public int[] histogram(int numRolls) {
//        for (int i = 0; i < numRolls; i++) {
//            rollAll();
//        }
//        int[] histogram = new int[possibleSums.length];
//        int j = 0;
//        for (int i = 0; i < possibleSums.length; i++) {
//            if (possibleSums[i] != -1) {
//                histogram[j] = possibleSums[i];
//                j++;
//            }
//        }
//        return histogram;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (Die die : dice) {
//            sb.append(die.toString());
//            sb.append(" ");
//        }
//        sb.append("\nMin=").append(getMinPossibleSum());
//        sb.append(" Max=").append(getMaxPossibleSum());
//        sb.append(" Current=").append(getCurrentSum());
//        return sb.toString();
//    }

//import java.util.Arrays;
//import java.util.Scanner;
//
//class Die {
//    private final int sides;
//    private int currentValue;
//
//    public Die(int sides) {
//        this.sides = sides;
//        this.currentValue = 1;
//    }
//
//    public int getSides() {
//        return sides;
//    }
//
//    public int getCurrentValue() {
//        return currentValue;
//    }
//
//    public void roll() {
//        this.currentValue = (int) (Math.random() * sides) + 1;
//    }
//
//    @Override
//    public String toString() {
//        return "d" + sides + "=" + currentValue;
//    }
//}
//
//class DiceCollection {
//    private final Die[] dice;
//    private final int maxPossibleSum;
//    private final int minPossibleSum;
//
//    public DiceCollection(int[] sides) {
//        this.dice = new Die[sides.length];
//        int minPossibleSum = 0;
//        int maxPossibleSum = 0;
//        for (int i = 0; i < sides.length; i++) {
//            this.dice[i] = new Die(sides[i]);
//            minPossibleSum += 1;
//            maxPossibleSum += sides[i];
//        }
//        this.minPossibleSum = minPossibleSum;
//        this.maxPossibleSum = maxPossibleSum;
//    }
//
//    public int getCurrentSum() {
//        int sum = 0;
//        for (Die die : dice) {
//            sum += die.getCurrentValue();
//        }
//        return sum;
//    }
//
//    public int getMaxPossibleSum() {
//        return maxPossibleSum;
//    }
//
//    public int getMinPossibleSum() {
//        return minPossibleSum;
//    }
//
//    public void rollAllDice() {
//        for (Die die : dice) {
//            die.roll();
//        }
//    }
//
//    public int[] histogram(int numRolls) {
//        int[] counters = new int[getMaxPossibleSum() - getMinPossibleSum() + 1];
//        for (int i = 0; i < numRolls; i++) {
//            rollAllDice();
//            counters[getCurrentSum() - getMinPossibleSum()]++;
//        }
//        return counters;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("Dice Collection: ");
//        for (Die die : dice) {
//            sb.append(die.toString()).append(" ");
//        }
//        sb.append("\nMin=").append(getMinPossibleSum());
//        sb.append(" Max=").append(getMaxPossibleSum());
//        sb.append(" Current=").append(getCurrentSum());
//        return sb.toString();
//    }
//}
//
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Prompt the user for the number of dice
//        System.out.print("How many dice? ");
//        int numDice = scanner.nextInt();
//
//        // Prompt the user for the number of sides of each die
//        int[] sides = new int[numDice];
//        System.out.print("Enter the number of sides of each die: ");
//        for (int i = 0; i < numDice; i++) {
//            sides[i] = scanner.nextInt();
//        }
//
//        // Create a new DiceCollection object
//        DiceCollection diceCollection = new DiceCollection(sides);
//
//        // Print the initial state of the DiceCollection object
//        System.out.println(diceCollection);
//
//        // Start the main loop
//        boolean done = false;
//        while (!done) {
//            // Prompt the user for an action
//            System.out.print("1=roll once, 2=roll 100000 times, 3=quit: ");
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    // Roll the dice once and print the result
//                    diceCollection.rollAllDice();
//                    System.out.println(diceCollection);
//                    break;
//                case 2:
//                    // Roll the dice 100000 times and print the histogram
//                    int[] histogram = diceCollection.histogram(100000);
//                    System.out.println();
//                    System.out.println("Histogram:");
//                    for (int i = 0; i < histogram.length; i++) {
//                        if (histogram[i] != 0) {
//                            System.out.printf("%2d: %5d%n", i, histogram[i]);
//                        }
//                    }
//                    break;
//                case 3:
//                    // Quit the program
//                    done = true;
//                    break;
//                default:
//                    // Invalid choice
//                    System.out.println("Invalid choice. Try again.");
//                    break;
//            }
//        }
//
//        System.out.println("BYE!!!");
//    }
//}

