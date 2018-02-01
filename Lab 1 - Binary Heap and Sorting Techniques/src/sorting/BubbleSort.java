package sorting;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public class BubbleSort extends SortHelper {

    @Override
    public void sort(Object[] arr) {
        boolean swapped = true;
        for(int i = 0; (i < (arr.length - 1)) && (swapped); i++) {
            swapped = false;
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(((Comparable)arr[j]).compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
        }
    }

}
