package MMN12;

/**
 * This class defines a Rectangle by point, width and height
 * @author Kfir Levy
 * @version 24/10/2021 
 */
public class RectangleA {
	private int _width;
	private int _height;
	private Point _pointSW;
	private final int DEFAULT_LENGTH_VALUE = 1;
	private final int DEFAULT_POINT_VALUE = 0;

	/**
	 * Construct a rectangle with default South-West point.
	 * If one of the parameters is negative then it should be initialized to one. 
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 */
	public RectangleA(int w, int h) {
		this._width = (w >= this.DEFAULT_LENGTH_VALUE) ? w : this.DEFAULT_LENGTH_VALUE; // Check width value is valid
		this._height = (h >= this.DEFAULT_LENGTH_VALUE) ? h : this.DEFAULT_LENGTH_VALUE; // Check height value is valid
		this._pointSW = new Point(this.DEFAULT_POINT_VALUE, this.DEFAULT_POINT_VALUE);
	}
	
	/**
	 * Construct a rectangle.
	 * @param p The SW point of the rectangle.
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 */
	public RectangleA(Point p, int w, int h) {
		this._pointSW = new Point(p); // We were instructed to assume that the object has already initialized and is not null
		this._width = (w >= this.DEFAULT_LENGTH_VALUE) ? w : this.DEFAULT_LENGTH_VALUE; // Check width value is valid
		this._height = (h >= this.DEFAULT_LENGTH_VALUE) ? h : this.DEFAULT_LENGTH_VALUE; // Check height value is valid
	}
	
	/**
	 * Construct a rectangle by two points.
	 * @param sw The South-West point of the rectangle.
	 * @param ne The North-East point of the rectangle.
	 */
	public RectangleA(Point sw, Point ne) {
		this._width = ne.getX() - sw.getX(); // Calculate the X delta
		this._height = ne.getY() - sw.getY(); // Calculate the Y delta
		this._pointSW = new Point(sw);
	}
	
	/**
	 * Construct a rectangle as a copy of the params of another rectangle.
	 * @param r The other rectangle to copy the params from
	 */
	public RectangleA(RectangleA r) {
		this._width = r.getWidth();
		this._height = r.getHeight();
		this._pointSW = r.getPointSW();
	}
	
	/**
	 * Return the width of the rectangle.
	 * @return The width of the rectangle.
	 */
	public int getWidth() {
		return this._width;
	}

	/**
	 * Return the height of the rectangle.
	 * @return The height of the rectangle.
	 */
	public int getHeight() {
		return this._height;
	}
	
	/**
	 * Return the SW point of the rectangle.
	 * @return The SW point of the rectangle.
	 */
	public Point getPointSW() {
		return new Point(this._pointSW);
	}
	
	/**
	 * Sets the width of the rectangle to the number assigned.
	 * If the param is not bigger then zero the value should not change.
	 * @param w The new value for the width of the rectangle.
	 */
	public void setWidth(int w) {
		this._width = (w >= this.DEFAULT_LENGTH_VALUE) ? w : this._width;
	}
	
	/**
	 * Sets the height of the rectangle to the number assigned.
	 * If the param is not bigger then zero the value should not change.
	 * @param h The new value for the height of the rectangle
	 */
	public void setHeight(int h) {
		this._height = (h >= this.DEFAULT_LENGTH_VALUE) ? h : this._height;
	}
	
	/**
	 * Sets the SW point of the rectangle to the point assigned.
	 * @param p The new value for the SW point.
	 */
	public void setPointSW(Point p) {
		this._pointSW = new Point(p);
	}
	
	/**
	 * Return a string of the rectangle width height and SW point.
	 * @return The point rectangle data.
	 */
	public String toString() { 
		return "Width=" + this._width + " Height=" + this._height + " PointSW=" + this._pointSW.toString();
	}

	/**
	 * Calculate the rectangle perimeter.
	 * @return The rectangle perimeter.
	 */
	public int getPerimeter() {
		return this._height * 2 + this._width * 2;
	}
	
