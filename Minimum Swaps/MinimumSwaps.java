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
public class MinimumSwaps {
    
    static int swaps = 0;

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
        swaps++;
    }

    static int differenceAtIndex(int[] arr, int index) {
        return (arr[index] - (index + 1));
    }

    static int sortedTillIndex(int[] arr) {
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(differenceAtIndex(arr, i) != 0){
                index = i;
                break;
            }
        }
        return index;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int len = arr.length;
        int index = 0;
        do{
            int sortedIndex = sortedTillIndex(arr);
            System.out.println("Sorted Index : " + sortedIndex);
            if (sortedIndex == -1) {
                break;
            }
            swap(arr, sortedIndex, arr[sortedIndex] - 1);
            printArray(arr);
        } while(true);
        return swaps;
    }
    
    static void printArray (int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    static void performFunction () {
        int[] arr = {4,3,1,2};
        //int[] arr = {3,7,6,9,1,8,10,4,2,5};
        System.out.println(minimumSwaps(arr));
    }
    
}
