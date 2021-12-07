package MMN13;

/**
 * This class defines a square in 3 on 3 size.
 * Each cell of the square contains an integer
 * @author Kfir Levy
 * @version 24/11/2021
 */
public class Square3x3 {
	private int[][] _square;
	private final int MAX_CELLS_IN_ROW_COL = 3;
	private final int DEFAULT_VALUE = -1;
	private final int[] ALLOWED_INDEXES = {0, 1, 2};

	/**
	 * Construct a Square3x3 with default value in all cells.
	 */
	Square3x3() {
		this._square = new int[this.MAX_CELLS_IN_ROW_COL][this.MAX_CELLS_IN_ROW_COL];
		for (int i = 0; i<this._square.length; i++) // Sets value of all cells in array to default
			for (int j = 0; j < this._square[i].length; j++)
				this._square[i][j] = this.DEFAULT_VALUE;
	}

	/**
	 * Construct a Square3x3 as copy of values from other array.
	 * If the other array is bigger or smaller than Square3x3 allowed size, ignore value or set it to default.
	 * @param array The array to copy its values
	 */
	Square3x3(int[][]array) {	
		this._square = new int[this.MAX_CELLS_IN_ROW_COL][this.MAX_CELLS_IN_ROW_COL]; // Init the square array
		for (int i = 0; i < this._square.length; i++) {
			for (int j = 0; j < this._square[i].length; j ++) {
				// Checks if the given array have values at specific index
				if (i < array.length && j < array[i].length) {
					// If the given array has values at the index, copy them to this._square
					this._square[i][j] = array[i][j];
				} else {
					// If the given array doesn't have values at the index, set the this._square in the index to default value
					this._square[i][j] = this.DEFAULT_VALUE;
				}
			}
		}
	}

	/**
	 * Construct a Square3x3 as copy of values from other Square3x3.
	 * @param other The Square3x3 to copy its values
	 */
	Square3x3(Square3x3 other) {
		this._square = new int[this.MAX_CELLS_IN_ROW_COL][this.MAX_CELLS_IN_ROW_COL];
		for (int i = 0; i<other._square.length; i++) 
			for (int j = 0; j < other._square[i].length; j++) 
				this._square[i][j] = other._square[i][j];
	}

	/**
	 * Gets the value of a cell in specific row and column
	 * If row or col not valid, return default value
	 * @param row row of the cell
	 * @param col column of the cell
	 * @return specific cell (in row an col index) value, or if the indexes not valid return default value
	 */
	public int getCell(int row, int col) {
		return this.check_if_row_col_values_is_legal(row, col) ? this._square[row][col] : this.DEFAULT_VALUE;
	}

	/**
	 * Sets a cell value in specific row and column
	 * @param row row of the cell
	 * @param col column of the cell
	 * @param value value to set
	 */
	public void setXY(int row, int col, int value) {
		if (this.check_if_row_col_values_is_legal(row, col))
			this._square[row][col] = value;
	}

	/**
	 * Create string of the Square in a specific format
	 * @return stringToReturn, array in a specific format
	 */
	public String toString() {
		String stringToReturn = "";
		for (int i = 0; i<this._square.length; i++) {
			for (int j = 0; j < this._square[i].length; j++) {
				stringToReturn += this._square[i][j];
				if (j + 1 < this._square[i].length)
					stringToReturn += "\t";
			}
			stringToReturn += "\n";
		}
		return stringToReturn;
		
	}

	/**
	 * This function checks if this._square contains all numbers between 1-9
	 * @return True if it does, false otherwise
	 */
	public boolean allThere() {
		// Need to check my logic, this is wrong logic
		int[] full_array = new int[this.MAX_CELLS_IN_ROW_COL * this.MAX_CELLS_IN_ROW_COL];
		for (int i=0; i<this.MAX_CELLS_IN_ROW_COL * this.MAX_CELLS_IN_ROW_COL; i++) {
			full_array[i] = i + 1;
		}

		boolean boolToReturn = true;
		for (int i=0; i<this._square.length; i++) {
			for (int j=0; j<this._square[i].length; j++) {
				for (int k=0; k<full_array.length; k++) {
					if (this._square[i][j] == full_array[k]){
						full_array[k] = this.DEFAULT_VALUE;
					}
				}
			}
		}
		for (int i=0; i<full_array.length; i++) {
			if (full_array[i] != this.DEFAULT_VALUE) {
				boolToReturn = false;
			}
		}
		return boolToReturn;
	}

	/**
	 * Checks if values 1-9 appear in specific row, and if so change values array to true in the index where the number appear
	 * @param row the row number, valid numbers are in {0, 1, 2}
	 * @param values array of all booleans values
	 */
	public void whosThereRow (int row, boolean[] values ) {
		// Check if the row number is invalid
		if (check_if_index_is_valid(row, this.ALLOWED_INDEXES)) {
			// The row number is valid, so we check if the 1-9 numbers appear in the square
			for (int i=0; i<this._square[row].length; i++){
				// Check that the values of a cell and validate it is in range of 1-9 (include)
				if (check_if_value_is_index_in_array(values, this._square[row][i])){
					values[this._square[row][i]] = check_if_value_is_index_in_array(values, this._square[row][i]);
				}
			}
		}
	}

	/**
	 * Checks if values 1-9 appear in specific column, and if so change values array to true in the index where the number appear
	 * @param col the col number, valid numbers are in {0, 1, 2}
	 * @param values array of all booleans values
	 */
	public void whosThereCol (int col, boolean[] values )  {
		// Check if the col number is invalid
		if (check_if_index_is_valid(col, this.ALLOWED_INDEXES)){
			// The col number is valid, so we check if the 1-9 numbers appear in the square
			for (int i=0; i<this._square.length; i++) {
				// Check that the values of a cell and validate it is in range of 1-9 (include)
				if (check_if_value_is_index_in_array(values, this._square[i][col])){
					values[this._square[i][col]] = check_if_value_is_index_in_array(values, this._square[i][col]);
				}
			}
		}
	}

	// This function checks if a given values of row and col is legal and in range of the array
	private boolean check_if_row_col_values_is_legal(int row, int col){
		return (check_if_index_is_valid(row, this.ALLOWED_INDEXES) && check_if_index_is_valid(col, this.ALLOWED_INDEXES));
	}

	// This function checks if given index of row/col is valid in array {0, 1, 2}
	private boolean check_if_index_is_valid(int index, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (index == array[i]) {
				return true;
			}
		}
		return false;
	}

	// This function get array of booleans and an int value. return true if the value is an index in the array
	private boolean check_if_value_is_index_in_array(boolean[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (value == i) {
				return true;
			}
		}
		return false;
	}
}
