package com.assignment1.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosestPairTest {

    @Test
    void testSimpleArray() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(2, 2)
        };
        ClosestPair cp = new ClosestPair(points);
        double result = cp.findClosestDistance();
        assertEquals(Math.sqrt(2), result, 1e-9);
    }

    @Test
    void testRandomArray() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(2, 2),
                new ClosestPair.Point(1, 1)
        };
        ClosestPair cp = new ClosestPair(points);
        double result = cp.findClosestDistance();
        assertEquals(Math.sqrt(2), result, 1e-9);
    }

    @Test
    void testTwoPoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4)
        };
        ClosestPair cp = new ClosestPair(points);
        double result = cp.findClosestDistance();
        assertEquals(5.0, result, 1e-9);
    }

    @Test
    void testSinglePoint() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0)
        };
        ClosestPair cp = new ClosestPair(points);
        double result = cp.findClosestDistance();
        assertEquals(Double.POSITIVE_INFINITY, result);
    }
}
