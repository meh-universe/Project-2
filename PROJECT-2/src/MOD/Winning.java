package MOD;

import javax.swing.*;
import java.util.Arrays;
import VIEW.Window;

public class Winning {
    // INSTANCE VARIABLES
    private int score;
    private int choice;

    // CONSTRUCTOR
    public Winning() {
        score = 0;
    }

    /**
     * This method calculates the points and score of the user depending on user input for what they want to check for.
     * @param aDice an array of Dice values
     * @param wins an array that contains the user's wins
     */
    public void checkWinnings(int[] aDice, int[] wins) {
        Window _w = new Window();
        _w.msg ("Which do you want to see if you have?");

        // OPTIONS TO CHOOSE
        _w.msg(
                // YAHTZEE
                " 1. YAHTZEE"

                        // FULL HOUSE
                        + "\n 2. Full House"

                        // STRAIGHTS
                        // Large Straight
                        + "\n 3 - Large Straight"
                        // Small Straight
                        + "\n 4. Small Straight"

                        // KINDS
                        // Four of a kind
                        + "\n 5. Four of a Kind"
                        // Three of a kind
                        + "\n 6. Three of a Kind"

                        // PAIRS
                        // Pair
                        + "\n 7. Pair"
                        // Two Pair
                        + "\n 8. Two Pair"

                        // NUMBERS
                        // ONE
                        + "\n 9. Number of 1's"
                        // TWO
                        + "\n10. Number of 2's"
                        // THREE
                        + "\n11. Number of 3's"
                        // FOUR
                        + "\n12. Number of 4's"
                        // FIVE
                        + "\n13. Number of 5's"
                        // SIX
                        + "\n14. Number of 6's"

                        // CHANCE
                        + "\n15. Chance");

        String choice = JOptionPane.showInputDialog(
                null,
                "Which one do you want to choose?" + "\nType in the number of the option.",
                "Choice",
                JOptionPane.INFORMATION_MESSAGE);

        // Index Values
        int x;
        int y;

        // Variables to keep count of Straights, Pairs, or Kinds
        int winingsPairOrKinds = 0;
        int winingsStraight = 0;

        // Variables to keep count of the values of the die
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;

        Arrays.sort(aDice);

        // Counting the values of the die
        for (y = 0; y < 5; y++) {
            if (aDice[y] == 1) {
                ones++;
            }
            if (aDice[y] == 2) {
                twos++;
            }
            if (aDice[y] == 3) {
                threes++;
            }
            if (aDice[y] == 4) {
                fours++;
            }
            if (aDice[y] == 5) {
                fives++;
            }
            if (aDice[y] == 6) {
                sixes++;
            }
        }


        // Point calculations for Straights
        if ((aDice[0] == aDice[1] - 1) && (aDice[1] == aDice[2] - 1) && (aDice[2] == aDice[3] - 1) && (aDice[3] == aDice[4] - 1) && (Integer.parseInt(choice) == 3)) {
            winingsStraight = 1;
        }
        else if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0)) {
            winingsStraight = 2;
        }
        else if ((threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0)) {
            winingsStraight = 2;
        }
        else if ((twos > 0) && (threes > 0) && (fours > 0) && (fives > 0)) {
            winingsStraight = 2;
        }


        // Point calculations for Pairs
        for (x = 0; x < 5; x++) {
            if (x != 0) {
                if ((aDice[0] == aDice[x])) {
                    winingsPairOrKinds++;
                }
            }
            if ((x != 0) && (x != 1)) {
                if ((aDice[1] == aDice[x])) {
                    winingsPairOrKinds++;
                }
            }
            if ((x != 0) && (x != 1) && (x != 2)) {
                if ((aDice[2] == aDice[x])) {
                    winingsPairOrKinds++;
                }
            }
            if ((x != 0) && (x != 1) && (x != 2) && (x != 3)) {
                if ((aDice[3] == aDice[x])) {
                    winingsPairOrKinds++;
                }
            }
        }


        //Winnings
        if ((winingsPairOrKinds == 10) && (Integer.parseInt(choice) == 1)) {
            _w.msg("YAHTZEE!");
            score = 50;
        }
        else if ((winingsPairOrKinds == 4) && (Integer.parseInt(choice) == 2)) {
            _w.msg("You have a full house.");
            score = 25;
        }
        else if ((winingsStraight == 1) && (Integer.parseInt(choice) == 3)) {
            _w.msg("You have a straight.");
            score = 40;
        }
        else if ((winingsStraight == 2) && (Integer.parseInt(choice) == 4)) {
            _w.msg("You have a small straight.");
            score = 30;
        }
        else if ((winingsPairOrKinds >= 6) && (Integer.parseInt(choice) == 5)) {
            _w.msg("You have four of a kind.");
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
        }
        else if ((Integer.parseInt(choice) == 6) && (winingsPairOrKinds >= 3)) {
            _w.msg("You have three of a kind.");
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
        }
        else if ((winingsPairOrKinds == 2) && (Integer.parseInt(choice) == 8)) {
            _w.msg("You have two pairs.");
            score = 10;
        }
        else if ((Integer.parseInt(choice) == 7) && (winingsPairOrKinds > 0)) {
            _w.msg("You have a pair.");
            score = 5;
        }
        else if (Integer.parseInt(choice) == 9) {
            _w.msg("You have " + ones + " one(s).");
            score = ones;
        }
        else if (Integer.parseInt(choice) == 10) {
            _w.msg("You have " + twos + " two(s).");
            score = twos * 2;
        }
        else if (Integer.parseInt(choice) == 11) {
            _w.msg("You have " + threes + " three(s).");
            score = threes * 3;
        }
        else if (Integer.parseInt(choice) == 12) {
            _w.msg("You have " + fours + " four(s).");
            score = fours * 4;
        }
        else if (Integer.parseInt(choice) == 13) {
            _w.msg("You have " + fives + " five(s).");
            score = fives * 5;
        }
        else if (Integer.parseInt(choice) == 14) {
            _w.msg("You have " + sixes + " sixe(s).");
            score = sixes * 6;
        }
        else if (Integer.parseInt(choice) == 15) {
            score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
            _w.msg("Your get " + score + " point(s).");
        }
        else {
            _w.msg("You got nothing. Better luck next time.");
            score = 0;
        }

        _w.msg("Your total score: " + score + " point(s)");
    }


    // ACCESSOR METHODS
    public int getScore() {
        return score;
    }

    public int getChoice() {
        return choice;
    }
}