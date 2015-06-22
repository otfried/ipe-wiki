package de.uniwue.smooth.draw;

import java.text.DecimalFormat;

/**
 * This class helps creating ipe-files in Java by providing functions for most
 * common objects. Currently supports: Mark, Rectangle, Path, Edge, Text
 * label, Circle, Circular Arc, Spline, Splinegon
 * 
 * Usage: The functions create an UML-String that corresponds to the specified
 * object in Ipe. Every file has to start with getIpePreamble(), followed by
 * getIpeConf(), and has to end with getIpeEnd().
 * 
 * @author Martin Fink
 * @author Philipp Kindermann
 */
public class IpeDraw {

	/**
	 * Draws a mark.
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @param shape
	 * 			  shape: disk, fdisk, circle, box, square, fsquare, cross
	 * @param color
	 *            color
	 * @param size
	 *            size: tiny, small, normal, large
	 * @return
	 */
	public static String drawIpeMark(int x, int y, String shape, String color, String size) {
		return "<use name=\"mark/" + shape + "(sx)\" pos=\"" + x + " " + y
				+ "\" size=\"" + size + "\" stroke=\"" + color + "\"/>\n";
	}
	
	/**
	 * Draws a mark with size "normal".
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @param shape
	 * 			  shape: disk, fdisk, circle, box, square, fsquare, cross
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpeMark(int x, int y, String shape, String color) {
		return drawIpeMark(x, y, shape, color, "normal");
	}

	/**
	 * Draws a mark with size "normal" and color "black".
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpeMark(int x, int y, String shape) {
		return drawIpeMark(x, y, shape, "black", "normal");
	}

	/**
	 * Draws a mark of shape "disk" with color "black" and size "normal".
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @return
	 */
	public static String drawIpeMark(int x, int y) {
		return drawIpeMark(x, y, "disk", "black", "normal");
	}

	/**
	 * Draws a rectangle.
	 * 
	 * @param x1
	 *            left-most x-coordinate
	 * @param y1
	 *            bottom-most y-coordinate
	 * @param x2
	 *            right-most x-coordinate
	 * @param y2
	 *            top-most y-coordinate
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @param dash
	 *            dash style: normal, dashed, dotted, dash dotted, dash dot
	 *            dotted
	 * @return
	 */
	public static String drawIpeBox(int x1, int y1, int x2, int y2,
			String color, String pen, String dash) {
		return "<path stroke=\"" + color + "\" pen=\"" + pen + "\" dash=\""
				+ dash + "\">\n " + x1 + " " + y2 + " m\n " + x1 + " " + y1
				+ " l\n " + x2 + " " + y1 + " l\n " + x2 + " " + y2
				+ " l\n h\n" + "</path>\n";
	}

	/**
	 * Draws an undashed rectangle.
	 * 
	 * @param x1
	 *            left-most x-coordinate
	 * @param y1
	 *            bottom-most y-coordinate
	 * @param x2
	 *            right-most x-coordinate
	 * @param y2
	 *            top-most y-coordinate
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @return
	 */
	public static String drawIpeBox(int x1, int y1, int x2, int y2,
			String color, String pen) {
		return drawIpeBox(x1, y1, x2, y2, color, pen, "normal");
	}

	/**
	 * Draws an undashed rectangle with pen width "normal".
	 * 
	 * @param x1
	 *            left-most x-coordinate
	 * @param y1
	 *            bottom-most y-coordinate
	 * @param x2
	 *            right-most x-coordinate
	 * @param y2
	 *            top-most y-coordinate
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpeBox(int x1, int y1, int x2, int y2, String color) {
		return drawIpeBox(x1, y1, x2, y2, color, "normal", "normal");
	}

	/**
	 * Draws an undashed rectangle with pen width "normal" and color "black".
	 * 
	 * @param x1
	 *            left-most x-coordinate
	 * @param y1
	 *            bottom-most y-coordinate
	 * @param x2
	 *            right-most x-coordinate
	 * @param y2
	 *            top-most y-coordinate
	 * @return
	 */
	public static String drawIpeBox(int x1, int y1, int x2, int y2) {
		return drawIpeBox(x1, y1, x2, y2, "black", "normal", "normal");
	}

