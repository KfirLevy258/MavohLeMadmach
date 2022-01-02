package MMN15;

import MMN12.Point;
import MMN12.RectangleA;

/**  kilroy
 *               _____   here
 *         was  /     \    
 *     ____    /(.) (.)\    ____
 * ---/    \------| |------/    \---
 *    |/\/\/      | |      |/\/\/
 *                \_/  
 *   created by B.A.
 *   version: v1.0
 */
public class RectNodeTester
{
    public static void main(String[] args)
    {
        RectangleA temp;
        String answer = "";
        
        
        System.out.println("***** RectNode Test *****");
        System.out.println("***** First constructur + getRect test *****");
        RectangleA rec = new RectangleA(2,2);
        RectNode node1 = new RectNode(rec);
        
        answer = node1.getRect().toString();
        if(answer.equals("Width=2 Height=2 PointSW=(0,0)"))
            System.out.println("PASSED");
        else
            System.out.println("Error - your rec: " + node1.getRect().toString() + " Should be: Width=2 Height=2 PointSW=(0,0)");
        
        
            
        System.out.println("\n***** Secound constructur + getNext test *****");
        rec = new RectangleA(3,4);
        RectNode node2 = new RectNode(rec, node1);
        
        if (node2.getRect().toString().equals("Width=3 Height=4 PointSW=(0,0)") &&
            node2.getNext().getRect().toString().equals("Width=2 Height=2 PointSW=(0,0)"))
            System.out.println("PASSED");
        else{
            System.out.println("Error - current rec: " + node2.getRect().toString() + " Should be: Width=3 Height=4 PointSW=(0,0)");
            System.out.println("Next node rec: " + node2.getNext().getRect().toString() + " Should be: Width=2 Height=2 PointSW=(0,0)");
        }
        
        
        System.out.println("\n***** Third constructur test *****");
        node2 = new RectNode(node1);
        
        if (node2.getRect().toString().equals("Width=2 Height=2 PointSW=(0,0)") && node2.getNext() == null)
            System.out.println("PASSED");
        else
            System.out.println("Error - current rec: " + node2.getRect().toString() + " Should be: Width=2 Height=2 PointSW=(0,0)");
            
        
        System.out.println("\n***** Methods *****");
        
        System.out.print("setRect:.....");
        Point p1 = new Point(2, 3);
        rec = new RectangleA(p1, 3, 4);
        node1.setRect(rec);
        
        answer = node1.getRect().toString();
        if(answer.equals("Width=3 Height=4 PointSW=(2,3)"))
            System.out.println("OK");
        else
            System.out.println("Error - your rec: " + node1.getRect().toString() + " Should be: Width=3 Height=4 PointSW=(2,3)");
        
        
        System.out.print("setNext:.....");
        rec = new RectangleA(1, 2);
        node1 = new RectNode(rec);
        node2.setNext(node1);
        
        if(node2.getNext().getRect().toString().equals("Width=1 Height=2 PointSW=(0,0)"))
            System.out.println("OK");
        else
            System.out.println("Error - your next node is: " + node2.getNext().getRect().toString() + " Should be: Width=1 Height=2 PointSW=(0,0)");
        
        
        
        //************************************************************************
        System.out.println("\n\n***** RectList Test *****");
        
        System.out.println("***** Constructur test *****");
        RectList list = new RectList();
        RectList emptyList = new RectList();
        RectList singleList = new RectList();
        System.out.println("PASSED");
        
        
        System.out.println("\n***** Methods *****");
        
        
        list.addRect(new RectangleA(new Point(3,1), 5, 3));
        list.addRect(new RectangleA(new Point(3,1), 3, 5));
        list.addRect(new RectangleA(new Point(1,7), 3, 2));
        list.addRect(new RectangleA(new Point(5,7), 2, 3));
        list.addRect(new RectangleA(new Point(3,1), 5, 3));
        list.addRect(new RectangleA(new Point(5,7), 2, 3));
        list.addRect(new RectangleA(new Point(3,1), 3, 5));
        
        singleList.addRect(new RectangleA(new Point(1,1), 2, 3));
        
        System.out.print("addRect + toString test #1:.....");
        if(list.toString().equals("The list has 4 rectangles.\n1. Width=5 Height=3 PointSW=(3,1)\n2. Width=3 Height=5 PointSW=(3,1)\n3. Width=3 Height=2 PointSW=(1,7)\n4. Width=2 Height=3 PointSW=(5,7)"))
            System.out.println("OK");
        else
            System.out.println("Error - your toString is:\n" + list.toString() + "\nShould be:\nThe list has 4 rectangles.\n1. Width=5 Height=3 PointSW=(3,1)\n2. Width=3 Height=5 PointSW=(3,1)\n3. Width=3 Height=2 PointSW=(1,7)\n4. Width=2 Height=3 PointSW=(5,7)\n");
        
        System.out.print("addRect + toString test #2:.....");
        if(emptyList.toString().equals("The list has 0 rectangles."))
            System.out.println("OK");
        else
            System.out.println("Error - your toString is:\n" + emptyList.toString() + "\nShould be:\nThe list has 0 rectangles.");
        
        System.out.print("addRect + toString test #3:.....");
        if(singleList.toString().equals("The list has 1 rectangles.\n1. Width=2 Height=3 PointSW=(1,1)"))
            System.out.println("OK");
        else
            System.out.println("Error - your toString is:\n" + singleList.toString() + "\nShould be:\nThe list has 1 rectangles.\n1. Width=2 Height=3 PointSW=(1,1)\n");
        
        
        System.out.print("\nhowManyWithPoint #1:............");
        if(list.howManyWithPoint(new Point(3,1)) == 2)
            System.out.println("OK");
        else
            System.out.println("Error - your howManyWithPoint is: " + list.howManyWithPoint(new Point(3,1)) + " Should be: 2");
        
        System.out.print("howManyWithPoint #2:............");
        if(list.howManyWithPoint(new Point(1,7)) == 1)
            System.out.println("OK");
        else
            System.out.println("Error - your howManyWithPoint is: " + list.howManyWithPoint(new Point(1,7)) + " Should be: 1");
        
        System.out.print("howManyWithPoint #3:............");
        if(list.howManyWithPoint(new Point(1,1)) == 0)
            System.out.println("OK");
        else
            System.out.println("Error - your howManyWithPoint is: " + list.howManyWithPoint(new Point(1,1)) + " Should be: 0");
        
        System.out.print("howManyWithPoint #4:............");
        if(emptyList.howManyWithPoint(new Point(3,1)) == 0)
            System.out.println("OK");
        else
            System.out.println("Error - your howManyWithPoint is: " + emptyList.howManyWithPoint(new Point(3,1)) + " Should be: 0");
        
        System.out.print("howManyWithPoint #5:............");
        if(singleList.howManyWithPoint(new Point(1,1)) == 1)
            System.out.println("OK");
        else
            System.out.println("Error - your howManyWithPoint is: " + singleList.howManyWithPoint(new Point(1,1)) + " Should be: 1");
        
        System.out.print("howManyWithPoint #6:............");
        if(singleList.howManyWithPoint(new Point(3,1)) == 0)
            System.out.println("OK");
        else
            System.out.println("Error - your howManyWithPoint is: " + singleList.howManyWithPoint(new Point(3,1)) + " Should be: 0");
        
        
        System.out.print("\nlongestDiagonal #1:.............");
        if(list.longestDiagonal() == 5.830951894845301)
            System.out.println("OK");
        else
            System.out.println("Error - your longestDiagonal is: " + list.longestDiagonal() + " Should be: 5.830951894845301");
        
        System.out.print("longestDiagonal #2:.............");
        if(emptyList.longestDiagonal() == 0)
            System.out.println("OK");
        else
            System.out.println("Error - your longestDiagonal is: " + emptyList.longestDiagonal() + " Should be: 0");
        
        System.out.print("longestDiagonal #3:.............");
        if(singleList.longestDiagonal() == 3.605551275463989)
            System.out.println("OK");
        else
            System.out.println("Error - your longestDiagonal is: " + singleList.longestDiagonal() + " Should be: 3.605551275463989");
        
        
        System.out.print("\nmostLeftRect #1:................");
        if(list.mostLeftRect().toString().equals("(1,7)"))
            System.out.println("OK");
        else
            System.out.println("Error - your mostLeftRect is: " + list.mostLeftRect() + " Should be: (1,7)");
        
        System.out.print("mostLeftRect #2:................");
        if(emptyList.mostLeftRect() == null)
            System.out.println("OK");
        else
            System.out.println("Error - your mostLeftRect is: " + emptyList.mostLeftRect() + " Should be: null");
        
        System.out.print("mostLeftRect #3:................");
        if(singleList.mostLeftRect().toString().equals("(1,1)"))
            System.out.println("OK");
        else
            System.out.println("Error - your mostLeftRect is: " + singleList.mostLeftRect() + " Should be: (1,1)");
        
        
        System.out.print("\nhighestRect #1:.................");
        if(list.highestRect().toString().equals("(7,10)"))
            System.out.println("OK");
        else
            System.out.println("Error - your highestRect is: " + list.highestRect() + " Should be: (7,10)");
        
        System.out.print("highestRect #2:.................");
        if(emptyList.highestRect() == null)
            System.out.println("OK");
        else
            System.out.println("Error - your highestRect is: " + list.highestRect() + " Should be: null");
        
        System.out.print("highestRect #3:.................");
        if(singleList.highestRect().toString().equals("(3,4)"))
            System.out.println("OK");
        else
            System.out.println("Error - your highestRect is: " + singleList.highestRect() + " Should be: (3,4)");
        
        
        System.out.print("\nminimalContainer #1:............");
        if(list.minimalContainer().toString().equals("Width=7 Height=9 PointSW=(1,1)"))
            System.out.println("OK");
        else
            System.out.println("Error - your minimalContainer is: " + list.minimalContainer() + " Should be: Width=7 Height=9 PointSW=(1,1)");
        
        System.out.print("minimalContainer #2:............");
        if(emptyList.minimalContainer() == null)
            System.out.println("OK");
        else
            System.out.println("Error - your minimalContainer is: " + list.minimalContainer() + " Should be: null");
        
        System.out.print("minimalContainer #3:............");
        if(singleList.minimalContainer().toString().equals("Width=2 Height=3 PointSW=(1,1)"))
            System.out.println("OK");
        else
            System.out.println("Error - your minimalContainer is: " + singleList.minimalContainer() + " Should be: Width=2 Height=3 PointSW=(1,1)");
    }
}
