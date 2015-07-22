import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArraySorterTest {

    private ArraySorter arraySorter = new ArraySorter();

    /**
     * Test that the method sorts at all
     */
    @Test
    public void testArraySorterSorts() {

        int[] testme = {0, 5, 7, 2};
        final int[] sorted = arraySorter.sort(testme);
        assertArrayEquals(new int[]{0, 2, 5, 7}, sorted);
    }

    /**
     * Test that the method does not change original order
     */
    @Test
    public void testArraySorterDoesNotChangeOriginal() {

        int[] testme = {0, 5, 7, 2};
        arraySorter.sort(testme);
        assertArrayEquals(new int[]{0, 5, 7, 2}, testme);
    }

    /**
     * Test negative values
     */
    @Test
    public void testArraySorterNegativeValues() {

        int[] testme = {0, 5, -7, 2};
        final int[] sorted = arraySorter.sort(testme);
        assertArrayEquals(new int[]{-7, 0, 2, 5}, sorted);
    }

    /**
     * Test duplicate value
     */
    @Test
    public void testArraySorterDuplicateValues() {

        int[] testme = {0, 5, 5, 7, 2, 2};
        final int[] sorted = arraySorter.sort(testme);
        assertArrayEquals(new int[]{0, 2, 2, 5, 5, 7}, sorted);
    }

    /**
     * Test  empty array
     */
    @Test
    public void testArraySorterEmptyArray() {

        int[] testme = {};
        final int[] sorted = arraySorter.sort(testme);
        assertArrayEquals(new int[]{}, sorted);
    }

    /**
     * Test array with only one entry
     */
    @Test
    public void testArraySorterOnlyOneEntry() {

        int[] testme = {0};
        final int[] sorted = arraySorter.sort(testme);
        assertArrayEquals(new int[]{0}, sorted);
    }
}