	/**
	 * Draws a path between points.
	 * 
	 * @param x
	 *            x-coordinates of the points
	 * @param y
	 *            y-coordinates of the points
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @param dash
	 *            dash style: normal, dashed, dotted, dash dotted, dash dot
	 *            dotted
	 * @return
	 */
	public static String drawIpePath(int[] x, int[] y, String color,
			String pen, String dash) {
		String s = "<path stroke=\"" + color + "\" pen=\"" + pen + "\" dash=\""
				+ dash + "\">\n " + x[0] + " " + y[0] + " m\n ";
		for (int i = 1; i < x.length; i++) {
			s += x[i] + " " + y[i] + " l\n ";
		}
		s += "</path>\n";
		return s;
	}

	/**
	 * Draws an undashed path between points.
	 * 
	 * @param x
	 *            x-coordinates of the points
	 * @param y
	 *            y-coordinates of the points
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @return
	 */
	public static String drawIpePath(int[] x, int[] y, String color, String pen) {
		return drawIpePath(x, y, color, pen, "normal");
	}

	/**
	 * Draws an undashed path between points with pen width "normal".
	 * 
	 * @param x
	 *            x-coordinates of the points
	 * @param y
	 *            y-coordinates of the points
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpePath(int[] x, int[] y, String color) {
		return drawIpePath(x, y, color, "normal", "normal");
	}

	/**
	 * Draws an undashed path between points with pen width "normal" and color
	 * "black".
	 * 
	 * @param x
	 *            x-coordinates of the points
	 * @param y
	 *            y-coordinates of the points
	 * @return
	 */
	public static String drawIpePath(int[] x, int[] y) {
		return drawIpePath(x, y, "black", "normal", "normal");
	}

	/**
	 * Draws an edge between two points.
	 * 
	 * @param x1
	 *            x-coordinate of point 1
	 * @param y1
	 *            y-coordinate of point 1
	 * @param x2
	 *            x-coordinate of point 2
	 * @param y2
	 *            y-coordinate of point 2
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @param dash
	 *            dash style: normal, dashed, dotted, dash dotted, dash dot
	 *            dotted
	 * @return
	 */
	public static String drawIpeEdge(int x1, int y1, int x2, int y2,
			String color, String pen, String dash) {
		return drawIpePath(new int[] { x1, x2 }, new int[] { y1, y2 }, color,
				pen, dash);
	}

	/**
	 * Draws an undashed edge between two points.
	 * 
	 * @param x1
	 *            x-coordinate of point 1
	 * @param y1
	 *            y-coordinate of point 1
	 * @param x2
	 *            x-coordinate of point 2
	 * @param y2
	 *            y-coordinate of point 2
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @return
	 */
	public static String drawIpeEdge(int x1, int y1, int x2, int y2,
			String color, String pen) {
		return drawIpePath(new int[] { x1, x2 }, new int[] { y1, y2 }, color,
				pen);
	}

	/**
	 * Draws an undashed edge between two points with pen width "normal".
	 * 
	 * @param x1
	 *            x-coordinate of point 1
	 * @param y1
	 *            y-coordinate of point 1
	 * @param x2
	 *            x-coordinate of point 2
	 * @param y2
	 *            y-coordinate of point 2
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpeEdge(int x1, int y1, int x2, int y2,
			String color) {
		return drawIpePath(new int[] { x1, x2 }, new int[] { y1, y2 }, color);
	}

	/**
	 * Draws an undashed edge between two points with pen width "normal" and
	 * color "black".
	 * 
	 * @param x1
	 *            x-coordinate of point 1
	 * @param y1
	 *            y-coordinate of point 1
	 * @param x2
	 *            x-coordinate of point 2
	 * @param y2
	 *            y-coordinate of point 2
	 * @return
	 */
	public static String drawIpeEdge(int x1, int y1, int x2, int y2) {
		return drawIpePath(new int[] { x1, x2 }, new int[] { y1, y2 });
	}

