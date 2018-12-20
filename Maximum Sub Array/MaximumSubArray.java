/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning;

/**
 *
 * @author akshatsharma
 * 
 * 
 * Following is the solution to Maximum Sub-Array Problem.
 * 
 * 
 */



public class MaximumSubArray {
    
    void performFunctionality() {
        int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxSubArrayObjectHolder obj = findMaximumSubArray(arr, 0, arr.length - 1);
        System.out.println("Max Sum : " + obj.leftRightSum);
        System.out.println("From : " + obj.maxLeft);
        System.out.println("To : " + obj.maxRight);
    }
    
    public MaxSubArrayObjectHolder findMaximumSubArray(int[] arr, int low, int high) {
        
        if (high == low) {
            System.out.println("Terminating Condition");
            System.out.println("Low : " + low);
            System.out.println("High : " + high);
            System.out.println("Value : " + arr[low]);
            System.out.println();
            System.out.println();
            return new MaxSubArrayObjectHolder(low, high, arr[low]);
        }
        else{
            int mid = (low + high) / 2;
            System.out.println("From : " + low + " To : " + mid);
            MaxSubArrayObjectHolder leftSubArray = findMaximumSubArray(arr, low, mid);
            System.out.println("From : " + (mid + 1) + " To : " + high);
            MaxSubArrayObjectHolder rightSubArray = findMaximumSubArray(arr, mid + 1, high);
            System.out.println("From : " + low + " via : " + mid + " To : " + high);
            MaxSubArrayObjectHolder crossSubArray = findMaxCrossingSubarray(arr, low, mid, high);
            System.out.println();
            System.out.println();
            if (leftSubArray.leftRightSum >= rightSubArray.leftRightSum &&
                    leftSubArray.leftRightSum >= crossSubArray.leftRightSum) {
                System.out.println("Left Bigger");
                System.out.println("From : " + leftSubArray.maxLeft + " To : " + leftSubArray.maxRight + " SUM : " + leftSubArray.leftRightSum);
                System.out.println();
                System.out.println();
                return leftSubArray;
                //return new MaxSubArrayObjectHolder(leftSubArray.maxLeft, leftSubArray.maxRight, leftSubArray.leftRightSum);
            }
            else if (rightSubArray.leftRightSum >= leftSubArray.leftRightSum && 
                    rightSubArray.leftRightSum >= crossSubArray.leftRightSum) {
                System.out.println("Right Bigger");
                System.out.println("From : " + rightSubArray.maxLeft + " To : " + rightSubArray.maxRight + " SUM : " + rightSubArray.leftRightSum);
                System.out.println();
                System.out.println();
                return rightSubArray;
                //return new MaxSubArrayObjectHolder(rightSubArray.maxLeft, rightSubArray.maxRight, rightSubArray.leftRightSum);
            }
            else {
                System.out.println("Cross Bigger");
                System.out.println("From : " + crossSubArray.maxLeft + " To : " + crossSubArray.maxRight + " SUM : " + crossSubArray.leftRightSum);
                System.out.println();
                System.out.println();
                return crossSubArray;
                //return new MaxSubArrayObjectHolder(crossSubArray.maxLeft, crossSubArray.maxRight, crossSubArray.leftRightSum);
            }
        }
    }
    
    
    public MaxSubArrayObjectHolder findMaxCrossingSubarray(int[] arr, int low, int mid, int high) {
        int leftSum = -Integer.MAX_VALUE;
        int sum = 0;
        int maxLeft = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        
        sum = 0;
        int rightSum = -Integer.MAX_VALUE;
        int maxRight = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        System.out.println("Max Left : " + maxLeft + " Max Right : " + maxRight + " Sum : " + (leftSum + rightSum));
        return new MaxSubArrayObjectHolder(maxLeft, maxRight, leftSum + rightSum);
    }
    
    
}

class MaxSubArrayObjectHolder {
    int maxLeft;
    int maxRight;
    int leftRightSum;
    public MaxSubArrayObjectHolder(int maxLeft, int maxRight, int leftRightSum) {
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
        this.leftRightSum = leftRightSum;
    }
}