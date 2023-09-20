//@Sujan Rokad, 000882948
import java.util.Random;


    public class Die {
        private int numSides; //number of sides of the die
        private int currentSide; //current side of the die

        //Constructor for creating a new die with the given number of sides
        public Die(int numSides) {
            this.numSides = numSides;
            this.roll(); //set the current side to a random value between 1 and numSides
        }

        //returns the number of sides
        public int getNumSides() {
            return numSides;
        }

        //returns the current side that die is showing
        public int getCurrentSide() {
            return currentSide;
        }

        //rolls the die by generating a random number between 1 and numSides and sets the current side to that number
        public void roll() {
            Random rand = new Random();
            currentSide = rand.nextInt(numSides) + 1;
        }

        //returns string representation in the format of dX=Y where x is numSides and Y is currentSide
        @Override
        public String toString() {
            return "d" + numSides + "=" + currentSide + " |";
        }
    }

