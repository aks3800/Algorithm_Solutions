/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning;

/**
 *
 * @author akshatsharma
 */
public class QuickSort {
    
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
    
    void quickSort(int[] arr, int p, int r) {
        if(p < r) {
            System.out.println("Quick Sort Called with index p : " + p + " r : " + r);
            int q = partition(arr, p, r);
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
