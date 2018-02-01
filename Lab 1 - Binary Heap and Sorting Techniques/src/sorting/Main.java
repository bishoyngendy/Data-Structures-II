package sorting;

import datastructure.BinaryHeap;
import datastructure.BinaryHeapImp;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        Integer testArr[] = {10, 7, 1, 5, 6, 2, 8, 9, 4, 3};
        SortHelper sorter = new QuickSort();
        sorter.sort(testArr);
        for(int i = 0; i < testArr.length; i++) {
            System.out.print(testArr[i] + " ");
        }
    }
}