	/**
	 * Places a text label at a specific point.
	 * 
	 * @param text
	 *            The text
	 * @param x
	 *            x-coordinate of the box
	 * @param y
	 *            y-coordinate of the box
	 * @param color
	 *            text-color
	 * @param size
	 *            text-size
	 * @return
	 */
	public static String writeIpeText(String text, int x, int y, String color,
			String size) {
		return "<text transformations=\"translations\" pos=\""
				+ x
				+ " "
				+ y
				+ "\" stroke=\""
				+ color
				+ "\" type=\"label\" width=\"190\" height=\"10\" depth=\"0\" valign=\"baseline\" size=\""
				+ size + "\">" + text + "</text>";
	}

	/**
	 * Places a text label at a specific point with normal text-size.
	 * 
	 * @param text
	 *            The text
	 * @param x
	 *            x-coordinate of the box
	 * @param y
	 *            y-coordinate of the box
	 * @param color
	 *            text-color
	 * @return
	 */
	public static String writeIpeText(String text, int x, int y, String color) {
		return writeIpeText(text, x, y, color, "normal");
	}

	/**
	 * Places a text label at a specific point with normal text-size and
	 * text-color "black".
	 * 
	 * @param text
	 *            The text
	 * @param x
	 *            x-coordinate of the box
	 * @param y
	 *            y-coordinate of the box
	 * @return
	 */
	public static String writeIpeText(String text, int x, int y) {
		return writeIpeText(text, x, y, "black", "normal");
	}

	/**
	 * Draws a circle.
	 * 
	 * @param x
	 *            x-coordinate of the center
	 * @param y
	 *            y-coordinate of the center
	 * @param radius
	 *            radius
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @param dash
	 *            dash style: normal, dashed, dotted, dash dotted, dash dot
	 *            dotted
	 * @return
	 */
	public static String drawIpeCircle(int x, int y, double radius,
			String color, String pen, String dash) {
		String sf = new DecimalFormat("####.000").format(radius);
		return "<path stroke=\"" + color + "\" pen=\"" + pen + "\" dash=\""
				+ dash + "\">\n " + sf + " 0 0 " + sf + " " + x + " " + y
				+ " e\n</path>\n";
	}

	/**
	 * Draws an undashed circle.
	 * 
	 * @param x
	 *            x-coordinate of the center
	 * @param y
	 *            y-coordinate of the center
	 * @param radius
	 *            radius
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @return
	 */
	public static String drawIpeCircle(int x, int y, double radius,
			String color, String pen) {
		return drawIpeCircle(x, y, radius, color, pen, "normal");
	}

	/**
	 * Draws an undashed circle with pen width "normal".
	 * 
	 * @param x
	 *            x-coordinate of the center
	 * @param y
	 *            y-coordinate of the center
	 * @param radius
	 *            radius
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpeCircle(int x, int y, double radius, String color) {
		return drawIpeCircle(x, y, radius, color, "normal", "normal");
	}

	/**
	 * Draws an undashed circle with pen width "normal" and color "black".
	 * 
	 * @param x
	 *            x-coordinate of the center
	 * @param y
	 *            y-coordinate of the center
	 * @param radius
	 *            radius
	 * @return
	 */
	public static String drawIpeCircle(int x, int y, double radius) {
		return drawIpeCircle(x, y, radius, "black", "normal", "normal");
	}

