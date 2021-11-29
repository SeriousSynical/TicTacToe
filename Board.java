import java.util.ArrayList;

public class Board {

    // Initialize Objects
    private final ArrayList<Character> row1;
    private final ArrayList<Character> row2;
    private final ArrayList<Character> row3;
    ArrayList<ArrayList<Character>> board;


    // Construct Board
    public Board() {

        row1 = new ArrayList<>();
        row1.add(' ');
        row1.add(' ');
        row1.add(' ');

        row2 = new ArrayList<>();
        row2.add(' ');
        row2.add(' ');
        row2.add(' ');

        row3 = new ArrayList<>();
        row3.add(' ');
        row3.add(' ');
        row3.add(' ');

        board = new ArrayList<>();
        board.add(row1);
        board.add(row2);
        board.add(row3);

    }


    // Get Values
    public ArrayList<ArrayList<Character>> getBoard() {

        return board;

    }


    // Make Move
    public void makeMove(char player, int chosenCell) {

        if (chosenCell <= 3) {

            row1.set(chosenCell - 1, player);

        } else if (chosenCell <= 6) {

            row2.set(chosenCell - 4, player);

        } else {

            row3.set(chosenCell - 7, player);

        }

    }


    // Check Board Status
    public boolean gameComplete() {

        boolean gameComplete = true;

        for (ArrayList<Character> row : board) {

            if (row.get(0) == row.get(1) && row.get(0) == row.get(2) && row.get(0) != ' ') {

                

            }

        }

        return gameComplete;

    }

    public char gameWinner() {



    }

}
