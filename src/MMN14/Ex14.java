package MMN14;

/**
 * This class is the class of answers for MMN14
 * @author Kfir Levy
 * @version 26/12/2021
 */
public class Ex14 {

    /**
     * This function calculate the minimum index difference between teo number in a given array
     * If one of the numbers not in the array the function will return Integer.MAX_VALUE
     *
     * The time complexity of this function is O(n), n stands for the length of the array.
     * The function run only one time over the array so in the worst case it will check n values.
     *
     * The space complexity of this function is O(1), the function using only 4 parameters and not using any arrays.
     *
     * @param a array of numbers
     * @param x first number
     * @param y second number
     * @return minDiff - the minimum index difference between the numbers
     */
    public static int findMinDiff (int[] a, int x, int y) {
        final int DEFAULT_NOT_VALID_INDEX = -1;
        int minDiff = Integer.MAX_VALUE; // default value is Integer.MAX_VALUE
        int firstIndex = DEFAULT_NOT_VALID_INDEX; // default value is non valid index in array
        for (int index = 0; index < a.length; index ++) {
            // Checks if the number in index is x or y
            if (a[index] == x || a[index] == y) {
                // If firstIndex is DEFAULT_NOT_VALID_INDEX then this is the first x or y in array
                if (firstIndex == DEFAULT_NOT_VALID_INDEX)
                    firstIndex = index;
                // if we find a number that is not the same as the last one we found we calc the index different and check if this is the minimal value
                if (a[index] != a[firstIndex])
                    minDiff = Math.min(minDiff, index - firstIndex);
                firstIndex = index;
            }
        }
        return minDiff;
    }


    /**
     * This function gets a mat that is already sorted in a specific way and a number.
     * The function should check if the number is in the array in the most efficient way.
     *
     * The time complexity of this function is O(log(n)), n stands for the size of the mat.
     * Each time we're entering the loop we make the problem smaller, because now we are searching only
     * a quarter of the all matrix.
     *
     * The space complexity of this function is O(1), the function using only 7 parameters and not using any arrays.
     *
     * @param mat Matrix that is sorted in a given way
     * @param num The number to search for in the matrix
     * @return True if the number is in the matrix, false otherwise
     */
    public static boolean search (int [][] mat, int num) {
        final int LAST_CELL_DIFF = 1; // Diff between length of array and last cell index
        final int SIZE_OF_MINI_SQUARE_IN_RATIO = 2; //  Ration size of quarter in the matrix
        int colStart = 0, rowStart = 0, rowEnd = mat.length, colEnd = mat[0].length;
        while (true) {
            int mini_square_size = (colEnd - colStart) / SIZE_OF_MINI_SQUARE_IN_RATIO; // Size of quarter in mat
            if (rowEnd - LAST_CELL_DIFF == rowStart && colEnd - LAST_CELL_DIFF== colStart) // Checks if the mat is in size of 1
                return mat[rowStart][colStart] == num; // Checks if the number is the number we searched
            else if ((mat[rowStart][colStart] <= num) &&
                    (mat[rowStart + mini_square_size - LAST_CELL_DIFF][colStart] >= num)) { // Checks if the number is in the range of numbers in the first quarter
                colEnd = colStart / SIZE_OF_MINI_SQUARE_IN_RATIO + colEnd / SIZE_OF_MINI_SQUARE_IN_RATIO;
                rowEnd = rowStart / SIZE_OF_MINI_SQUARE_IN_RATIO + rowEnd / SIZE_OF_MINI_SQUARE_IN_RATIO;
            } else if ((mat[rowStart][colStart + mini_square_size] <= num) &&
                    (mat[rowStart + mini_square_size - LAST_CELL_DIFF][colStart + mini_square_size] >= num)) { // Checks if the number is in the range of numbers in the second quarter
                colStart = colStart / SIZE_OF_MINI_SQUARE_IN_RATIO + colEnd / SIZE_OF_MINI_SQUARE_IN_RATIO;
                rowEnd = rowStart / SIZE_OF_MINI_SQUARE_IN_RATIO + rowEnd / SIZE_OF_MINI_SQUARE_IN_RATIO;
            } else if ((mat[rowEnd / SIZE_OF_MINI_SQUARE_IN_RATIO][colStart + mini_square_size] <= num) &&
                    (mat[rowEnd - LAST_CELL_DIFF][colStart + mini_square_size] >= num)) { // Checks if the number is in the range of numbers in the third quarter
                colStart = colStart / SIZE_OF_MINI_SQUARE_IN_RATIO + colEnd / SIZE_OF_MINI_SQUARE_IN_RATIO;
                rowStart = rowStart / SIZE_OF_MINI_SQUARE_IN_RATIO + rowEnd / SIZE_OF_MINI_SQUARE_IN_RATIO;
            } else if ((mat[rowEnd / SIZE_OF_MINI_SQUARE_IN_RATIO][colStart] <= num) &&
                    (mat[rowEnd - LAST_CELL_DIFF][colStart] >= num)) { // Checks if the number is in the range of numbers in the fourth quarter
                rowStart = rowStart / SIZE_OF_MINI_SQUARE_IN_RATIO + rowEnd / SIZE_OF_MINI_SQUARE_IN_RATIO;
                colEnd = colStart / SIZE_OF_MINI_SQUARE_IN_RATIO + colEnd / SIZE_OF_MINI_SQUARE_IN_RATIO;
            } else {
                return false; // if the number is not in any of quarters ranges we return false
            }
        }
    }