	/**
	 * Draws a circular arc in a mathematical positive sense.
	 * 
	 * @param xCenter
	 *            x-coordinate of the center
	 * @param yCenter
	 *            y-coordinate of the center
	 * @param xStart
	 *            x-coordinate of the starting point on the circle
	 * @param yStart
	 *            y-coordinate of the starting point on the circle
	 * @param xEnd
	 *            x-coordinate of the end point on the circle
	 * @param yEnd
	 *            y-coordinate of the end point on the circle
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @param dash
	 *            dash style: normal, dashed, dotted, dash dotted, dash dot
	 *            dotted
	 * @return
	 */
	public static String drawIpeCircularArc(int xCenter, int yCenter,
			int xStart, int yStart, int xEnd, int yEnd, String color,
			String pen, String dash) {
		double radius = Math.sqrt(Math.pow(xStart - xCenter, 2)
				+ Math.pow(yStart - yCenter, 2));
		String sf = new DecimalFormat("####.000").format(radius);
		return "<path stroke=\"" + color + "\" pen=\"" + pen + "\" dash=\""
				+ dash + "\">\n " + xStart + " " + yStart + " m\n " + sf
				+ " 0 0 " + sf + " " + xCenter + " " + yCenter + " " + xEnd
				+ " " + yEnd + " a\n</path>\n";
	}

	/**
	 * Draws an undashed circular arc in a mathematical positive sense.
	 * 
	 * @param xCenter
	 *            x-coordinate of the center
	 * @param yCenter
	 *            y-coordinate of the center
	 * @param xStart
	 *            x-coordinate of the starting point on the circle
	 * @param yStart
	 *            y-coordinate of the starting point on the circle
	 * @param xEnd
	 *            x-coordinate of the end point on the circle
	 * @param yEnd
	 *            y-coordinate of the end point on the circle
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @return
	 */
	public static String drawIpeCircularArc(int xCenter, int yCenter,
			int xStart, int yStart, int xEnd, int yEnd, String color, String pen) {
		return drawIpeCircularArc(xCenter, yCenter, xStart, yStart, xEnd, yEnd,
				color, pen, "normal");
	}

	/**
	 * Draws an undashed circular arc in a mathematical positive sense with pen
	 * width "normal".
	 * 
	 * @param xCenter
	 *            x-coordinate of the center
	 * @param yCenter
	 *            y-coordinate of the center
	 * @param xStart
	 *            x-coordinate of the starting point on the circle
	 * @param yStart
	 *            y-coordinate of the starting point on the circle
	 * @param xEnd
	 *            x-coordinate of the end point on the circle
	 * @param yEnd
	 *            y-coordinate of the end point on the circle
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpeCircularArc(int xCenter, int yCenter,
			int xStart, int yStart, int xEnd, int yEnd, String color) {
		return drawIpeCircularArc(xCenter, yCenter, xStart, yStart, xEnd, yEnd,
				color, "normal", "normal");
	}

	/**
	 * Draws an undashed circular arc in a mathematical positive sense with pen
	 * width "normal" and color "black".
	 * 
	 * @param xCenter
	 *            x-coordinate of the center
	 * @param yCenter
	 *            y-coordinate of the center
	 * @param xStart
	 *            x-coordinate of the starting point on the circle
	 * @param yStart
	 *            y-coordinate of the starting point on the circle
	 * @param xEnd
	 *            x-coordinate of the end point on the circle
	 * @param yEnd
	 *            y-coordinate of the end point on the circle
	 * @return
	 */
	public static String drawIpeCircularArc(int xCenter, int yCenter,
			int xStart, int yStart, int xEnd, int yEnd) {
		return drawIpeCircularArc(xCenter, yCenter, xStart, yStart, xEnd, yEnd,
				"black", "normal", "normal");
	}
	
	public static String drawIpeSemiCircle(int xStart, int yStart, int xEnd, int yEnd, String color) {
		int xCenter = (xStart + xEnd) / 2;
		int yCenter = (yStart + yEnd) / 2;
		return drawIpeCircularArc(xCenter, yCenter, xStart, yStart, xEnd, yEnd,
				color, "normal", "normal");
	}

	public static String drawIpeSemiCircle(int xStart, int yStart, int xEnd, int yEnd) {
		return drawIpeSemiCircle(xStart, yStart, xEnd, yEnd, "black");
	}

