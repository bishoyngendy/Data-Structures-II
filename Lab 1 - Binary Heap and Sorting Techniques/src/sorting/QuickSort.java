package sorting;

import java.util.Comparator;
import java.util.Stack;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public class QuickSort extends SortHelper {

    @Override
    public void sort(Object[] arr) {
        quickSortIterative(arr, 0, arr.length - 1);
    }

    private void quickSort(Object[] arr, int left, int right) {
        if(left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    void quickSortIterative (Object arr[], int l, int h)
    {
        Stack<Point> s = new Stack<>();
        s.push(new Point(l, h));

        while (!s.empty()) {
            Point p = s.pop();
            int low = p.first;
            int high = p.second;
            if(low < high) {
                int piv = partition(arr, low, high);
                s.push(new Point(low, piv-1));
                s.push(new Point(piv+1, high));
            }
        }
//        // Create an auxiliary stack
//        int stack[] = new int[h - l + 1 ];
//
//        // initialize top of stack
//        int top = -1;
//
//        // push initial values of l and h to stack
//        stack[ ++top ] = l;
//        stack[ ++top ] = h;
//
//        // Keep popping from stack while is not empty
//        while ( top >= 0 )
//        {
//            // Pop h and l
//            h = stack[ top-- ];
//            l = stack[ top-- ];
//
//            // Set pivot element at its correct position
//            // in sorted array
//            int p = partition( arr, l, h );
//
//            // If there are elements on left side of pivot,
//            // then push left side to stack
//            if ( p-1 > l )
//            {
//                stack[ ++top ] = l;
//                stack[ ++top ] = p - 1;
//            }
//
//            // If there are elements on right side of pivot,
//            // then push right side to stack
//            if ( p+1 < h )
//            {
//                stack[ ++top ] = p + 1;
//                stack[ ++top ] = h;
//            }
//        }
    }

    private int partition(Object[] arr, int left, int right) {
        Object pivot = arr[right];
        int pivotEndIndex = left;
        for(int j = left; j < right; j++) {
            if(((Comparable)arr[j]).compareTo(pivot) <= 0) {
                swap(arr, pivotEndIndex, j);
                pivotEndIndex++;
            }
        }
        swap(arr, pivotEndIndex, right);
        return pivotEndIndex;
    }

}

class Point {
    int first, second;

    public Point(int l, int h) {
        this.first = l;
        this.second = h;
    }
}