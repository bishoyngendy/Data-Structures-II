package sorting;

import java.util.Comparator;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public class HeapSort extends SortHelper {

    /**
     * number of elements in the binary heap.
     */
    private int size;

    @Override
    public void sort(Object[] arr) {
        build(arr);
        for(int i = (arr.length - 1); i >= 1; i--) {
            swap(arr, i, 0);
            size--;
            heapify(arr, 0);
        }
    }

    private void build(Object[] arr) {
        this.size = arr.length;
        for(int i = arr.length/2; i >= 1; i--) {
            heapify(arr, i);
        }
    }

    private void heapify(Object[] arr, int index) {
        int largest = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;
        if(left < size && ((Comparable)arr[left]).compareTo(arr[largest]) > 0) {
            largest = left;
        }
        if(right < size && ((Comparable)arr[right]).compareTo(arr[largest]) > 0) {
            largest = right;
        }
        if(largest != index) {
            swap(arr, index, largest);
            heapify(arr, largest);
        }
    }

}
