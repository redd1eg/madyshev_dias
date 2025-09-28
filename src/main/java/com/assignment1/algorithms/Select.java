package com.assignment1.algorithms;

public class Select {

    private int comparisons;
    private int recursionDepth;

    public int select(int[] array, int k) {
        comparisons = 0;
        recursionDepth = 0;
        return deterministicSelect(array, 0, array.length - 1, k);
    }

    private int deterministicSelect(int[] array, int left, int right, int k) {
        recursionDepth++;
        if (left == right) return array[left];

        int pivotIndex = medianOfMedians(array, left, right);
        pivotIndex = partition(array, left, right, pivotIndex);

        int length = pivotIndex - left + 1;
        if (k == length - 1) return array[pivotIndex];
        else if (k < length - 1) return deterministicSelect(array, left, pivotIndex - 1, k);
        else return deterministicSelect(array, pivotIndex + 1, right, k - length);
    }

    private int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            comparisons++;
            if (array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right);
        return storeIndex;
    }

    private int medianOfMedians(int[] array, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            insertionSort(array, left, right);
            return left + n / 2;
        }

        int numMedians = (n + 4) / 5;
        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            insertionSort(array, subLeft, subRight);
            swap(array, left + i, subLeft + (subRight - subLeft) / 2);
        }

        return deterministicSelect(array, left, left + numMedians - 1, numMedians / 2);
    }

    private void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= left && array[j] > key) {
                comparisons++;
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getRecursionDepth() {
        return recursionDepth;
    }
}
