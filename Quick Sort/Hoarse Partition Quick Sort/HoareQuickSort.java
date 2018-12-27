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
public class HoareQuickSort {
    
    void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
    
    
    int hoarePartition(int[] arr, int p, int r) {
        System.out.println("Partitioning Array from index p : " + p + " r : " + r);
        int x = arr[p];
        System.out.println("Value of X : " + x);
        int low = p - 1;
        int high = r + 1;
        while(true) {
            do {
                high = high - 1;
            } while(arr[high] > x);
            System.out.println("Value of high : " + high + "  = " + arr[high]);
            do {
                low = low + 1;
            } while(arr[low] < x);
            System.out.println("Value of low : " + low + "  = " + arr[low]);
            if(low < high) {
                System.out.println("Swapping " + arr[low] + " and " + arr[high]);
                swap(arr, low, high);
                printArray(arr);
            }
            else {
                System.out.println("Pivot Element at high : " + high + " = " + arr[high]);
                printArray(arr);
                return high;
            }
        }
    }
    
    void quickSort(int[] arr, int p, int r) {
        if(p < r) {
            System.out.println("Quick Sort Called with index p : " + p + " r : " + r);
            int q = hoarePartition(arr, p, r);
            quickSort(arr, p, q);
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
