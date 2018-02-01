package sorting;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public class InsertionSort extends SortHelper {

    @Override
    public void sort(Object[] arr) {
        for(int i = 1; i < arr.length; i++) {
            Object valueToInsert = arr[i];
            int pos = i;
            while (pos > 0 && ((Comparable)valueToInsert).compareTo(arr[pos - 1]) < 0) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = valueToInsert;
        }
    }

}
