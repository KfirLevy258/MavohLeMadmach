package MMN11;

import java.io.*;
import java.util.*;

/** Version 19-10-21 1.5 **/
public class Tester_11
{
    private static int count = 0;
    private static enum tests {TEST_1, TEST_2};
    private static LinkedList<AbstractMap.SimpleEntry<String, String>>  testsList;

    private static void createTest(tests numOfTest)
    {
        testsList = new LinkedList<AbstractMap.SimpleEntry<String, String>>();

        if(numOfTest == tests.TEST_1)
        {
            testsList.add(new AbstractMap.SimpleEntry<>("100000", "0 days 0:1:40 hours"));
            testsList.add(new AbstractMap.SimpleEntry<>("97490000", "1 days 3:4:50 hours"));
            testsList.add(new AbstractMap.SimpleEntry<>("97490738", "1 days 3:4:50 hours"));
            testsList.add(new AbstractMap.SimpleEntry<>("10", "0 days 0:0:0 hours"));
            testsList.add(new AbstractMap.SimpleEntry<>("1000", "0 days 0:0:1 hours"));
            testsList.add(new AbstractMap.SimpleEntry<>("3600000", "0 days 1:0:0 hours"));
            testsList.add(new AbstractMap.SimpleEntry<>("86400001", "1 days 0:0:0 hours"));
            testsList.add(new AbstractMap.SimpleEntry<>("86400000", "1 days 0:0:0 hours"));

            /* ----------------------------- Add more for test 1 here ----------------------------- */
        }
        else if(numOfTest == tests.TEST_2)
        {
            testsList.add(new AbstractMap.SimpleEntry<>("773", "User number is: 773\r\nDifference: 396\r\nReversed difference: 693\r\nSUCCEEDED"));
            testsList.add(new AbstractMap.SimpleEntry<>("654", "User number is: 654\r\nDifference: 198\r\nReversed difference: 891\r\nSUCCEEDED"));
            testsList.add(new AbstractMap.SimpleEntry<>("123", "User number is: 123\r\nDifference: 198\r\nReversed difference: 891\r\nSUCCEEDED"));
            testsList.add(new AbstractMap.SimpleEntry<>("100", "User number is: 100\r\nDifference: 99\r\nReversed difference: 990\r\nSUCCEEDED"));
            testsList.add(new AbstractMap.SimpleEntry<>("998", "User number is: 998\r\nDifference: 99\r\nReversed difference: 990\r\nSUCCEEDED"));
            testsList.add(new AbstractMap.SimpleEntry<>("981", "User number is: 981\r\nDifference: 792\r\nReversed difference: 297\r\nSUCCEEDED"));

            testsList.add(new AbstractMap.SimpleEntry<>("098", "The number you entered is not a 3 digit positive number"));
            testsList.add(new AbstractMap.SimpleEntry<>("-123", "The number you entered is not a 3 digit positive number"));
            testsList.add(new AbstractMap.SimpleEntry<>("858", "The first and the last digits of the number should be different"));
            testsList.add(new AbstractMap.SimpleEntry<>("999", "The first and the last digits of the number should be different"));

            /* ----------------------------- Add more for test 2 here ----------------------------- */
        }
        else
            System.out.println("Error in createTest number " + numOfTest);
    }

    public static void main(String[] args)
    {
        System.out.println("------------ BEGIN TEST Q1 ------------");
        runTest(tests.TEST_1);
        System.out.println("------------ End TEST Q1 ------------\n\n");

        System.out.println("------------ BEGIN TEST Q2 ------------");
        runTest(tests.TEST_2);
        System.out.println("------------ End TEST Q2 ------------");
    }

    private static void runTest(tests numOfTest)
    {
        createTest(numOfTest);
        count = 0;

        for (int i = 0; i < testsList.size(); i++)
            test(testsList.get(i).getKey(),testsList.get(i).getValue(), numOfTest);
    }

    private static void test(String input, String output, tests numOfTest)
    {
        count++;

        InputStream stdin = System.in;
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(b));
        try
        {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            if (numOfTest == tests.TEST_1)
                Milliseconds.main(new String[] {});
            else if(numOfTest == tests.TEST_2)
                Einstein.main(new String[] {});
            else
                System.out.println("Error in test number " + numOfTest);
        } catch (Exception e)
        {
            System.out.println("Error!!!");
        }
        finally
        {
            System.setIn(stdin);
            System.out.flush();
            System.setOut(old);
        }

        String outputStudent = b.toString();
//        System.out.println();
//        System.out.println(outputStudent);
//        System.out.println
        String matchOutput = "((.)*(\r\n)*)*" + output + "(\r\n)*";
        if (outputStudent.matches(matchOutput))
        {
            System.out.printf("%s %30s\n","Test #" + count, "\t\tPassed");
        }
        else
        {
            System.out.printf("\n%s %30s","Test #" + count, "\t\tFAILED!!!!\n");
            System.out.println("Input is:\n" + input);
            System.out.println("Student's output is:\n" + outputStudent);
            System.out.println("Output should be:\n" + output);
        }
    }
}