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
    public char getWinner() {

        char winner = ' ';

        // Check Columns
        for (int i = 0; i < 3; i++) {

            if (row1.get(i) == row2.get(i) && row1.get(i) == row3.get(i) && row1.get(i) != ' ') {

                winner = row1.get(i);

            }

        }

        // Check Rows
        for (ArrayList<Character> row : board) {

            if (row.get(0) == row.get(1) && row.get(0) == row.get(2) && row.get(0) != ' ') {

                winner = row.get(0);

            }

        }

        // Check Downward Diagonal
        if (row1.get(0) == row2.get(1) && row1.get(0) == row3.get(2) && row1.get(0) != ' ') {

            winner = row1.get(0);

        }

        // Check Upward Diagonal
        if (row1.get(2) == row2.get(1) && row1.get(2) == row3.get(0) && row1.get(2) != ' ') {

            winner = row1.get(2);

        }

        return winner;

    }

    public String getBoard() {

        String board = "";

        for (int i = 0 ; i < 3 ; i++) {

            for (int j = 0 ; j < 3 ; j++) {

               board += getRow(i).get(j);
                if (j != 2) {

                    board += " | ";

                }

            }

            board += "\n";

            if (i != 2) {

                board += "--|---|--\n";

            }

        }

        return board;

    }

    public ArrayList<Character> getRow(int row) {

        if (row == 0) {

            return row1;

        } else  if (row == 1) {

            return row2;

        } else if (row == 2) {

            return row3;

        } else {

            return null;

        }

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
    public boolean isValid(int chosenCell) {

        boolean isValid = true;

        if (chosenCell >= 1 && chosenCell <= 3 && row1.get(chosenCell - 1) != ' ') {

            isValid = false;

        } else if (chosenCell >= 4 && chosenCell <= 6 && row2.get(chosenCell - 4) != ' ') {

            isValid = false;

        } else if (chosenCell >= 7 && chosenCell <= 9 && row3.get(chosenCell - 7) != ' '){

            isValid = false;

        }

        return isValid;

    }

    public boolean gameComplete() {

        boolean gameComplete = true;

        if (getWinner() == ' ') {

            for (ArrayList<Character> row : this.board) {

                for (char cell : row) {

                    if (cell == ' ') {

                        gameComplete = false;

                    }

                }

            }

        } else {

            gameComplete = true;

        }

        return gameComplete;

    }

}