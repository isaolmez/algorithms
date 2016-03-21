package com.isa.section1.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/***
 * Write a Point2D client that takes an integer value N from the command line,
 * generates N random points in the unit square, and computes the distance
 * separating the closest pair of points.
 */
public class Point2D {
	private double x;
	private double y;

	public Point2D() {

	}

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	private double distance(Point2D target) {
		double sum = Math.pow(target.getX() - this.getX(), 2)
				+ Math.pow(target.getY() - this.getY(), 2);
		double sumSqrt = Math.sqrt(sum);
		return sumSqrt;
	}
	
	public static double DistanceOfClosest(int number) {
		Random rand = new Random();
		Point2D[] pointArray = new Point2D[number];
		for (int i = 0; i < number; i++) {
			Point2D point = new Point2D(rand.nextDouble(), rand.nextDouble());
			pointArray[i] = point;
		}

		double min = 2.0;
		for (int i = 0; i < pointArray.length; i++) {
			Point2D firstPoint = pointArray[i];
			for (int k = i + 1; k < pointArray.length; k++) {
				Point2D secondPoint = pointArray[k];
				double distance = firstPoint.distance(secondPoint);
				if (distance < min) {
					min = distance;
				}
			}
		}

		return min;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the number of points to be generated: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String input = reader.readLine();
			int count = Integer.parseInt(input);
			System.out.println(DistanceOfClosest(count));
		} catch (IOException e) {
		}
	}
}
