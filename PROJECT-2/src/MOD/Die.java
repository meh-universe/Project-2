package MOD;

import java.util.Random;

public class Die {
    // INSTANCE VARIABLE
    private int value;
    private Random rand;

    // CONSTRUCTOR
    public Die() {
        value = 0;
        rand = new Random();
    }

    // ACCESSOR METHOD
    public int get() {
        return value;
    }

    /**
     * This method gives the die a random value between 1 through 6
     */
    public void roll() {
        value = 1 + (int)(Math.random() * 6);
    }
}