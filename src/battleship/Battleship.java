///////////////////////////////////////////////////////////////////////////////                  
// Title:            battleship
// Files:            JavaApplication8Battleship.java;battleship.java
// Semester:         COP3337 Fall 2015
//
// Author:           3587814
// Lecturer's Name:  Prof. Maria Charters
//
// Description of Program’s Functionality:Plays a game(s) of battleship through
// the console.
//////////////////////////// 80 columns wide/////////////////////////////////  /**

package battleship;

import java.util.Random;

public class Battleship {

    private int onemisses = 0;
    private int twomisses = 0;

    private int onehits = 0;
    private int twohits = 0;

    private int[][] oneboard = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};

    private int[][] twoboard = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};

    /**
     * battleship. Creates a board for players one and two.
     */
    public Battleship() {

        //generate a new board for One and Two with 4 random ships
        for (int i = 1; i <= 2; i++) { //Runs twice.

            int[][] makingboard = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};

            for (int j = 1; j <= 4; j++) { //Runs four times.

                boolean flag; //Used to make sure a ship placement is not repeated.

                do {
                    flag = true;

                    Random randomGenerator = new Random();
                    int row = randomGenerator.nextInt(5);
                    int col = randomGenerator.nextInt(5);

                    if (makingboard[row][col] != 1) {
                        makingboard[row][col] = 1;
                        flag = false;
                    }

                } while (flag); //Repeats until a 0 on the board has been changed to a 1.
            }

            if (i == 1) {
                oneboard = makingboard; //Makes plarer 1's board.
            } else {
                twoboard = makingboard; //Makes player 2's board.
            }

        }

    }

    /**
     * printBoardFull. Prints a player's board full disclosure.
     *
     * 0 = space with no ship that has not been shot at X = space with no ship
     * that has been shot at S = ship that has not been shot * = ship that has
     * been shot
     *
     * @param a If 1, prints player one's board. If 2, player two's board.
     */
    public void printBoardFull(int a) {

        int[][] board;

        if (a == 1) {
            board = oneboard;
        } else {
            board = twoboard;
        }

        System.out.print("    ");
        for (int i = 0; i < board.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.print("\n\n");

        for (int i = 0; i < board.length; i++) {

            System.out.print(i + "   ");

            for (int j = 0; j < board[i].length; j++) {
                //System.out.print(board[i][j] + " ");

                switch (board[i][j]) {
                    case 0: //Nothing there and has not been shot
                        System.out.print("0 ");
                        break;
                    case 1: //Something there and has not been shot
                        System.out.print("S ");
                        break;
                    case 2: //Nothing there and has been shot
                        System.out.print("X ");
                        break;
                    case 3: //Something there and has been hit
                        System.out.print("* ");
                        break;

                }

            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * printBoardHalf. Prints a player's board partially. Will show empty space
     * unless the player has shot at the space. Shows misses and hits only. 0
     * "empty" shows as 0 1 "occupied" shows as 0 2 "miss" shows as X 3 "hit"
     * shows as *
     *
     * @param a If 1, prints player one's board. If 2, player two's board.
     */
    public void printBoardHalf(int a) {

        int[][] board;

        if (a == 1) {
            board = oneboard;
        } else {
            board = twoboard;
        }

        System.out.print("    ");
        for (int i = 0; i < board.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.print("\n\n");

        for (int i = 0; i < board.length; i++) {

            System.out.print(i + "   ");

            for (int j = 0; j < board[i].length; j++) {

                //System.out.print(board[i][j]+" ");
                switch (board[i][j]) {
                    case 0: //Nothing there and has not been shot
                        System.out.print("0 ");
                        break;
                    case 1: //Something there and has not been shot
                        System.out.print("0 ");
                        break;
                    case 2: //Nothing there and has been shot
                        System.out.print("X ");
                        break;
                    case 3: //Something there and has been hit
                        System.out.print("* ");
                        break;

                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * shoot. Shoots at a space on player two's board board. Prints result of
     * shot to console.
     *
     * @param col Column to be targeted.
     * @param row Row to be targeted.
     */
    public void shoot(int col, int row) {

        switch (twoboard[row][col]) {
            case 0:
                twoboard[row][col] = 2;
                System.out.println("You missed!");
                onemisses++;
                break;
            case 1:
                twoboard[row][col] = 3;
                System.out.println("You hit!");
                onehits++;
                break;
            default:
                System.out.println("You already shot there");
                onemisses++;
                break;
        }
        System.out.println();
    }

    /**
     * Method to be used for the computer to shoot back at the player.
     */
    public void computerShoot() {
        //empty
    }

    /**
     * Returns hits that player one has had so far.
     *
     * @return Integer. The number of hits player one has had this game.
     */
    public int returnHits() {
        return onehits;
    }

    /**
     * Returns misses that player one has had so far.
     *
     * @return Integer. The number of misses player one has had this game.
     */
    public int returnMisses() {
        return onemisses;
    }

}
