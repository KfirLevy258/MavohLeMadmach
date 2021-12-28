package MMN15;
import MMN12.Point;
import MMN12.RectangleA;

/**
 * This class defines a RectList, a list of RectNode
 * @author Kfir Levy
 * @version 28/12/2021
 */
public class RectList {
    private RectNode _head;

    /**
     * Constructor that init's this._head to null
     */
    public RectList() {
        this._head = null;
    }

    /**
     * This function gets a RectangleA and adds it to the end of the RectList.
     * If the given RectangleA already exist in the RectList, we do nothing.
     * @param r The RectangleA to add to the RectList
     */
    public void addRect(RectangleA r) {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        while (node.getNext() != null) { // While we are not in the last RectNode, keep going
            if (node.getRect().equals(r)) { // If one of the RectNode's in the RectList has the value of r we do nothing
                return;
            }
        }
        node.setNext(new RectNode(r)); // Sets last RectNode to point to a new RectNode with r as his RectangleA
    }

    /**
     * This function count all the RectNode in RectList that their RectangleA SW point is the same as a given point.
     * If RectList is empty we return 0.
     * @param p The given South-West point to compare to
     * @return numberOfPointsThatMatch - Number of RectangleA that their SW point are the same as p
     */
    public int howManyWithPoint(Point p) {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        int numberOfPointsThatMatch = 0; // Counter of the points that are the same as p
        if (node != null) { // Check if the list is empty
            while (node.getNext() != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getPointSW().equals(p)) { // Checks if this RectNode rectangle south-west point is the same as p
                    numberOfPointsThatMatch++;
                }
            }
        }
        return numberOfPointsThatMatch;
    }

    /**
     * This function check what is the largest diagonal line of all the RectangleA in RectList.
     * If RectList is empty we return 0.
     * @return longestDiagonal - The longest diagonal in all the RectangleA in RectList.
     */
    public double longestDiagonal() {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        double longestDiagonal = 0; // Counter of the points that are the same as p
        if (node != null) { // Check if the list is empty
            while (node.getNext() != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getDiagonalLength() > longestDiagonal) { // Checks if this RectNode diagonal is longer the longestDiagonal
                    longestDiagonal = node.getRect().getDiagonalLength();
                }
            }
        }
        return longestDiagonal;
    }

    /**
     * This function find the most left SW point in all the RectangleA in RectList.
     * If RectList is empty we return null.
     * @return mostSWPoint - the most left SW point in all the RectangleA in RectList.
     */
    public Point mostLeftRect() {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        if (node == null) { // Check if the list is empty
            return null;
        } else {
            Point mostLeftPoint = node.getRect().getPointSW(); // Init's the first point in the list as a reference
            while (node.getNext() != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getPointSW().isLeft(mostLeftPoint)) { // Checks if this RectNode RectangleA SW point is left sided to mostLeftPoint
                    mostLeftPoint = new Point(node.getRect().getPointSW());
                }
            }
            return mostLeftPoint;
        }
    }

    /**
     * This function find the highest point in all the RectangleA in RectList.
     * If RectList is empty we return null.
     * @return highestPoint - the highest point in all the RectangleA in RectList.
     */
    public Point highestRect() {
        RectNode node = this._head; // Copy the pointer so we won't lose the head
        if (node == null) { // Check if the list is empty
            return null;
        } else {
            Point highestPoint = node.getRect().getPointNE(); // Init's the first point in the list as a reference
            while (node.getNext() != null) { // While we are not in the last RectNode, keep going
                if (node.getRect().getPointNE().isAbove(highestPoint)) { // Checks if this RectNode RectangleA NE point is above to highestPoint
                    highestPoint = new Point(node.getRect().getPointNE());
                }
            }
            return highestPoint;
        }
    }

    /**
     * This function returns the minimal rectangle that contains all the rectangles in RectList.
     * If RectList is empty we return null.
     * @return a new RectangleA, the minimal rectangle that contains all the rectangles in RectList.
     */
    public RectangleA minimalContainer() {
        if (this._head == null) {
            return null;
        } else {
            return new RectangleA(this.mostLeftRect(), this.highestRect());
        }
    }
}
