package MMN13;

/**
 * This class defines a Sudoku board.
 * @author Kfir Levy
 * @version 24/11/2021
 */
public class Sudoku {
    private Square3x3[][] _sudokuBoard;
    private final int MAX_CELLS_IN_ROW_COL = 3;

    /**
     * Construct a new Sudoku with default Square3x3 in all cells
     */
    public Sudoku() {
        this._sudokuBoard = new Square3x3[this.MAX_CELLS_IN_ROW_COL][this.MAX_CELLS_IN_ROW_COL];
        for (int i = 0; i<this._sudokuBoard.length; i++)
            for (int j = 0; j < this._sudokuBoard[i].length; j++)
                this._sudokuBoard[i][j] = new Square3x3();
    }

    /**
     * Construct a Sudoku as copy of values from other Sudoku array.
     * @param square3x3Array The given Sudoku array to copy his values
     */
    public Sudoku(Square3x3[][] square3x3Array) {
        this._sudokuBoard = new Square3x3[this.MAX_CELLS_IN_ROW_COL][this.MAX_CELLS_IN_ROW_COL];
        for (int i = 0; i<this._sudokuBoard.length; i++)
            for (int j = 0; j < this._sudokuBoard[i].length; j++)
                this._sudokuBoard[i][j] = new Square3x3(square3x3Array[i][j]);
    }

    /**
     * This function checks if this._sudokuBoard is valis by the sudoku rules:
     * 1. In each square (AKA Square3x3) all the numbers is 1-9
     * 2. In each row of big board, all numbers is 1-9
     * 3. In each column of big board, all numbers is 1-9
     * @return True if the board is valid, false otherwise
     */
    public Boolean isValid() {
        final int DIFF_BECAUSE_ZERO_INCLUDE_IN_ARRAY = 1;
        for (int i=0; i<this._sudokuBoard.length; i++) {
            boolean[] valuesOfRow = new boolean[this.MAX_CELLS_IN_ROW_COL * this.MAX_CELLS_IN_ROW_COL + DIFF_BECAUSE_ZERO_INCLUDE_IN_ARRAY];
            boolean[] valuesOfCol = new boolean[this.MAX_CELLS_IN_ROW_COL * this.MAX_CELLS_IN_ROW_COL + DIFF_BECAUSE_ZERO_INCLUDE_IN_ARRAY];
            for (int j=0; j<this._sudokuBoard[i].length; j++) {
                // Check that in each Square3x3 all values 1-9 appear, if not return false
                this._sudokuBoard[i][j].whosThereRow(i, valuesOfRow);
                this._sudokuBoard[j][i].whosThereCol(i, valuesOfCol);
                if (!this._sudokuBoard[i][j].allThere()) {
                    return false;
                }
            }
            // Check that all rows and columns are valid to the rules
            if (!this.checkIfValuesIsOnlyTrue(valuesOfRow) || !this.checkIfValuesIsOnlyTrue(valuesOfCol))
                return false;
        }
        return true;
    }

    // This function checks that the given array values contain only true values from its second cell (Index 1) till the end
    private boolean checkIfValuesIsOnlyTrue(boolean[] values) {
        for (int i=1; i<values.length; i++)
            if (!values[i])
                return false;
        return true;
    }

}
