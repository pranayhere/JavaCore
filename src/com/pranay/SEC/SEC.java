package com.pranay.SEC;

import java.util.ArrayList;
class Point {
	public Point(double x, double y);  // construct a point (x, y)
	public void draw();                // draw point to standard draw
	public String toString();          // string representation
}

class Circle {
	public Circle(Point center, double radius)    // circle with given center and radius
	public Circle(Point p1, Point p2)             // circle with given 2 points on diameter
	public Circle(Point p1, Point p2, Point p3)   // circle with given 3 points on circumference
	public boolean contains(Point p)              // does circle contain the point on circumference or interior?
	public void draw()                            // draw circle to standard draw
	public String toString()                      // string representation
}

public class SEC { 

	public static void main(String[] args) {

		// scale coordinates and turn on animation mode
		StdDraw.setXscale(-1, +1);
		StdDraw.setYscale(-1, +1); 
		StdDraw.show(0);

		// read in points that the user clicks and draw the smallest enclosing circle
		ArrayList<Point> points = new ArrayList<Point>();
		while (true) {

			// wait for next point to be clicked and add that point
			while (!StdDraw.mousePressed()) {
				StdDraw.show(10);
			}
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			Point point = new Point(x, y);
			points.add(point);

			// convert ArrayList to array
			Point[] a = new Point[points.size()];
			for (int i = 0; i < points.size(); i++)
				a[i] =  points.get(i);

			// compute smallest enclosing circle
			Fast fast = new Fast(a);
			Circle circle = fast.sec();

			// draw points and smallest enclosing circle
			StdDraw.clear(StdDraw.WHITE);
			StdDraw.setPenColor(StdDraw.BLACK);
			for (Point p : points)
				p.draw();
			StdDraw.setPenColor(StdDraw.RED);
			circle.draw();
			StdDraw.show(0);
		}
	}
}