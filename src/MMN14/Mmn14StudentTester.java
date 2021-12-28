package MMN14;

public class Mmn14StudentTester {

    public static void main(String[] args) {
        System.out.println("\n=============================== Start findMinDiff test===============================");
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        boolean errorFound=false;
        int expected1 = 4;
        int actual1 = Ex14.findMinDiff(array,3,7);
        if (actual1 != expected1) {
            errorFound = true;
            System.out.println("Incorrect result when executing with array: {1, 2, 3, 4, 5, 6, 7} and numbers 3,7 ");
            System.out.println("Should be: " + expected1 + " but got: " + actual1 + "\n");
        }

        if (!errorFound) {
            System.out.println("Testing findMinDiff Successfully passed.");
        }
        System.out.println("\n=============================== End findMinDiff test===============================");

        System.out.println("\n=============================== Start search test===============================");

        int[][] mat2={ 
                {1,2},
                {7,5}};

        errorFound=false;

        boolean expected2=true;
        boolean actual2 = Ex14.search(mat2,2);

        if (actual2 != expected2) {
            errorFound = true;
            System.out.println("For matrix { {1,2},{7,5}} and number 2 ");
            System.out.println("Should be: " + expected2 + " but got: " + actual2 + "\n");
        }

        if (!errorFound) 
            System.out.println("Testing search Successfully passed.");

            System.out.println("\n=============================== End search test===============================");
            System.out.println("\n=============================== Start equalSplit test===============================");

            errorFound = false;

            int [] array2 = {1, 2, 3, 4, 5, 6};

            boolean expected3 = false;
            boolean   actual3 = Ex14.equalSplit(array2);
            if (actual3 != expected3) {
                errorFound = true;
                System.out.println("Incorrect result when executing with array: {1, 2, 3, 4, 5, 6}");
                System.out.println("Should be: " + expected3 + " but got: " + actual3 + "\n");
            
            }
            if (!errorFound) {
                System.out.println("Testing equalSplit Successfully passed.");
            }

            System.out.println("\n=============================== End equalSplit test===============================");

            System.out.println("\n=============================== Start isSpecial test===============================");
            errorFound = false;

            boolean expected4=true;
            boolean actual4 = Ex14.isSpecial(3);
            if (actual4 != expected4) {
                errorFound = true;
                System.out.println("Incorrect result when executing with number 3 ");
                System.out.println("Should be: " + expected4 + " but got: " + actual4 + "\n");
            }

            if (!errorFound) {
                System.out.println("Testing isSpecial Successfully passed.");
            }

            System.out.println("\n=============================== End isSpecial test===============================");
        }
    }


