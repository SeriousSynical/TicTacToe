import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        run();

    }

    public static void run() {

        // Initialize Flags
        boolean flag;
        String replay = null;

        // Initialize Values
        char currentPlayer;
        int chosenCell;

        // Construct Objects
        Scanner keyboard = new Scanner(System.in);
        Board board = new Board();

        // Game
        do {

            // Reset Values
            currentPlayer = 0;
            board = new Board();

            // Rules
            System.out.println("Cells are numbered left to right, top to bottom, starting top left and ending bottom right.");
            System.out.println("Get three in a row to win!");

            // Turn
            do {

                // Swap Player
                if (currentPlayer == 'X') {

                    currentPlayer = 'O';

                } else {

                    currentPlayer = 'X';

                }

                // Draw Board
                System.out.println(board.getBoard());

                // Prompt Move
                flag = true;
                do {

                    try {

                        if (currentPlayer == 'X') {

                            System.out.print("Player 1 ");

                        } else {

                            System.out.print("Player 2 ");

                        }
                        System.out.print("Move: ");
                        chosenCell = keyboard.nextInt();
                        if (chosenCell < 1 || chosenCell > 9 || !board.isValid(chosenCell)) {

                            System.out.println("Not Valid Move");

                        } else {

                            board.makeMove(currentPlayer, chosenCell);
                            flag = false;

                        }

                    } catch (Exception e) {

                        System.out.println("Invalid Input.");

                    }

                    keyboard.nextLine(); // Flush

                } while (flag);
                System.out.println();

            } while (!board.gameComplete());

            // Draw Board
            System.out.println(board.getBoard());

            // Determine Winner
            if (board.getWinner() != ' ') {

                if (board.getWinner() == 'X') {

                    System.out.print("Player 1 ");

                } else {

                    System.out.print("Player 2 ");

                }
                System.out.println("wins!");

            } else {

                System.out.println("Tied game!");

            }

            // Prompt Replay
            flag = true;
            do {

                try {

                    System.out.print("Play again?: ");
                    replay = keyboard.nextLine();
                    if (!(replay.toLowerCase().charAt(0) == 'y' || replay.toLowerCase().charAt(0) == 'n')) {

                        System.out.println("Invalid Input.");

                    } else {

                        flag = false;

                    }

                } catch (Exception e) {

                    System.out.println("Invalid Input.");

                }

            } while (flag);

        } while (replay.toLowerCase().charAt(0) == 'y');

    }

}