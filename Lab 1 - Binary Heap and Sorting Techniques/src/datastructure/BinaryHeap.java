package datastructure;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public interface BinaryHeap {

    /**
     * insert new element to the Binary Heap.
     * @param element the new number to be inserted.
     */
    void insert(int element);

    /**
     * extracts the maximum number in the Binary Heap.
     * @return the maximum number in the Binary Heap.
     */
    int extractMax();

    /**
     * gets the maximum number in the Binary Heap without removing it.
     * @return the maximum number in the Binary Heap.
     */
    int getMax();

    /**
     * produces a max-heap from an unordered input array.
     * @param arr the unsorted input array.
     */
    void build(int arr[]);

    /**
     * maintains the condition of the binary heap.
     * @param index the starting point of heapify.
     */
    void heapify(int index);

    /**
     * gets the number of elements in the binary heap.
     * @return the number of elements in the binary heap.
     */
    int size();

}
