package com.assignment1.algorithms;

public class ClosestPair {

    public static class Point {
        public double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point[] points;

    // Конструктор с массивом точек
    public ClosestPair(Point[] points) {
        this.points = points;
    }

    // Метод для вычисления ближайшего расстояния
    public double findClosestDistance() {
        if (points == null || points.length < 2) return Double.POSITIVE_INFINITY;

        double minDist = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dx = points[i].x - points[j].x;
                double dy = points[i].y - points[j].y;
                double dist = Math.sqrt(dx*dx + dy*dy);
                if (dist < minDist) minDist = dist;
            }
        }
        return minDist;
    }
}