	/**
	 * Calculate the rectangle area.
	 * @return The rectangle area
	 */
	public int getArea() {
		return this._height * this._width;
	}
	
	/**
	 * Moves the rectangle SW point to other X and Y.
	 * @param deltaX The change in X axis.
	 * @param deltaY The change in y axis.
	 */
	public void move(int deltaX, int deltaY) {
		this._pointSW.move(deltaX, deltaY);
	}
	
	/**
	 * Checks if this rectangle have the same parameters as other rectangle.
	 * @param other The rectangle to compare to.
	 * @return true if the rectangles are identical.
	 */
	public boolean equals(RectangleA other) {
		return (this._width == other._width && this._height == other._height && this._pointSW.equals(other._pointSW)); // Checks if the rectangles have the same parameters 
	}
	
	/**
	 * Calculate the rectangle diagonal length.
	 * @return The rectangle diagonal length.
	 */
	public double getDiagonalLength() {
		return this._pointSW.distance(this.getPointNE()); // Calculate the distance between the SW and NE points of the rectangle.
	}
	
	/**
	 * Checks if this rectangle has a bigger area then other rectangle.
	 * @param other The rectangle to compare the area to.
	 * @return true if this rectangle has a bigger area then the other rectangle.
	 */
	public boolean isLarger(RectangleA other) {
		return this.getArea() > other.getArea(); 
	}
	
	/**
	 * Calculate the rectangle NE point.
	 * @return the rectangle NE point.
	 */
	public Point getPointNE() {
		int neX = this._pointSW.getX() + this._width;
		int neY = this._pointSW.getY() + this._height;
		return new Point(neX, neY);
	}
	
	/**
	 * Changes the rectangle width to be height and height to be width.
	 */
	public void changeSides() {
		int tempWidth = this._width;
		this._width = this._height;
		this._height = tempWidth;
	}
	
	/**
	 * Checks if this rectangle fully contains another rectangle.
	 * Checks if both SW and NE points of this rectangle are in r rectangle.
	 * @param r The other rectangle to check if is in this rectangle.
	 * @return true if the other rectangle is in this rectangle.
	 */
	public boolean isIn(RectangleA r) {
		return r.checkPointInRange(this._pointSW) && r.checkPointInRange(this.getPointNE());
	}
	
	/**
	 * Checks if this rectangle partly contains another rectangle.
	 * Partly contains means that they are overlap even if they have only one point of contact.
	 * Checks if this rectangle inside the other rectangle or the opposite.
	 * @param r The other rectangle to check if is overlap with this rectangle. 
	 * @return true if the rectangles are overlap.
	 */
	public boolean overlap(RectangleA r) {
		return this.isInTouch(r) || r.isInTouch(this);
	}

	private boolean isInTouch(RectangleA r) {
		// This function check if this rectangle has any contact point with other rectangle.
		// The function calculate all the points of rectangle and check with checkPointInRange function if the point is in the range.
		// one of the points is in the range, its means that the rectangles having a contact point.
		Point sePoint = new Point(r.getPointSW().getX() + r.getWidth(), r.getPointSW().getY());
		Point nwPoint = new Point(r.getPointSW().getX(), r.getPointSW().getY() + r.getHeight());
		return (this.checkPointInRange(r.getPointSW()) || this.checkPointInRange(r.getPointNE()) ||
				this.checkPointInRange(sePoint) || this.checkPointInRange(nwPoint));
	}

	private boolean checkPointInRange(Point p) {
		// This function check if the given point is in the rectangle.
		// In the rectangle means evan if it's on the perimeter.
		// In order to check the option that the point is on the perimeter, im checking that the given point
		// is not under or left side to the SW point and not above or right side to the NE point.
		return (!this._pointSW.isAbove(p) && !this.getPointNE().isUnder(p) &&
				!this._pointSW.isRight(p) && !this.getPointNE().isLeft(p));
	}
	
}
