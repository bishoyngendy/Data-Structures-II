package sorting;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public abstract class SortHelper {

    /**
     * sorts a given integer array in ascending order
     * @param arr the array to be sorted.
     */
    public abstract void sort(Object arr[]);

    /**
     * swaps two elements in an array
     * @param arr reference to the array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    protected void swap(Object arr[], int first, int second) {
        Object temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
