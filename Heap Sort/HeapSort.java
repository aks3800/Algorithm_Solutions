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
public class HeapSort {
    
    public int heapSize;
    
    public int parentOf(int index) {
        if (index == 0) {
            return 0;
        }
        else{
            index = index - 1;
        }
        return index / 2;
    }
    
    public int leftChildOf(int index) {
        return (2 * index) + 1;
    }
    
    public int rightChildOf(int index) {
        return (2 * index) + 2;
    }
    
    void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
    
    
    public void MaxHeapify(int[] arr, int index) {
        System.out.println("Array befor MaxHeapify at index : " + index + " Heap Size : " + heapSize);
        printArray(arr);
        int leftChild = leftChildOf(index);
        int rightChild = rightChildOf(index);
        System.out.println("Left Child : " + leftChild + " Right Child : " + rightChild);
        int largest = -1;
        if (leftChild <= heapSize && arr[leftChild] > arr[index]) {
            largest = leftChild;
            System.out.println("Left Child Greater. Largest is at : " + largest);
        }
        else {
            largest = index;
            System.out.println("Parent Greater that Child. Largest is at : " + largest);
        }
        if (rightChild <= heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
            System.out.println("Right Child Greater. Largest is at : " + largest);
            
        }
        if (largest != index) {
            System.out.println("Largest and Index MisMatch\nSWAP");
            printArray(arr);
            swap(arr, index, largest);
            printArray(arr);
            System.out.println("Now Heapifying : " + largest);
            MaxHeapify(arr, largest);
        }
    }
    
    void printArray (int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    
    void buildMaxHeap(int[] arr) {
        System.out.println("Building Max Heap");
        heapSize = arr.length - 1;
        int len = arr.length;
        for(int i = len / 2 - 1; i >= 0; i--) {
            MaxHeapify(arr, i);
        }
    }
    
    void heapSort(int[] arr) {
        System.out.println("Starting Heap Sort");
        buildMaxHeap(arr);
        System.out.println("Max Heap Built");
        int len = arr.length;
        for(int i = len - 1; i >= 1; i--) {
            System.out.println("---------------------------------------------");
            System.out.println("Swapping : " + arr[0] + " with : " + arr[i]);
            swap(arr, 0, i);
            System.out.println("Current Array");
            printArray(arr);
            heapSize = heapSize - 1;
            MaxHeapify(arr, 0);
        }
    }
    
    
    public void performMaxHeapFunctionality() {
        int arr[] = {4,1,3,2,16,9,10,14,8,7};
        heapSort(arr);
    }
    
}
