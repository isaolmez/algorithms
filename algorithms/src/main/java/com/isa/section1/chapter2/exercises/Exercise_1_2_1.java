package com.isa.section1.chapter2.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.isa.section1.chapter2.Point2D;

/***
 * Write a Point2D client that takes an integer value N from the command line, generates N random points in the unit square, and computes the distance separating the closest pair
 * of points.
 */
public class Exercise_1_2_1 {
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
				double distance = firstPoint.distanceTo(secondPoint);
				if (distance < min) {
					min = distance;
				}
			}
		}

		return min;
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of points to be generated: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = reader.readLine();
			int count = Integer.parseInt(input);
			System.out.println(DistanceOfClosest(count));
		} catch (IOException e) {
		}
	}
}
