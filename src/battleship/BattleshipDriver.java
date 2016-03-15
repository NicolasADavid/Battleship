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
import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipDriver {

    public static void main(String[] args) {

        String again; //Will be used to ask if the player would like to play again
        ArrayList hits = new ArrayList();   //Track total hits for all games
        ArrayList misses = new ArrayList(); //Track total misses for all games

        //Start playing
        do {

            Battleship battleship = new Battleship(); //Create new battleship game

            int col;
            int row;

            Scanner in = new Scanner(System.in); //Create new scanner for user input

            System.out.println("Welcome! You can go first.\n");
            System.out.println("\"X\" means miss. \"*\" means hit.\n");

            for (int i = 0; i < 5; i++) { //Allows the player to shoot 5 times

                battleship.printBoardHalf(2); // Shows the player the opponent's board

                boolean goodRow; //Used to validate input row
                boolean goodCol; //Used to validate input column

                do {

                    System.out.println("Input a column and row to target (1-5), hitting enter after each input.");
                    col = in.nextInt() - 1; //Subtracts one so 1 actually means 0 and 2 actually means 1 etc..
                    row = in.nextInt() - 1; //Subtracts one so 1 actually means 0 and 2 actually means 1 etc..

                    //Checks if col and row are valid values.
                    goodRow = row == 0 | row == 1 | row == 2 | row == 3 | row == 4;
                    goodCol = col == 0 | col == 1 | col == 2 | col == 3 | col == 4;

                    //Warns user of invalid input if row or col is invalid.
                    if (!(goodRow & goodCol)) {
                        System.out.println("Invalid input. Only 1-5.");
                    }

                } while (!(goodRow & goodCol)); //Repeats user input until row and col are valid values.

                System.out.println("\nShot " + (i + 1)); //Prints the shot taken.
                
                battleship.shoot(col, row); //Takes the shot
            }

            if (battleship.returnHits() >= 4) { //All ships hit. Game won.
                System.out.println("You win! You hit all ships! Here's the opponent's board: \n");

            } else { //Not all ships hit. Game lost.
                System.out.println("Game over! You landed " + battleship.returnHits() + " out of 5 shots!"
                        + " Here's the opponent's board: \n\"X\" is a miss. \"*\" is a hit. \"S\" is a ship.\n");
            }

            battleship.printBoardFull(2); //Prints opponent's board.

            hits.add(battleship.returnHits()); //Add this game's hits to hits counter
            misses.add(battleship.returnMisses()); // Add this game's misses to misses counter

            //Ask user if they would like to play again.
            System.out.println("Play again? Type \"yes\" or \"no\"");
            Scanner in2 = new Scanner(System.in);
            again = in2.nextLine();
            
        } while (again.equals("yes")); //Starts new game or ends game.

        //Prints all game's number, hits, and misses.
        System.out.println("\nGame\tHits\tMisses");
        for (int i = 0; i < hits.size(); i++) {
            System.out.println((i + 1) + "\t" + hits.get(i) + "\t" + misses.get(i));
        }

    }

}