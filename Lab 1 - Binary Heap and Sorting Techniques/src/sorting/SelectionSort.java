package sorting;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public class SelectionSort extends SortHelper {

    @Override
    public void sort(Object[] arr) {
        for(int currentIndex = 0; currentIndex < (arr.length - 1); currentIndex++) {
            int minIndex = getMinimumIndex(arr, currentIndex);
            swap(arr, currentIndex, minIndex);
        }
    }

    /**
     * gets the index of the minimum element of an array.
     * @param arr the required array
     * @param startIndex the index to start searching from.
     * @return index of the minimum element of an array
     */
    private int getMinimumIndex(Object[] arr, int startIndex) {
        Object minimumValue = arr[startIndex];
        int minimumIndex = startIndex;
        for(int i = startIndex; i < arr.length; i++) {
            if(((Comparable)arr[i]).compareTo(minimumValue) < 0) {
                minimumValue = arr[i];
                minimumIndex = i;
            }
        }
        return minimumIndex;
    }

}
