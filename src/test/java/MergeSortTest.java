package com.assignment1.algorithms;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    @Test
    void testRandomArray() {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);

        MergeSort sorter = new MergeSort();
        sorter.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = Arrays.copyOf(array, array.length);

        MergeSort sorter = new MergeSort();
        sorter.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testReversedArray() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);

        MergeSort sorter = new MergeSort();
        sorter.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testEmptyArray() {
        int[] array = {};
        int[] expected = {};

        MergeSort sorter = new MergeSort();
        sorter.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSingleElement() {
        int[] array = {42};
        int[] expected = {42};

        MergeSort sorter = new MergeSort();
        sorter.sort(array);

        assertArrayEquals(expected, array);
    }
}
