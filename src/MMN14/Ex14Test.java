/**  kilroy             
 *               _____   here
 *         was  /     \    
 *     ____    /(.) (.)\    ____
 * ---/    \------| |------/    \---
 *    |/\/\/      | |      |/\/\/
 *                \_/  
 *   created by B.A.
 */

package MMN14;

public class Ex14Test extends Ex14
{
    public static void main(String args[])
    {
        int[] arr = {1, 3, 5, 4, 8, 2, 4, 3, 6, 5};

        int num, num2;

        System.out.println("***** Qst 1 - diffMinNum *****");
        System.out.print("Array: ");
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");

        num = findMinDiff(arr, 1, 6);
        num2 = findMinDiff(arr, 6, 1);
        System.out.print("\n\nTest #1 - 1 & 6:.....");
        if (num == num2 && num == 8)
            System.out.println("OK");
        else
            System.out.println("Error - your distance is: " + num +" or " + num2 + " Expect: 8");

        num = findMinDiff(arr, 3, 4);
        num2 = findMinDiff(arr, 4, 3);
        System.out.print("Test #2 - 3 & 4:.....");
        if (num == num2 && num == 1)
            System.out.println("OK");
        else
            System.out.println("Error - your distance is: " + num +" or " + num2 + " Expect: 1");

        num = findMinDiff(arr, 8, 6);
        num2 = findMinDiff(arr, 6, 8);
        System.out.print("Test #3 - 6 & 8:.....");
        if (num == num2 && num == 4)
            System.out.println("OK");
        else
            System.out.println("Error - your distance is: " + num +" or " + num2 + " Expect: 4");

        num = findMinDiff(arr, 7, 8);
        num2 = findMinDiff(arr, 8, 7);
        System.out.print("Test #4 - 7 & 8:.....");
        if (num == num2 && num == 2147483647)
            System.out.println("OK");
        else
            System.out.println("Error - your distance is: " + num +" or " + num2 + " Expect: 2147483647");

        num = findMinDiff(arr, 9, 7);
        num2 = findMinDiff(arr, 7, 9);
        System.out.print("Test #5 - 7 & 9:.....");
        if (num == num2 && num == 2147483647)
            System.out.println("OK");
        else
            System.out.println("Error - your distance is: " + num +" or " + num2 + " Expect: 2147483647");

        num = findMinDiff(arr, 5, 6);
        num2 = findMinDiff(arr, 6, 5);
        System.out.print("Test #6 - 6 & 5:.....");
        if (num == num2 && num == 1)
            System.out.println("OK");
        else
            System.out.println("Error - your distance is: " + num +" or " + num2 + " Expect: 1");

        num = findMinDiff(arr, 1, 3);
        num2 = findMinDiff(arr, 3, 1);
        System.out.print("Test #7 - 1 & 3:.....");
        if (num == num2 && num == 1)
            System.out.println("OK");
        else
            System.out.println("Error - your distance is: " + num +" or " + num2 + " Expect: 1");

        num = findMinDiff(arr, 3, 5);
        num2 = findMinDiff(arr, 5, 3);
        System.out.print("Test #8 - 3 & 5:.....");
        if (num == num2 && num == 1)
            System.out.println("OK");
        else
            System.out.println("Error - your distance is: " + num +" or " + num2 + " Expect: 1");

        
        
        System.out.println("\n***** Qst 2 - search - 2x2 array *****");
        int[][] arr2x2 ={{1, 2},
                         {4, 3}};
        
        System.out.print("Test #1:......");
        if (search(arr2x2, 1))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr2x2, 1) + "Expect: true");

        System.out.print("Test #2:......");
        if (search(arr2x2, 2))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr2x2, 2) + "Expect: true");

        System.out.print("Test #3:......");
        if (search(arr2x2, 3))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr2x2, 3) + "Expect: true");

        System.out.print("Test #4:......");
        if (search(arr2x2, 4))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr2x2, 4) + "Expect: true");

        System.out.print("Test #5:......");
        if (!search(arr2x2, 5))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr2x2, 0) + "Expect: false");

        System.out.print("Test #6:......");
        if (!search(arr2x2, 0))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr2x2, 0) + "Expect: false");
                               
                               
                               
        System.out.println("\n***** Qst 2 - search - 4x4 array *****");
        int[][] arr4x4 ={{1, 2, 5, 6},
                         {4, 3, 8, 7},
                         {13,14,9, 10},
                         {16,15,12,11}};
                         
        System.out.print("Test #1:......");
        if (search(arr4x4, 1))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 1) + "Expect: true");

        System.out.print("Test #2:......");
        if (search(arr4x4, 3))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 3) + "Expect: true");

        System.out.print("Test #3:......");
        if (search(arr4x4, 16))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 16) + "Expect: true");

        System.out.print("Test #4:......");
        if (search(arr4x4, 14))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 14) + "Expect: true");

        System.out.print("Test #5:......");
        if (search(arr4x4, 12))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 12) + "Expect: true");

        System.out.print("Test #6:......");
        if (search(arr4x4, 9))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 9) + "Expect: true");

        System.out.print("Test #7:......");
        if (search(arr4x4, 6))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 6) + "Expect: true");

        System.out.print("Test #8:......");
        if (search(arr4x4, 7))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 7) + "Expect: true");

        System.out.print("Test #9:......");
        if (!search(arr4x4, 17))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 17) + "Expect: false");

        System.out.print("Test #10:.....");
        if (!search(arr4x4, 0))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr4x4, 0) + "Expect: false");

        
        
        System.out.println("\n***** Qst 2 - search - 8x8 array *****");
        int[][] arr8x8 ={{1,2,5,6, 17, 18, 21, 22},
                         {4,3,8,7, 20, 19, 24, 23},
                         {13,14,9,10, 29,30,25,26},
                         {16,15,12,11,32,31,28,27},
                         {49,50,53,54,33,34,37,38},
                         {52,51,56,55,36,35,40,39},
                         {61,62,57,58,45,46,41,42},
                         {64,63,60,59,48,47,44,43}};
        
        System.out.print("Test #1:.......");
        if (search(arr8x8, 1))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 1) + "Expect: true");

        System.out.print("Test #2:.......");
        if (search(arr8x8, 4))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 4) + "Expect: true");

        System.out.print("Test #3:.......");
        if (search(arr8x8, 13))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 13) + "Expect: true");

        System.out.print("Test #4:.......");
        if (search(arr8x8, 16))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 16) + "Expect: true");

        System.out.print("Test #5:.......");
        if (search(arr8x8, 5))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 5) + "Expect: true");

        System.out.print("Test #6:.......");
        if (search(arr8x8, 8))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 8) + "Expect: true");

        System.out.print("Test #7:.......");
        if (search(arr8x8, 9))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 9) + "Expect: true");

        System.out.print("Test #8:.......");
        if (search(arr8x8, 12))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 12) + "Expect: true");

        System.out.print("Test #9:.......");
        if (search(arr8x8, 64))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 64) + "Expect: true");

        System.out.print("Test #10:......");
        if (search(arr8x8, 62))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 62) + "Expect: true");

        System.out.print("Test #11.......");
        if (search(arr8x8, 56))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 56) + "Expect: true");

        System.out.print("Test #12:......");
        if (search(arr8x8, 54))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 54) + "Expect: true");

        System.out.print("Test #13:......");
        if (search(arr8x8, 49))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 49) + "Expect: true");

        System.out.print("Test #14:......");
        if (search(arr8x8, 51))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 51) + "Expect: true");

        System.out.print("Test #15:......");
        if (search(arr8x8, 57))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 57) + "Expect: true");

        System.out.print("Test #16:......");
        if (search(arr8x8, 59))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 59) + "Expect: true");

        System.out.print("Test #17:......");
        if (search(arr8x8, 43))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 43) + "Expect: true");    

        System.out.print("Test #18:......");
        if (!search(arr8x8, 65))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 65) + "Expect: false");

        System.out.print("Test #19:......");
        if (!search(arr8x8, 0))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr8x8, 0) + "Expect: false");
           
            
        System.out.println("\n***** Qst 2 - search - 16x16 array *****");
        int[][] arr16x16 = {{1,  2,   5,  6,    17, 18,  21, 22,   65, 66,  69, 70,   81, 82,  85, 86}, 
                            {4,  3,   8,  7,    20, 19,  24, 23,   68, 67,  72, 71,   84, 83,  88, 87},
                            {13, 14,  9,  10,   29, 30,  25, 26,   77, 78,  73, 74,   93, 94,  89, 90},
                            {16, 15,  12, 11,   32, 31,  28, 27,   80, 79,  76, 75,   96, 95,  92, 91},
                            
                            {49, 50,  53, 54,   33, 34,  37, 38,   113, 114,  117, 118,   97,  98,   101, 102},
                            {52, 51,  56, 55,   36, 35,  40, 39,   116, 115,  120, 119,   100, 99,   104, 103},
                            {61, 62,  57, 58,   45, 46,  41, 42,   125, 126,  121, 122,   109, 110,  105, 106},
                            {64, 63,  60, 59,   48, 47,  44, 43,   128, 127,  124, 123,   112, 111,  108, 107},
                            
                            {193, 194,  197, 198,   209, 210,  213, 214,   129, 130,  133, 134,   145, 146,  149, 150},
                            {196, 195,  200, 199,   212, 211,  216, 215,   132, 131,  136, 135,   148, 147,  152, 151},
                            {205, 206,  201, 202,   221, 222,  217, 218,   141, 142,  137, 138,   157, 158,  153, 154},
                            {208, 207,  204, 203,   224, 223,  220, 219,   144, 143,  140, 139,   160, 159,  156, 155},
                            
                            {241, 242,  245, 246,   225, 226,  229, 230,   177, 178,  181, 182,   161, 162,  165, 166},
                            {244, 243,  248, 247,   228, 227,  232, 231,   180, 179,  184, 183,   164, 163,  168, 167},
                            {253, 254,  249, 250,   237, 238,  233, 234,   189, 190,  185, 186,   173, 174,  169, 170},
                            {256, 255,  252, 251,   240, 239,  236, 235,   192, 191,  188, 187,   176, 175,  172, 171}};
                        
        
        System.out.print("Test #1:.......");
        if (search(arr16x16, 1))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 1) + "Expect: true");

        System.out.print("Test #2:.......");
        if (search(arr16x16, 256))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 252) + "Expect: true");

        System.out.print("Test #3:.......");
        if (search(arr16x16, 86))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 86) + "Expect: true");

        System.out.print("Test #4:.......");
        if (search(arr16x16, 171))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 171) + "Expect: true");

        System.out.print("Test #5:.......");
        if (search(arr16x16, 3))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 3) + "Expect: true");
        
        System.out.print("Test #6:.......");
        if (search(arr16x16, 9))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 9) + "Expect: true");

        System.out.print("Test #7:.......");
        if (search(arr16x16, 11))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 11) + "Expect: true");

        System.out.print("Test #8:.......");
        if (search(arr16x16, 88))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 88) + "Expect: true");

        System.out.print("Test #9:.......");
        if (search(arr16x16, 94))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 94) + "Expect: true");

        System.out.print("Test #10:.......");
        if (search(arr16x16, 96))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 96) + "Expect: true");
        
        System.out.print("Test #11:.......");
        if (search(arr16x16, 169))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 169) + "Expect: true");

        System.out.print("Test #12:.......");
        if (search(arr16x16, 163))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 163) + "Expect: true");

        System.out.print("Test #13:.......");
        if (search(arr16x16, 161))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 161) + "Expect: true");

        System.out.print("Test #14:.......");
        if (search(arr16x16, 250))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 250) + "Expect: true");

        System.out.print("Test #15:.......");
        if (search(arr16x16, 244))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 244) + "Expect: true");
        
        System.out.print("Test #16:.......");
        if (search(arr16x16, 242))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 242) + "Expect: true");

        System.out.print("Test #17:.......");
        if (search(arr16x16, 43))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 43) + "Expect: true");

        System.out.print("Test #18:.......");
        if (search(arr16x16, 214))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 214) + "Expect: true");
        
        System.out.print("Test #19:.......");
        if (search(arr16x16, 128))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 128) + "Expect: true");

        System.out.print("Test #20:.......");
        if (search(arr16x16, 129))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 129) + "Expect: true");
            
        System.out.print("Test #21:.......");
        if (!search(arr16x16, 0))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 0) + "Expect: fasle");

        System.out.print("Test #22:.......");
        if (!search(arr16x16, 257))
            System.out.println("OK");
        else
            System.out.println("Error - your search: " + search(arr16x16, 257) + "Expect: false");
        
                    
            
            
            
            
        System.out.println("\n***** Qst 3 - equalSplit *****");
        
        arr = new int[]{-3, 5, 12, 14, -9, 13};
        System.out.print("Test #1:......");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
        
        arr = new int[]{-3, 5, -12, 14, -9, 13};
        System.out.print("Test #2:......");
        if (!equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: false");
            
        arr = new int[]{-3, 5, -12, 14, -9};
        System.out.print("Test #3:......");
        if (!equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: false");
        
        arr = new int[]{6, -3, 2, -5, 13, -7, -10, 4};    
        System.out.print("Test #4:......");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
        
        arr = new int[]{6, -3, 2, -5, 13, -7, 10, 4};
        System.out.print("Test #5:......");
        if (!equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: false");
            
        arr = new int[]{6, -3, 2, -5, 13, -10, 4};
        System.out.print("Test #6:......");
        if (!equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: false");
        
        arr = new int[]{4, 3, 1, 2};
        System.out.print("Test #7:......");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
        
        arr = new int[]{4, 2, 1, 3};
        System.out.print("Test #8:......");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
            
        arr = new int[]{4, 5, 8, 10, 7, 6};
        System.out.print("Test #9:......");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
            
        arr = new int [] {-3, 5, 12, 14, -9, 13};
        System.out.print("Test #10:.....");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
        
        arr = new int [] {1, 2, 3, 5, 8, -1, 2, 0};
        System.out.print("Test #11:.....");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
        
        arr = new int [] {-5, 7, 9, 5, 8, 4, -12, 0, -13, -7};
        System.out.print("Test #12:.....");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
            
        arr = new int [] {1, 2, 3, 3, 2, 1};
        System.out.print("Test #13:.....");
        if (equalSplit(arr))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + equalSplit(arr) + "Expect: true");
        
                    
            
            
            
            
        System.out.println("\n***** Qst 4 - isSpecial *****");
        System.out.print("Test #1 - 1:......");
        if (isSpecial(1))
            System.out.println("OK");
        else
            System.out.println("Error - your isSpecial: " + isSpecial(1) + "Expect: true");
        
        System.out.print("Test #2 - 2:......");
        if (!isSpecial(2))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + isSpecial(2) + "Expect: false");
        
        System.out.print("Test #3 - 3:......");
        if (isSpecial(3))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + isSpecial(3) + "Expect: true");
            
        System.out.print("Test #4 - 5:......");
        if (!isSpecial(5))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + isSpecial(5) + "Expect: false");
        
        System.out.print("Test #5 - 7:......");
        if (isSpecial(7))
            System.out.println("OK");
        else
            System.out.println("Error - your isSpecial: " + isSpecial(7) + "Expect: true");
        
        System.out.print("Test #6 - 10:......");
        if (!isSpecial(10))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + isSpecial(10) + "Expect: false");
        
        System.out.print("Test #7 - 13:......");
        if (isSpecial(13))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + isSpecial(13) + "Expect: true");
            
        System.out.print("Test #8 - 17:......");
        if (!isSpecial(17))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + isSpecial(17) + "Expect: false");
            
        System.out.print("Test #9 - 21:......");
        if (!isSpecial(21))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + isSpecial(21) + "Expect: false");
            
        System.out.print("Test #10 - 25:......");
        if (isSpecial(27))
            System.out.println("OK");
        else
            System.out.println("Error - your equalSplit: " + isSpecial(27) + "Expect: false");
    }//End of Main
}//End of Test