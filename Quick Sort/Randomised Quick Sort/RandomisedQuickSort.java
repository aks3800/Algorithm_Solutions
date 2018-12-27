/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning;

import java.util.Random;

/**
 *
 * @author akshatsharma
 */
public class RandomisedQuickSort {
    
    void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
    
    int partition(int[] arr, int p, int r) {
        System.out.println("Partitioning Array from index p : " + p + " r : " + r);
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j <= (r - 1); j++) {
            if(arr[j] < x) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, r);
        System.out.println("Pivot Element at i : " + i + " = " + arr[i]);
        printArray(arr);
        return i;
    }
    
    int randomiseArray(int[] arr, int p, int r) {
        System.out.println("Randomising Array from index p : " + p + " r : " + r);
        Random rand = new Random();
        int low = p;
        int high = r;
        int i = rand.nextInt(high-low) + low;
        System.out.println("Random Number Generated at index : " + i + " of value " + arr[i]);
        System.out.println("Swapping " + arr[i] + " with " + arr[r]);
        swap(arr, i, r);
        System.out.println("Array after swap");
        printArray(arr);
        return partition(arr, p, r);
    }
    
    void quickSort(int[] arr, int p, int r) {
        if(p < r) {
            System.out.println("----------------------------------------------------");
            System.out.println("Quick Sort Called with index p : " + p + " r : " + r);
            int q = randomiseArray(arr, p, r);
            System.out.println("Pivot q : " + q);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }
    
    
    
    void printArray (int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    void performFunctionality() {
        int[] arr = {2,8,7,1,3,5,6,4};
        System.out.println("Array before Sorting");
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After Sorting Array");
        printArray(arr);
    }
    
}
