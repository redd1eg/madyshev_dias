package com.assignment1.algorithms;

public class MergeSort {

    private int[] buffer;
    private int recursionDepth;
    private int comparisons;

    public void sort(int[] array) {
        buffer = new int[array.length];
        recursionDepth = 0;
        comparisons = 0;
        mergeSort(array, 0, array.length - 1, 0);
    }

    private void mergeSort(int[] array, int left, int right, int depth) {
        recursionDepth = Math.max(recursionDepth, depth);
        if (right - left + 1 <= 16) {  // малый массив → вставочная сортировка
            insertionSort(array, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid, depth + 1);
        mergeSort(array, mid + 1, right, depth + 1);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        System.arraycopy(array, left, buffer, left, right - left + 1);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            comparisons++;
            if (buffer[i] <= buffer[j]) array[k++] = buffer[i++];
            else array[k++] = buffer[j++];
        }
        while (i <= mid) array[k++] = buffer[i++];
        while (j <= right) array[k++] = buffer[j++];
    }

    private void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                comparisons++;
            }
            array[j + 1] = key;
        }
    }

    public int getRecursionDepth() {
        return recursionDepth;
    }

    public int getComparisons() {
        return comparisons;
    }
}
