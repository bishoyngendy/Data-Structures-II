package sorting;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public class MergeSort extends SortHelper {

    Object temp[];

    @Override
    public void sort(Object[] arr) {
        temp = new Object[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    //    Iterative(arr);
    }

    private void mergeSort(Object[] arr, int left, int right)  {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(Object[] arr, int left, int mid, int right) {
        int firstIndex = left;
        int secondIndex = mid + 1;
        int mainIndex = left;

        while((firstIndex <= mid) && (secondIndex <= right)) {
            if (((Comparable)arr[firstIndex]).compareTo(arr[secondIndex]) < 0) {
                temp[mainIndex] = arr[firstIndex];
                firstIndex++;
            } else {
                temp[mainIndex] = arr[secondIndex];
                secondIndex++;
            }
            mainIndex++;
        }

        if(firstIndex <= mid) {
            while (firstIndex <= mid) {
                temp[mainIndex] = arr[firstIndex];
                firstIndex++;
                mainIndex++;
            }
        } else {
            while (secondIndex <= right) {
                temp[mainIndex] = arr[secondIndex];
                secondIndex++;
                mainIndex++;
            }
        }

        for(int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

}
