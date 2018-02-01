package test;

import sorting.InsertionSort;
import sorting.SortHelper;

import java.util.Random;

/**
* Faculty of Engineering, Alexandria University
* Computer and Systems Engineering Department
* CS 223 : Data Structures II (File Structures)
* Lab 1 : Implementing Binary Heap & Sorting Techniques
* Created by Bishoy N. Gendy (programajor) on Sunday 12/03/2017.
* This class is
*/
public class SortTest {
   public static void main(String[] args) {
       int[] testData = new int[10000];
       Random generator = new Random();

       for(int i = 0; i < 10000; i++) {
           int rnd = generator.nextInt();
           testData[i] = rnd;
       }

       SortHelper sorter = new InsertionSort();
       sorter.sort(testData);

       for(int i = 0; i < 10000; i++) {
           System.out.println(testData[i]);
       }
   }
}