	/**
	 * Draws a spline.
	 * 
	 * @param x
	 *            x-coordinates of the control points.
	 * @param y
	 *            y-coordinates of the control points.
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @param dash
	 *            dash style: normal, dashed, dotted, dash dotted, dash dot
	 *            dotted
	 * @return
	 */
	public static String drawIpeSpline(int[] x, int[] y, String color,
			String pen, String dash) {
		String s = "<path stroke=\"" + color + "\" pen=\"" + pen + "\" dash=\""
				+ dash + "\">\n " + x[0] + " " + y[0] + " m";
		for (int i = 1; i < x.length; i++) {
			s += "\n " + x[i] + " " + y[i];
		}
		s += " s\n</path>\n";
		return s;
	}

	/**
	 * Draws an undashed spline.
	 * 
	 * @param x
	 *            x-coordinates of the control points.
	 * @param y
	 *            y-coordinates of the control points.
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @return
	 */
	public static String drawIpeSpline(int[] x, int[] y, String color,
			String pen) {
		return IpeDraw.drawIpeSpline(x, y, color, pen, "normal");
	}

	/**
	 * Draws an undashed spline with pen width "normal".
	 * 
	 * @param x
	 *            x-coordinates of the control points.
	 * @param y
	 *            y-coordinates of the control points.
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpeSpline(int[] x, int[] y, String color) {
		return IpeDraw.drawIpeSpline(x, y, color, "normal", "normal");
	}

	/**
	 * Draws an undashed spline with pen width "normal" and color "black".
	 * 
	 * @param x
	 *            x-coordinates of the control points.
	 * @param y
	 *            y-coordinates of the control points.
	 * @return
	 */
	public static String drawIpeSpline(int[] x, int[] y) {
		return IpeDraw.drawIpeSpline(x, y, "black", "normal", "normal");
	}

	/**
	 * Draws a splinegon.
	 * 
	 * @param x
	 *            x-coordinates of the control points.
	 * @param y
	 *            y-coordinates of the control points.
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @param dash
	 *            dash style: normal, dashed, dotted, dash dotted, dash dot
	 *            dotted
	 * @return
	 */
	public static String drawIpeSplinegon(int[] x, int[] y, String color,
			String pen, String dash) {
		String s = "<path stroke=\"" + color + "\" pen=\"" + pen + "\" dash=\""
				+ dash + "\">\n " + x[0] + " " + y[0];
		for (int i = 1; i < x.length; i++) {
			s += "\n " + x[i] + " " + y[i];
		}
		s += " u\n</path>\n";
		return s;
	}

	/**
	 * Draws an undashed splinegon.
	 * 
	 * @param x
	 *            x-coordinates of the control points.
	 * @param y
	 *            y-coordinates of the control points.
	 * @param color
	 *            color
	 * @param pen
	 *            pen width: normal, heavier, fat, ultrafat
	 * @return
	 */
	public static String drawIpeSplinegon(int[] x, int[] y, String color,
			String pen) {
		return IpeDraw.drawIpeSplinegon(x, y, color, pen, "normal");
	}

	/**
	 * Draws an undashed splinegon with pen width "normal".
	 * 
	 * @param x
	 *            x-coordinates of the control points.
	 * @param y
	 *            y-coordinates of the control points.
	 * @param color
	 *            color
	 * @return
	 */
	public static String drawIpeSplinegon(int[] x, int[] y, String color) {
		return IpeDraw.drawIpeSplinegon(x, y, color, "normal", "normal");
	}

	/**
	 * Draws an undashed splinegon with pen width "normal" and color "black".
	 * 
	 * @param x
	 *            x-coordinates of the control points.
	 * @param y
	 *            y-coordinates of the control points.
	 * @return
	 */
	public static String drawIpeSplinegon(int[] x, int[] y) {
		return IpeDraw.drawIpeSplinegon(x, y, "black", "normal", "normal");
	}

