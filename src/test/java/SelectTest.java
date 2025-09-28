package com.assignment1.algorithms;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectTest {

    @Test
    void testRandomArray() {
        int[] array = {7, 2, 1, 8, 6, 3, 5, 4};
        Select select = new Select();
        for (int k = 0; k < array.length; k++) {
            int[] copy = Arrays.copyOf(array, array.length);
            Arrays.sort(copy);
            int expected = copy[k];
            int result = select.select(Arrays.copyOf(array, array.length), k);
            assertEquals(expected, result);
        }
    }

    @Test
    void testSingleElement() {
        int[] array = {42};
        Select select = new Select();
        assertEquals(42, select.select(array, 0));
    }

    @Test
    void testEmptyArray() {
        int[] array = {};
        Select select = new Select();
        try {
            select.select(array, 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            // ожидаемо
        }
    }
}
