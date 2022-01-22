package MMN15;

/**
 * This class defines a RectList, a list of RectNode
 * @author Kfir Levy
 * @version 28/12/2021
 */
public class RectList {
    private RectNode _head;

    /**
     * Constructor that init's this._head to null
     * The time complexity of this function is O(1).
     * The space complexity of this function is O(1).
     */
    public RectList() {
        this._head = null;
    }

    /**
     * This function gets a RectangleA and adds it to the end of the RectList.
     * If the given RectangleA already exist in the RectList, we do nothing.
     * The time complexity of this function is O(n), n stands for the length of the array.
     * The space complexity of this function is O(1).
     * @param r The RectangleA to add to the RectList
     */
    public void addRect(RectangleA r) {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        if (node == null) {
            this._head = new RectNode(r); // Sets last RectNode to point to a new RectNode with r as his RectangleA
        } else {
            RectNode prev_node = this._head; // Copy the pointer so we won't lose the head
            while (node != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().equals(r)) { // If one of the RectNode's in the RectList has the value of r we do nothing
                    return;
                }
                prev_node = node;
                node = node.getNext();
            }
            prev_node.setNext(new RectNode(r)); // Sets last RectNode to point to a new RectNode with r as his RectangleA
        }
    }


    /**
     * This function count all the RectNode in RectList that their RectangleA SW point is the same as a given point.
     * If RectList is empty we return 0.
     * The time complexity of this function is O(n), n stands for the length of the array.
     * The space complexity of this function is O(1).
     * @param p The given South-West point to compare to
     * @return numberOfPointsThatMatch - Number of RectangleA that their SW point are the same as p
     */
    public int howManyWithPoint(Point p) {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        int numberOfPointsThatMatch = 0; // Counter of the points that are the same as p
        if (node != null) { // Check if the list is empty
            while (node != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getPointSW().equals(p)) { // Checks if this RectNode rectangle south-west point is the same as p
                    numberOfPointsThatMatch++;
                }
                node = node.getNext();
            }
        }
        return numberOfPointsThatMatch;
    }

    /**
     * This function check what is the largest diagonal line of all the RectangleA in RectList.
     * If RectList is empty we return 0.
     * The time complexity of this function is O(n) , n stands for the length of the array.
     * The space complexity of this function is O(1).
     * @return longestDiagonal - The longest diagonal in all the RectangleA in RectList.
     */
    public double longestDiagonal() {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        double longestDiagonal = 0; // Counter of the points that are the same as p
        if (node != null) { // Check if the list is empty
            while (node != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getDiagonalLength() > longestDiagonal) { // Checks if this RectNode diagonal is longer the longestDiagonal
                    longestDiagonal = node.getRect().getDiagonalLength();
                }
                node = node.getNext();
            }
        }
        return longestDiagonal;
    }

    /**
     * This function find the most left SW point in all the RectangleA in RectList.
     * If RectList is empty we return null.
     * The time complexity of this function is O(n), n stands for the length of the array.
     * The space complexity of this function is O(n), n stands for the length of the array.
     * @return mostSWPoint - the most left SW point in all the RectangleA in RectList.
     */
    public Point mostLeftRect() {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        if (node == null) { // Check if the list is empty
            return null;
        } else {
            Point mostLeftPoint = node.getRect().getPointSW(); // Init's the first point in the list as a reference
            while (node != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getPointSW().isLeft(mostLeftPoint)) { // Checks if this RectNode RectangleA SW point is left sided to mostLeftPoint
                    mostLeftPoint = new Point(node.getRect().getPointSW());
                }
                node = node.getNext();
            }
            return mostLeftPoint;
        }
    }

    /**
     * This function find the highest point in all the RectangleA in RectList.
     * If RectList is empty we return null.
     * The time complexity of this function is O(n), n stands for the length of the array.
     * The space complexity of this function is O(n), n stands for the length of the array.
     * @return highestPoint - the highest point in all the RectangleA in RectList.
     */
    public Point highestRect() {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        if (node == null) { // Check if the list is empty
            return null;
        } else {
            Point highestPoint = node.getRect().getPointNE(); // Init's the first point in the list as a reference
            while (node != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getPointNE().isAbove(highestPoint)) { // Checks if this RectNode RectangleA NE point is above to highestPoint
                    highestPoint = new Point(node.getRect().getPointNE());
                }
                node = node.getNext();
            }
            return highestPoint;
        }
    }

    // This function find the lowest point in all the RectangleA in RectList.
    // If RectList is empty we return null.
    // The time complexity of this function is O(n), n stands for the length of the array.
    // The space complexity of this function is O(n), n stands for the length of the array.
    private Point lowestRect() {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        if (node == null) { // Check if the list is empty
            return null;
        } else {
            Point lowestPoint = node.getRect().getPointSW(); // Init's the first point in the list as a reference
            while (node != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getPointSW().isUnder(lowestPoint)) { // Checks if this RectNode RectangleA SW point is under lowestPoint
                    lowestPoint = new Point(node.getRect().getPointSW());
                }
                node = node.getNext();
            }
            return lowestPoint;
        }
    }

    // This function find the most right point in all the RectangleA in RectList.
    // If RectList is empty we return null.
    // The time complexity of this function is O(n), n stands for the length of the array.
    //The space complexity of this function is O(n), n stands for the length of the array.
    public Point mostRightRect() {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        if (node == null) { // Check if the list is empty
            return null;
        } else {
            Point mostRightPoint = node.getRect().getPointNE(); // Init's the first point in the list as a reference
            while (node != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getPointNE().isRight(mostRightPoint)) { // Checks if this RectNode RectangleA NE point is right sided to mostRightPoint
                    mostRightPoint = new Point(node.getRect().getPointNE());
                }
                node = node.getNext();
            }
            return mostRightPoint;
        }
    }

    /**
     * This function returns the minimal rectangle that contains all the rectangles in RectList.
     * If RectList is empty we return null.
     * The time complexity of this function is O(n), n stands for the length of the array.
     * The space complexity of this function is O(n), n stands for the length of the array.
     * @return a new RectangleA, the minimal rectangle that contains all the rectangles in RectList.
     */
    public RectangleA minimalContainer() {
        if (this._head == null) {
            return null;
        } else {
            Point rectangleSWPoint = new Point(this.mostLeftRect().getX(), this.lowestRect().getY());
            Point rectangleNEPoint = new Point(this.mostRightRect().getX(), this.highestRect().getY());
            return new RectangleA(rectangleSWPoint, rectangleNEPoint);
        }
    }

    /**
     * This function return a string of all Rectangles in RectList in a specific format.
     * The time complexity of this function is O(n), n stands for the length of the array.
     * The space complexity of this function is O(1).
     * @return stringToReturn - all Rectangles in RectList in a specific format.
     */
    public String toString() {
        String listOfAllRectangles = "";
        int counter = 0;
        RectNode node = this._head;
        while (node != null) {
            counter ++;
            listOfAllRectangles += "\n" + counter + ". " + node.getRect().toString();
            node = node.getNext();
        }
        return "The list has " + counter + " rectangles." + listOfAllRectangles;
    }
}
