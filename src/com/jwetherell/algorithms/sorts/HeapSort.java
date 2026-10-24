package com.jwetherell.algorithms.sorts;

/**
 * Heapsort is a comparison-based sorting algorithm to create a sorted array (or
 * list), and is part of the selection sort family. Although somewhat slower in
 * practice on most machines than a well-implemented quicksort, it has the
 * advantage of a more favorable worst-case O(n log n) runtime. 
 * <p>
 * Family: Selection.<br>
 * Space: In-place.<br>
 * Stable: False.<br>
 * <p>
 * Average case = O(n*log n)<br>
 * Worst case = O(n*log n)<br>
 * Best case = O(n*log n)<br>
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Heap_sort">Heap Sort (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class HeapSort<T extends Comparable<T>> {

    private HeapSort() { }

    public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
        createHeap(unsorted);
        sortHeap(unsorted);
        return unsorted;
    }

    private static <T extends Comparable<T>> void sortHeap(T[] unsorted) {
        int length = unsorted.length;
        for (int index = length - 1; index > 0; index--) {
            swap(0, index, unsorted); // swap root with the last heap element
            siftDown(0, index, unsorted);
        }
    }

    private static <T extends Comparable<T>> void createHeap(T[] unsorted) {
        // Creates a max heap using Floyd's method: sift down every internal node from the
        // bottom up. This is O(n), versus the O(n*log n) of inserting each element with a
        // sift up, and it produces the same heap ordering guarantees.
        for (int i = (unsorted.length / 2) - 1; i >= 0; i--)
            siftDown(i, unsorted.length, unsorted);
    }

    /**
     * Move the element at index down the heap until both children are no greater than it.
     * The element being moved is held in a register and larger children are shifted up one
     * level at a time, which is one write per level instead of the two a swap needs.
     *
     * @param index of the element to move down.
     * @param end   index one past the last element of the heap.
     * @param unsorted array containing the heap.
     */
    private static <T extends Comparable<T>> void siftDown(int index, int end, T[] unsorted) {
        final T value = unsorted[index];
        int child = (index * 2) + 1;
        while (child < end) {
            int right = child + 1;
            if (right < end && unsorted[right].compareTo(unsorted[child]) > 0)
                child = right; // the larger of the two children
            if (unsorted[child].compareTo(value) <= 0)
                break;
            unsorted[index] = unsorted[child];
            index = child;
            child = (index * 2) + 1;
        }
        unsorted[index] = value;
    }

    private static <T extends Comparable<T>> void swap(int parentIndex, int childIndex, T[] unsorted) {
        T parent = unsorted[parentIndex];
        unsorted[parentIndex] = unsorted[childIndex];
        unsorted[childIndex] = parent;
    }
}
