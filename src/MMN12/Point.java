package MMN12;

import java.math.*;

/**
 * This class defines a point
 * @author Kfir Levy
 * @version 24/10/2021 
 */
public class Point {
	private int _x;
	private int _y;
	
	/**
	 * Construct a point.
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 */
	public Point(int x, int y) {
		this._x = x;
		this._y = y;
	}
	
	/**
	 * Construct a point as a copy of the params of another point.
	 * @param other The other pint to copy the params from
	 */
	public Point(Point other) {
		// We were instructed to assume that the object has already initialized and is not null
		this._x = other.getX();
		this._y = other.getY();
	}
	
	/**
	 * Return the X coordinate of the point.
	 * @return The X coordinate of the point.
	 */
	public int getX() {
		return this._x;
	}
	
	/**
	 * Return the Y coordinate of the point.
	 * @return The Y coordinate of the point.
	 */
	public int getY() {
		return this._y;
	}
	
	/**
	 * Sets the X coordinate of the point to the number assigned.
	 * @param num The new value for X coordinate of the point.
	 */
	public void setX(int num) {
		this._x = num;
	}
	
	/**
	 * Sets the Y coordinate of the point to the number assigned.
	 * @param num The new value for Y coordinate of the point.
	 */
	public void setY(int num) {
		this._y = num;
	}
	
	/**
	 * Return a string of the point coordinates.
	 * @return The point coordinates.
	 */
	public String toString() {
		return "(" + this._x + "," + this._y + ")";
	}
	
	/**
	 * Checks if the point coordinates is same as other point.
	 * @param other The point to check if the coordinates are equals to.
	 * @return true if the coordinates are the same.
	 */
	public boolean equals(Point other) {
		return (this._x == other._x && this._y == other._y); 
	}
	
	/** 
	 * Checks if the the point is above other point.
	 * @param other The point to compare to.
	 * @return true if the point is above other point.
	 */
	public boolean isAbove(Point other) {
		return this._y > other._y; 
	}
	
	/**
	 * Checks if the the point is under other point.
	 * @param other The point to compare to.
	 * @return true if the point is under other point.
	 */
	public boolean isUnder(Point other) {
		return other.isAbove(this);
	}
	
	/**
	 * Checks if the the point is left sided to other point.
	 * @param other The point to compare to.
	 * @return true if the point is left sided to other point.
	 */
	public boolean isLeft(Point other) {
		return this._x < other._x; 
	}
	
	/**
	 * Checks if the the point is right sided to other point.
	 * @param other The point to compare to.
	 * @return true if the point is right sided to other point.
	 */
	public boolean isRight(Point other) {
		return other.isLeft(this);
	}
	
	/**
	 * Moves the point to other X and Y.
	 * @param deltaX The change in X axis.
	 * @param deltaY The change in y axis.
	 */
	public void move(int deltaX, int deltaY) {
		this._x = this._x + deltaX;
		this._y = this._y + deltaY;
	}
	
	/**
	 * Calculate the distance between this point and other point.
	 * @param p The point to calculate the distance to.
	 * @return the distance between this point and other point.
	 */
	public double distance (Point p) {
		int deltaX = this._x - p._x;
		int deltaY = this._y - p._y;
		double xDistance = Math.pow(deltaX, 2);
		double yDistance = Math.pow(deltaY, 2);
		return Math.sqrt(xDistance + yDistance);
	}
}  // End of class point