    /**
     * This function check if an array can be split to two arrays that identical in there length and sum
     * @param arr array of numbers to check
     * @return True if the array can be split to two arrays that identical in there length and sum, False otherwise
     */
    public static  boolean  equalSplit (int[] arr) {
        final int DEFAULT_INDEX_AND_SUM_VALUE = 0; // Default value for start indexes and sums
        return equalSplitRecursive(arr, DEFAULT_INDEX_AND_SUM_VALUE, DEFAULT_INDEX_AND_SUM_VALUE, DEFAULT_INDEX_AND_SUM_VALUE, DEFAULT_INDEX_AND_SUM_VALUE, DEFAULT_INDEX_AND_SUM_VALUE);
    }

    // This function is a recursive function that gets an array of numbers, index in the array, two sums of vars in the
    // array and the length of the "sub-arrays" of sums. The function check if the array can be split to two arrays
    // that identical in there length and sum.
    private static boolean equalSplitRecursive(int[] arr, int index, int sum1, int sum2, int length1, int length2) {
        final int DEFAULT_ONE_STEP_FORWARD = 1;
        if (arr.length == index) {
            // If we arrived to end of array, we check if the sum of two sub-arrays are identical and the length of them are the same
            return sum1 == sum2 && length1 == length2;
        } else {
            // We check each side of the array, first case that the number in current index is part of sub-array 1 and second case that the number in current index is part of sub-array 2
            return equalSplitRecursive(arr, index + DEFAULT_ONE_STEP_FORWARD, sum1 + arr[index], sum2, length1 + DEFAULT_ONE_STEP_FORWARD, length2) ||
                    equalSplitRecursive(arr, index + DEFAULT_ONE_STEP_FORWARD, sum1, sum2 + arr[index], length1 , length2 + DEFAULT_ONE_STEP_FORWARD);
        }
    }

    /**
     * This function check if a number is special, which means that we remove each second number, third number,
     * fourth number etc. the number will not be removed.
     * @param n the number to check if special
     * @return True if the number is special, False otherwise
     */
    public static boolean isSpecial (int n) {
        final int START_JUMPING_VALUE = 2; // Stating number of jumping
        final int START_OF_POSITIVE_NUMBERS = 0; // Stating of positive numbers
        if (n > START_OF_POSITIVE_NUMBERS){
            return isSpecialRecursive(n, START_JUMPING_VALUE);
        }
        return false;
    }

    // This function is a recursive function that gets an index of number and the jumping index, its checks if we make
    // a jump if the index of the number will still be in the array
    private static boolean isSpecialRecursive(int nIndex, int jumpingIndex) {
        final int DEFAULT_ONE_STEP_FORWARD = 1;
        final int DEFAULT_DIVISOR_VALUE = 0;
        if (jumpingIndex > nIndex) {
            // If we got here its means that the index of the number is for sure in the array and will not be removed
            return true;
        } if (nIndex % jumpingIndex == DEFAULT_DIVISOR_VALUE) {
            // If the index of the number can be divided by the jumping index its means that it should be removed, so he is not special
            return false;
        } else {
            // Check for the next jumping value if the index of number is still in array
            return isSpecialRecursive(nIndex - nIndex / jumpingIndex, jumpingIndex + DEFAULT_ONE_STEP_FORWARD);
        }
    }
}
