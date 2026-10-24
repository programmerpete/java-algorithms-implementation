package com.jwetherell.algorithms.sorts;

/**
 * Merge sort is an O(n log n) comparison-based sorting algorithm. Most
 * implementations produce a stable sort, which means that the implementation
 * preserves the input order of equal elements in the sorted output. 
 * <p>
 * Family: Merging.<br>
 * Space: In-place.<br>
 * Stable: True.<br>
 * <p>
 * Average case = O(n*log n)<br>
 * Worst case = O(n*log n)<br>
 * Best case = O(n*log n)<br>
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge Sort (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> {

    public static enum SPACE_TYPE { IN_PLACE, NOT_IN_PLACE }

    private MergeSort() { }

    public static <T extends Comparable<T>> T[] sort(SPACE_TYPE type, T[] unsorted) {
        // One merge buffer for the whole sort instead of a fresh array per merge, which
        // turns O(n*log n) allocation into O(n).
        final T[] scratch = (type == SPACE_TYPE.NOT_IN_PLACE) ? (T[]) new Comparable[unsorted.length] : null;
        sort(type, 0, unsorted.length, unsorted, scratch);
        return unsorted;
    }

    private static <T extends Comparable<T>> void sort(SPACE_TYPE type, int start, int length, T[] unsorted, T[] scratch) {
        if (length > 2) {
            int aLength = length / 2;
            int bLength = length - aLength;
            sort(type, start, aLength, unsorted, scratch);
            sort(type, start + aLength, bLength, unsorted, scratch);
            if (type == SPACE_TYPE.IN_PLACE)
                mergeInPlace(start, aLength, start + aLength, bLength, unsorted);
            else
                mergeWithExtraStorage(start, aLength, start + aLength, bLength, unsorted, scratch);
        } else if (length == 2) {
            T e = unsorted[start + 1];
            if (e.compareTo(unsorted[start]) < 0) {
                unsorted[start + 1] = unsorted[start];
                unsorted[start] = e;
            }
        }
    }

    private static <T extends Comparable<T>> void mergeInPlace(int aStart, int aLength, int bStart, int bLength, T[] unsorted) {
        int i = aStart;
        int j = bStart;
        int aSize = aStart + aLength;
        int bSize = bStart + bLength;
        while (i < aSize && j < bSize) {
            T a = unsorted[i];
            T b = unsorted[j];
            if (b.compareTo(a) < 0) {
                // Shift everything to the right one spot
                System.arraycopy(unsorted, i, unsorted, i+1, j-i);
                unsorted[i] = b;
                i++;
                j++;
                aSize++;
            } else {
                i++;
            }
        }
    }

    private static <T extends Comparable<T>> void mergeWithExtraStorage(int aStart, int aLength, int bStart, int bLength, T[] unsorted, T[] output) {
        int count = 0;
        int i = aStart;
        int j = bStart;
        final int aSize = aStart + aLength;
        final int bSize = bStart + bLength;
        // Take from the right run when its element is <= the left run's, which is what
        // keeps the sort stable.
        while (i < aSize && j < bSize) {
            final T a = unsorted[i];
            final T b = unsorted[j];
            if (b.compareTo(a) <= 0) {
                output[count++] = b;
                j++;
            } else {
                output[count++] = a;
                i++;
            }
        }
        while (i < aSize)
            output[count++] = unsorted[i++];
        while (j < bSize)
            output[count++] = unsorted[j++];
        System.arraycopy(output, 0, unsorted, aStart, aLength + bLength);
    }
}
