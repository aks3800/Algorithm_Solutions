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
public class CountingSort {
    
    int[] countingSort(int[] arr, int max) {
        int len = arr.length;
        int[] sortedArray = new int[len];
        
        int[] tempStorage = new int[max + 1];
        for (int i = 0; i < len; i++) {
            tempStorage[arr[i]] = tempStorage[arr[i]] + 1;
        }
        System.out.println("Temporary Storage after Value Count");
        printArray(tempStorage);
        
        for (int i = 1; i <= max; i++) {
            tempStorage[i] = tempStorage[i] + tempStorage[i - 1];
        }
        System.out.println("Temporary Storage after Total Value Count");
        printArray(tempStorage);
        
        for (int i = len - 1; i >= 0; i--) {
            System.out.println("------------------------------");
            System.out.println("For i : " + i + " value : " + arr[i]);
            sortedArray[tempStorage[arr[i]] - 1] = arr[i];
            System.out.println("Sorted Array");
            printArray(sortedArray);
            tempStorage[arr[i]] = tempStorage[arr[i]] - 1;
            System.out.println("Temporary Storage");
            printArray(tempStorage);
        }
        return sortedArray;
    }
    
    void printArray (int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    void performFunctionality() {
        int[] arr = {2,5,3,0,2,3,0,3};
        System.out.println("Array before Sorting");
        printArray(arr);
        int[] sortedArray = countingSort(arr, 5);
        System.out.println("After Sorting Array");
        printArray(sortedArray);
    }
      
}
