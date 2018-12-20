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
public class Rotate90 {
    
    int n;
    
    int oArray[][];

    public Rotate90(int n) {
        this.n = n;
        this.oArray = new int[n][n];
        initialiseArray();
    }
    
    
    void initialiseArray() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                oArray[i][j] = (int)(Math.random() * 49 + 1);
            }
        }
    }
    
    void printArray(int arr[][]) {
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }    
    }
    
    void roateArray(int arr[][]){
        
        int singleDArray[] = new int[n * n];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                singleDArray[count++] = arr[i][j];
            }
        }
        int singleDRotatedArray[] = new int[n * n];
        int rCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                singleDRotatedArray[rCount++] = singleDArray[(j*n)+n-i-1];
            }
        }
        int rotatedArr[][] = new int[n][n];
        int c = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rotatedArr[i][j] = singleDRotatedArray[c++];
            }
        }
        System.out.println("-----ROTATED ARRAY-----");
        printArray(rotatedArr);
    }
}
