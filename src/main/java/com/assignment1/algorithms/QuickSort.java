package com.assignment1.algorithms;

import java.util.Random;

public class QuickSort {

    private int recursionDepth;
    private int comparisons;
    private final Random random = new Random();

    public void sort(int[] array) {
        recursionDepth = 0;
        comparisons = 0;
        quickSort(array, 0, array.length - 1, 0);
    }

    private void quickSort(int[] array, int left, int right, int depth) {
        recursionDepth = Math.max(recursionDepth, depth);
        while (left < right) {
            int pivotIndex = left + random.nextInt(right - left + 1);
            int pivotNewIndex = partition(array, left, right, pivotIndex);

            if (pivotNewIndex - left < right - pivotNewIndex) {
                quickSort(array, left, pivotNewIndex - 1, depth + 1);
                left = pivotNewIndex + 1;
            } else {
                quickSort(array, pivotNewIndex + 1, right, depth + 1);
                right = pivotNewIndex - 1;
            }
        }
    }

    private int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            comparisons++;
            if (array[i] < pivotValue) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int getRecursionDepth() {
        return recursionDepth;
    }

    public int getComparisons() {
        return comparisons;
    }
}
