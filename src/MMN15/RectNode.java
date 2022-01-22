package MMN15;

/**
 * This class defines a RectNode by RectangleA and a next RectNode
 * @author Kfir Levy
 * @version 28/12/2021
 */
public class RectNode {
    private RectangleA _rect;
    private RectNode _next;

    /**
     * Construct a RectNode with a given RectangleA and a null RectNode.
     * The time complexity of this function is O(1).
     * The space complexity of this function is O(1).
     * @param r The RectangleA to set.
     */
    public RectNode (RectangleA r) {
        this._rect = new RectangleA(r);
        this._next = null;
    }

    /**
     * Construct a RectNode with a given RectangleA and a given RectNode.
     * The time complexity of this function is O(1).
     * The space complexity of this function is O(1).
     * @param r The RectangleA to set.
     * @param n The RectNode to set.
     */
    public RectNode (RectangleA r, RectNode n) {
        this._rect = new RectangleA(r);
        this._next = n;
    }

    /**
     * Copy construct, gets a RectNode and copy his RectangleA and RectNode
     * The time complexity of this function is O(1).
     * The space complexity of this function is O(1).
     * @param r The RectNode to copy.
     */
    public RectNode (RectNode r) {
        this._rect = r.getRect();
        this._next = r.getNext();
    }

    /**
     * This function return a copy of this._rect
     * The time complexity of this function is O(1).
     * The space complexity of this function is O(1).
     */
    public RectangleA getRect() {
        return new RectangleA(this._rect);
    }

    /**
     * This function return a pointer of this._next
     * The time complexity of this function is O(1).
     * The space complexity of this function is O(1).
     */
    public RectNode getNext() {
        return this._next;
    }

    /**
     * This function copy a given RectangleA params and sets this._rect params accordingly
     * The time complexity of this function is O(1).
     * The space complexity of this function is O(1).
     * @param r The given RectangleA to copy his params
     */
    public void setRect(RectangleA r) {
        this._rect.setWidth(r.getWidth());
        this._rect.setHeight(r.getHeight());
        this._rect.setPointSW(r.getPointSW());
    }

    /**
     * This function gets a pointer sets this.next pointer accordingly
     * The time complexity of this function is O(1).
     * The space complexity of this function is O(1).
     * @param next
     */
    public void setNext(RectNode next) {
        this._next = next;
    }
}