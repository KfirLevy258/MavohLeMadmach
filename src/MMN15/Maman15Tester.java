package MMN15;

/**
 * 
 *
 * @author Harel Erlich
 * @version 19/12/2021
 */
public class Maman15Tester
{
    public static void main (String [] args) {
        Point p1  = new Point (0,0);
        Point p2 = new Point (4,4);
        RectangleA rec1 = new RectangleA (p1, p2);
        
        Point p3  = new Point (2,1);
        Point p4 = new Point (4,4);
        RectangleA rec2 = new RectangleA (p3, p4);
        
        Point p5  = new Point (-1,5);
        Point p6 = new Point (6,6);
        RectangleA rec3 = new RectangleA (p5, p6);
        
        Point p7  = new Point (4,-2);
        Point p8 = new Point (6,-1);
        RectangleA rec4 = new RectangleA (p7, p8);
        
        Point p9  = new Point (3,0);
        Point p10 = new Point (4,2);
        RectangleA rec5 = new RectangleA (p9, p10);
        
        Point p11  = new Point (3,0);
        Point p12 = new Point (4,15);
        RectangleA rec6 = new RectangleA (p11, p12);
        
        int [] arr = new int [24];
        
        //check RectNode
        System.out.println ("**RectNode test**\n");
        //check RectNode first constructor, getRect and getNext
        System.out.print ("--Check first constructor, getRect and getNext--");
        RectNode rn1 = new RectNode (rec1);
        if (rec1.equals(rn1.getRect()) && rn1.getNext() == null) {
                  System.out.println (" **OK**");
                  arr[1] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[1] = 0;
        }
        
        //Check first constructor aliasing
        System.out.print ("--Check first constructor aliasing--");
        rec1.move(1,2);
        if (!(rec1.equals(rn1.getRect()))) {
                  System.out.println (" **OK**");
                  arr[2] = 1;
        }
        else {
            System.out.println ("**ERROR**");
            arr[2] = 0;
        }
        rec1.move(-1,-2);
        
        //check RectNode second constructor
        System.out.print ("--Check second constructor--");
        RectNode rn2 = new RectNode (rec2, rn1);
        if (rec2.equals(rn2.getRect()) && rn2.getNext().getRect().equals(rn1.getRect())) {
                  System.out.println (" **OK**");
                  arr[3] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[3] = 0;
        }
        
        //Check second constructor aliasing
        System.out.print ("--Check second constructor aliasing--");
        rec2.changeSides ();
        if (!(rec2.equals(rn2.getRect()))) {
                  System.out.println (" **OK**");
                  arr[4] = 1;
        }
        else {
            System.out.println ("**ERROR**");
            arr[4] = 0;
        }
        rec2.changeSides();
        
        
        //check RectNode copy constructor
        System.out.print ("--Check copy constructor--");
        RectNode rn3 = new RectNode (rn2);
        if (rec2.equals(rn3.getRect()) && rn3.getNext().getRect().equals(rn1.getRect())) {
            System.out.println (" **OK**");
            arr[5] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[5] = 0;
        }
        
        //check copy constructor aliasing
        System.out.print ("--Check copy constructor aliasing--");
        rn2.setRect(rec3);
        if (!(rn2.getRect().equals(rn3.getRect()))) {
            System.out.println (" **OK**");
            arr[6] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[6] = 0;
        }
        rn2.setRect(rec2);
        
        //check getRect aliasing
        System.out.print ("--Check getRect aliasing--");
        RectangleA rec30 = rn2.getRect();
        rec30.move(10,20);
        if (!(rn2.getRect().equals(rec30))) {
            System.out.println (" **OK**");
            arr[7] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[7] = 0;
        }
        
        //check setRec
        System.out.print ("--Check setRect--");
        RectNode rn4 = new RectNode (rec5, rn1);
        rn4.setRect(rec3);
        rn4.setNext(rn2);
        if (rn4.getRect().equals(rec3)) {
                System.out.println (" **OK-**");
                arr[8] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[8] = 0;
        }
        
        //check setRect aliasing
        System.out.print ("--Check setRect aliasing--");
        rec3.move(1,2);
        if (!(rn4.getRect().equals(rec3))) {
                System.out.println (" **OK**");
                arr[9] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[9] = 0;
        }
        rec3.move(-1,-2);
        
        //check setNext
        System.out.print ("--Check setNext--");
        
        if (rn4.getNext().getRect().equals(rec2)) {
                System.out.println (" **OK**\n\n");
                arr[10] = 1;
        }
        else {
            System.out.println (" **ERROR**\n\n");
            arr[10] = 0;
        }
        
        
        //create new list
        RectList list1 = new RectList ();
        list1.addRect(rec1);
        list1.addRect(rec2);
        list1.addRect(rec3);
        list1.addRect(rec4);
        list1.addRect(rec5);
        list1.addRect(rec6);
        
        //Check addRect and toString
        String s1 = "The list has 6 rectangles.\n" + 
        "1. Width=4 Height=4 PointSW=(0,0)\n" +
        "2. Width=2 Height=3 PointSW=(2,1)\n" +
        "3. Width=7 Height=1 PointSW=(-1,5)\n" +
        "4. Width=2 Height=1 PointSW=(4,-2)\n" + 
        "5. Width=1 Height=2 PointSW=(3,0)\n" +
        "6. Width=1 Height=15 PointSW=(3,0)\n";
        String s2 = list1.toString();
        System.out.println ("**RectList test**\n");
        System.out.print ("--Check addRect and toString--");
        if (s2.equals(s1)) {
           System.out.println (" **OK**");
           arr[11] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[11] = 0;
            System.out.println ("Your answer:\n" + list1);
            System.out.println ("Correct:\n" + s1);
        }
        
        
        System.out.print ("--Check howManyWithPoint--\n");
        Point sw1 = new Point (3,0);
        System.out.print ("check: " + sw1 + " poin");
        if (list1.howManyWithPoint(sw1) == 2) {
            System.out.println (" **OK**");
            arr[12] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[12] = 0;
            System.out.println ("Your answer: " + list1.howManyWithPoint(sw1));
            System.out.println ("Correct: 2\n");
        }
        
        
        Point sw2 = new Point (0,0);
        System.out.print ("check: " + sw2 + " poin");
        if (list1.howManyWithPoint(sw2) == 1) {
            System.out.println (" **OK**");
            arr[13] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[13] = 0;
            System.out.println ("Your answer: " + list1.howManyWithPoint(sw2));
            System.out.println ("Correct: 1\n");
        }
        
        
        Point sw3 = new Point (-1,5);
        System.out.print ("check: " + sw3 + " point");
        if (list1.howManyWithPoint(sw3) == 1) {
            System.out.println (" **OK**");
            arr[14] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[14] = 0;
            System.out.println ("Your answer: " + list1.howManyWithPoint(sw3));
            System.out.println ("Correct: 1\n");
        }
        
        
        Point sw4 = new Point (-1,9);
        System.out.print ("check: " + sw4 + " point");
        if (list1.howManyWithPoint(sw4) == 0) {
            System.out.println (" **OK**");
            arr[15] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[15] = 0;
            System.out.println ("Your answer: " + list1.howManyWithPoint(sw4));
            System.out.println ("Correct: 0\n");
        }
        
        
        //Check longestDiagonal
        System.out.print ("--check longestDiagonal--");
        double d1 = 15.033296378372908;
        
        if (list1.longestDiagonal() == d1) {
               System.out.println (" **OK**");
               arr[16] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[16] = 0;
            System.out.println ("Your answer: " + list1.longestDiagonal());
            System.out.println ("Correct: 15.033296378372908\n");
        }
        
        
        //check mostLeftRect
        System.out.print ("--check mostLeftRect--");
        Point p20 = new Point (-1,5);
        if (list1.mostLeftRect().equals(p20)) {
               System.out.println (" **OK**");
               arr[17] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[17] = 0;
            System.out.println ("Your answer: " + list1.mostLeftRect());
            System.out.println ("Correct: (-1,5)\n");
        }
        
        //check highestRect
        System.out.print ("--check highestRect--");
        Point p21 = new Point (4,15);
        if (list1.highestRect().equals(p21)) {
               System.out.println (" **OK**");
               arr[18] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[18] = 0;
            System.out.println ("Your answer: " + list1.highestRect());
            System.out.println ("Correct: (4,15)\n");
        }
        
        
        //check minimalContainer
        System.out.print ("--check minimalContainer--");
        Point p22 = new Point (-1,-2);
        Point p23 = new Point (6,15);
        RectangleA rec10 = new RectangleA (p22, p23);
        
        if (list1.minimalContainer().equals(rec10)) {
               System.out.println (" **OK**\n\n");
               arr[19] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[19] = 0;
            System.out.println ("Your answer: SW " + list1.minimalContainer().getPointSW() + " NE " 
                            + list1.minimalContainer().getPointNE());
            System.out.println ("Correct: SW (-1,-2) NE (6,15)\n\n");
        }
        
        
        //create empty new list 
        RectList list2 = new RectList ();
        
        //Check and toString
        String s3 = "The list has 0 rectangles.";
        String s4 = list2.toString();
        System.out.println ("**RectList test empty list**\n");
        System.out.print ("--Check toString--");
        if (s4.equals(s3)) {
           System.out.println (" **OK**");
           arr[20] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[20] = 0;
            System.out.println ("Your answer:\n" + list2);
            System.out.println ("Correct:\n" + s3);
        }
        
        
        //check mostLeftRect
        System.out.print ("--check mostLeftRect--");
        if (list2.mostLeftRect() == null) {
               System.out.println (" **OK**");
               arr[21] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[21] = 0;
            System.out.println ("Your answer: " + list2.mostLeftRect());
            System.out.println ("Correct: null\n");
        }
        
        
        //check highestRect
        System.out.print ("--check highestRect--");
        if (list2.highestRect() == null) {
               System.out.println (" **OK**");
               arr[22] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[22] = 0;
            System.out.println ("Your answer: " + list2.highestRect());
            System.out.println ("Correct: null\n");
        }
        
        
        //check minimalContainer
        System.out.print ("--check minimalContainer--");

        if (list2.minimalContainer() == null) {
               System.out.println (" **OK**\n\n");
               arr[23] = 1;
        }
        else {
            System.out.println (" **ERROR**");
            arr[23] = 0;
            System.out.println ("Your answer: " + list2.minimalContainer());
            System.out.println ("Correct: null\n\n");
        }
        
        
        int j = 0;
        for (int i = 1; i < arr.length;i++) {
            if (arr[i] == 1)
                j++;
        }
        System.out.println ( "******" + j + "/23 TESTS PASSED******");
    }
}//mischief managed ¯\_(ツ)_/¯
        
        
    
   
         
    