	/**
	 * Creates a new page.
	 * 
	 * @return
	 */
	public static String newPage() {
		return "</page>\n<page>\n<layer name=\"alpha\"/>\n<view layers=\"alpha\" active=\"alpha\"/>\n";
	}

	/**
	 * Closes the file.
	 * 
	 * @return
	 */
	public static String getIpeEnd() {
		return "</page>\n</ipe>\n";
	}

	/**
	 * The mandatory preamble for an ipe-file.
	 * 
	 * @return
	 */
	public static String getIpePreamble() {
		return "<?xml version=\"1.0\"?>\n    <!DOCTYPE ipe SYSTEM \"ipe.dtd\">\n    <ipe version=\"70005\" creator=\"Ipe 7.1.4\">\n    <info created=\"D:20131106154934\" modified=\"D:20131106160041\"/>\n    <preamble>\\usepackage[english]{babel}</preamble>\n";
	}

	/**
	 * Configuration of the standard objects in ipe.
	 * 
	 * @return
	 */
	public static String getIpeConf() {
		return "    <ipestyle name=\"basic\">\n    <symbol name=\"arrow/arc(spx)\">\n    <path stroke=\"sym-stroke\" fill=\"sym-stroke\" pen=\"sym-pen\">\n    0 0 m\n    -1 0.333 l\n    -1 -0.333 l\n    h\n    </path>\n    </symbol>\n    <symbol name=\"arrow/farc(spx)\">\n    <path stroke=\"sym-stroke\" fill=\"white\" pen=\"sym-pen\">\n    0 0 m\n    -1 0.333 l\n    -1 -0.333 l\n    h\n    </path>\n    </symbol>\n    <symbol name=\"mark/circle(sx)\" transformations=\"translations\">\n    <path fill=\"sym-stroke\">\n    0.6 0 0 0.6 0 0 e\n    0.4 0 0 0.4 0 0 e\n    </path>\n    </symbol>\n    <symbol name=\"mark/disk(sx)\" transformations=\"translations\">\n    <path fill=\"sym-stroke\">\n    0.6 0 0 0.6 0 0 e\n    </path>\n    </symbol>\n    <symbol name=\"mark/fdisk(sfx)\" transformations=\"translations\">\n    <group>\n    <path fill=\"sym-fill\">\n    0.5 0 0 0.5 0 0 e\n    </path>\n    <path fill=\"sym-stroke\" fillrule=\"eofill\">\n    0.6 0 0 0.6 0 0 e\n    0.4 0 0 0.4 0 0 e\n    </path>\n    </group>\n    </symbol>\n    <symbol name=\"mark/box(sx)\" transformations=\"translations\">\n    <path fill=\"sym-stroke\" fillrule=\"eofill\">\n    -0.6 -0.6 m\n    0.6 -0.6 l\n    0.6 0.6 l\n    -0.6 0.6 l\n    h\n    -0.4 -0.4 m\n    0.4 -0.4 l\n    0.4 0.4 l\n    -0.4 0.4 l\n    h\n    </path>\n    </symbol>\n    <symbol name=\"mark/square(sx)\" transformations=\"translations\">\n    <path fill=\"sym-stroke\">\n    -0.6 -0.6 m\n    0.6 -0.6 l\n    0.6 0.6 l\n    -0.6 0.6 l\n    h\n    </path>\n    </symbol>\n    <symbol name=\"mark/fsquare(sfx)\" transformations=\"translations\">\n    <group>\n    <path fill=\"sym-fill\">\n    -0.5 -0.5 m\n    0.5 -0.5 l\n    0.5 0.5 l\n    -0.5 0.5 l\n    h\n    </path>\n    <path fill=\"sym-stroke\" fillrule=\"eofill\">\n    -0.6 -0.6 m\n    0.6 -0.6 l\n    0.6 0.6 l\n    -0.6 0.6 l\n    h\n    -0.4 -0.4 m\n    0.4 -0.4 l\n    0.4 0.4 l\n    -0.4 0.4 l\n    h\n    </path>\n    </group>\n    </symbol>\n    <symbol name=\"mark/cross(sx)\" transformations=\"translations\">\n    <group>\n    <path fill=\"sym-stroke\">\n    -0.43 -0.57 m\n    0.57 0.43 l\n    0.43 0.57 l\n    -0.57 -0.43 l\n    h\n    </path>\n    <path fill=\"sym-stroke\">\n    -0.43 0.57 m\n    0.57 -0.43 l\n    0.43 -0.57 l\n    -0.57 0.43 l\n    h\n    </path>\n    </group>\n    </symbol>\n    <symbol name=\"arrow/fnormal(spx)\">\n    <path stroke=\"sym-stroke\" fill=\"white\" pen=\"sym-pen\">\n    0 0 m\n    -1 0.333 l\n    -1 -0.333 l\n    h\n    </path>\n    </symbol>\n    <symbol name=\"arrow/pointed(spx)\">\n    <path stroke=\"sym-stroke\" fill=\"sym-stroke\" pen=\"sym-pen\">\n    0 0 m\n    -1 0.333 l\n    -0.8 0 l\n    -1 -0.333 l\n    h\n    </path>\n    </symbol>\n    <symbol name=\"arrow/fpointed(spx)\">\n    <path stroke=\"sym-stroke\" fill=\"white\" pen=\"sym-pen\">\n    0 0 m\n    -1 0.333 l\n    -0.8 0 l\n    -1 -0.333 l\n    h\n    </path>\n    </symbol>\n    <symbol name=\"arrow/linear(spx)\">\n    <path stroke=\"sym-stroke\" pen=\"sym-pen\">\n    -1 0.333 m\n    0 0 l\n    -1 -0.333 l\n    </path>\n    </symbol>\n    <symbol name=\"arrow/fdouble(spx)\">\n    <path stroke=\"sym-stroke\" fill=\"white\" pen=\"sym-pen\">\n    0 0 m\n    -1 0.333 l\n    -1 -0.333 l\n    h\n    -1 0 m\n    -2 0.333 l\n    -2 -0.333 l\n    h\n    </path>\n    </symbol>\n    <symbol name=\"arrow/double(spx)\">\n    <path stroke=\"sym-stroke\" fill=\"sym-stroke\" pen=\"sym-pen\">\n    0 0 m\n    -1 0.333 l\n    -1 -0.333 l\n    h\n    -1 0 m\n    -2 0.333 l\n    -2 -0.333 l\n    h\n    </path>\n    </symbol>\n    <pen name=\"heavier\" value=\"0.8\"/>\n    <pen name=\"fat\" value=\"1.2\"/>\n    <pen name=\"ultrafat\" value=\"2\"/>\n    <symbolsize name=\"large\" value=\"5\"/>\n    <symbolsize name=\"small\" value=\"2\"/>\n    <symbolsize name=\"tiny\" value=\"1.1\"/>\n    <arrowsize name=\"large\" value=\"10\"/>\n    <arrowsize name=\"small\" value=\"5\"/>\n    <arrowsize name=\"tiny\" value=\"3\"/>\n    <color name=\"red\" value=\"1 0 0\"/>\n    <color name=\"green\" value=\"0 1 0\"/>\n    <color name=\"blue\" value=\"0 0 1\"/>\n    <color name=\"yellow\" value=\"1 1 0\"/>\n    <color name=\"orange\" value=\"1 0.647 0\"/>\n    <color name=\"gold\" value=\"1 0.843 0\"/>\n    <color name=\"purple\" value=\"0.627 0.125 0.941\"/>\n    <color name=\"gray\" value=\"0.745\"/>\n    <color name=\"brown\" value=\"0.647 0.165 0.165\"/>\n    <color name=\"navy\" value=\"0 0 0.502\"/>\n    <color name=\"pink\" value=\"1 0.753 0.796\"/>\n    <color name=\"seagreen\" value=\"0.18 0.545 0.341\"/>\n    <color name=\"turquoise\" value=\"0.251 0.878 0.816\"/>\n    <color name=\"violet\" value=\"0.933 0.51 0.933\"/>\n    <color name=\"darkblue\" value=\"0 0 0.545\"/>\n    <color name=\"darkcyan\" value=\"0 0.545 0.545\"/>\n    <color name=\"darkgray\" value=\"0.663\"/>\n    <color name=\"darkgreen\" value=\"0 0.392 0\"/>\n    <color name=\"darkmagenta\" value=\"0.545 0 0.545\"/>\n    <color name=\"darkorange\" value=\"1 0.549 0\"/>\n    <color name=\"darkred\" value=\"0.545 0 0\"/>\n    <color name=\"lightblue\" value=\"0.678 0.847 0.902\"/>\n    <color name=\"lightcyan\" value=\"0.878 1 1\"/>\n    <color name=\"lightgray\" value=\"0.827\"/>\n    <color name=\"lightgreen\" value=\"0.565 0.933 0.565\"/>\n    <color name=\"lightyellow\" value=\"1 1 0.878\"/>\n    <dashstyle name=\"dashed\" value=\"[4] 0\"/>\n    <dashstyle name=\"dotted\" value=\"[1 3] 0\"/>\n    <dashstyle name=\"dash dotted\" value=\"[4 2 1 2] 0\"/>\n    <dashstyle name=\"dash dot dotted\" value=\"[4 2 1 2 1 2] 0\"/>\n    <textsize name=\"large\" value=\"\\large\"/>\n    <textsize name=\"Large\" value=\"\\Large\"/>\n    <textsize name=\"LARGE\" value=\"\\LARGE\"/>\n    <textsize name=\"huge\" value=\"\\huge\"/>\n    <textsize name=\"Huge\" value=\"\\Huge\"/>\n    <textsize name=\"small\" value=\"\\small\"/>\n    <textsize name=\"footnote\" value=\"\\footnotesize\"/>\n    <textsize name=\"tiny\" value=\"\\tiny\"/>\n    <textstyle name=\"center\" begin=\"\\begin{center}\" end=\"\\end{center}\"/>\n    <textstyle name=\"itemize\" begin=\"\\begin{itemize}\" end=\"\\end{itemize}\"/>\n    <textstyle name=\"item\" begin=\"\\begin{itemize}\\item{}\" end=\"\\end{itemize}\"/>\n    <gridsize name=\"4 pts\" value=\"4\"/>\n    <gridsize name=\"8 pts (~3 mm)\" value=\"8\"/>\n    <gridsize name=\"16 pts (~6 mm)\" value=\"16\"/>\n    <gridsize name=\"32 pts (~12 mm)\" value=\"32\"/>\n    <gridsize name=\"10 pts (~3.5 mm)\" value=\"10\"/>\n    <gridsize name=\"20 pts (~7 mm)\" value=\"20\"/>\n    <gridsize name=\"14 pts (~5 mm)\" value=\"14\"/>\n    <gridsize name=\"28 pts (~10 mm)\" value=\"28\"/>\n    <gridsize name=\"56 pts (~20 mm)\" value=\"56\"/>\n    <anglesize name=\"90 deg\" value=\"90\"/>\n    <anglesize name=\"60 deg\" value=\"60\"/>\n    <anglesize name=\"45 deg\" value=\"45\"/>\n    <anglesize name=\"30 deg\" value=\"30\"/>\n    <anglesize name=\"22.5 deg\" value=\"22.5\"/>\n    <tiling name=\"falling\" angle=\"-60\" step=\"4\" width=\"1\"/>\n    <tiling name=\"rising\" angle=\"30\" step=\"4\" width=\"1\"/>\n    <layout paper=\"1000 1000\" origin=\"0 0\" frame=\"1000 1000\" skip=\"32\" crop=\"yes\"/>\n    </ipestyle>\n    <page>\n    <layer name=\"alpha\"/>\n    <view layers=\"alpha\" active=\"alpha\"/>\n";
	}
}