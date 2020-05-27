package MAIN;

import javax.swing.JOptionPane;
import VIEW.Window;
import MOD.*;

class Yahtzee {
    private static Window _w = new Window();

    /**
     * This method focuses on the game:
     *  - Setting the dice's values for the player depending on the user's input
     *  - Determining the player's score depending on the user's input
     *  - Asking the player if they want to play again
     * @param args
     */
    public static void main(String[] args) {
        int play = 1;
        int score = 0;
        int sum = 0;
        int[] wins = new int[15];

        while (play == 1 && sum < 15) {
            sum = 0;
            int[] aDice = new int[] { 0, 0, 0, 0, 0 }; // ARRAY FOR DIE VALUES

            // INDEX VARIABLES
            int x;
            int y;
            int w;
            int z;

            // USER INPUT
            String input = "";

            // ROLL/RE-ROLL VARIABLES
            int roll = 0; // rounds
            int reroll1 = 0;
            int reroll2 = 3;

            Die die = new Die();

            for (x = 0; x < 5; x++) {
                die.roll();
                aDice[x] = die.get(); // sets the dice values
            }

            _w.msg("Die 1: " + aDice[0]
                    + "\nDie 2: " + aDice[1]
                    + "\nDie 3: " + aDice[2]
                    + "\nDie 4: " + aDice[3]
                    + "\nDie 5: " + aDice[4]);

            do {
                // Re-roll 1 input option
                input = JOptionPane.showInputDialog(
                        null,
                        "How many dice do you want to reroll? (0 - 5)",
                        "Reroll",
                        JOptionPane.INFORMATION_MESSAGE);

                reroll1 = Integer.parseInt(input);

                // Re-roll 2 input option
                if (reroll1 > 0) {
                    int[] reroll = new int[reroll1];

                    for (y = 0; y < reroll1; y++) {
                        input = JOptionPane.showInputDialog(
                                null,
                                "Which die do you want to reroll? (1 - 5)",
                                "Reroll",
                                JOptionPane.INFORMATION_MESSAGE);

                        reroll2 = Integer.parseInt(input);
                        reroll[y] = reroll2;
                    }

                    // setting new values due to the re-roll input
                    for (w = 0; w < reroll1; w++) {
                        if (reroll[w] == 1) {
                            die.roll();
                            aDice[0] = die.get();
                        }
                        if (reroll[w] == 2) {
                            die.roll();
                            aDice[1] = die.get();
                        }
                        if (reroll[w] == 3) {
                            die.roll();
                            aDice[2] = die.get();
                        }
                        if (reroll[w] == 4) {
                            die.roll();
                            aDice[3] = die.get();
                        }
                        if (reroll[w] == 5) {
                            die.roll();
                            aDice[4] = die.get();
                        }
                    }

                    roll++;

                    _w.msg("Die 1: " + aDice[0]
                            + "\nDie 2: " + aDice[1]
                            + "\nDie 3: " + aDice[2]
                            + "\nDie 4: " + aDice[3]
                            + "\nDie 5: " + aDice[4]);
                }
            }

            while ((roll < 2) && (reroll1 > 0));
            Winning prize = new Winning();
            prize.checkWinnings(aDice, wins);
            wins[prize.getChoice() - 1] = 1;

            for (z = 0; z < 15; z++) {
                sum += wins[z]; // sets score depending on the winning choice
            }

            score += prize.getScore();

            _w.msg("Your total score is: " + score);

            // Input to play again
            if (sum < 15) {
                input = JOptionPane.showInputDialog(
                        null,
                        "Would you like to continue?" + "\nType 1 to continue or 2 to exit.",
                        "Continue?",
                        JOptionPane.INFORMATION_MESSAGE);
                // EXIT option
                if(input.equals("1")){
                    play = 1;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Game Over!");
                    System.exit(0);
                }
            }
        }
    }
}
