package org.chen.algorithm.sort;

import java.io.Console;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-08-01 10:42
 */
public class QuickSort{
    static int partition(int[] arr,int low,int high){
        // take last element as pivot;
        int pivot = arr[high];
        int i = (low -1);
        for(int j = low;j<high;j++){
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp1 = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp1;

        return i+1;
    }

    static void quickSort(int[] arr,int start,int end){
        if(start < end){
            int pi = partition(arr,start,end);
            quickSort(arr,start,pi-1);
            quickSort(arr,pi+1,end);
        }
    }
    static void printArray(int[] arr){
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10,7,8,9,1,5};
        System.out.println("Before given:");
        printArray(arr);
        quickSort(arr,0,arr.length-1);
        System.out.println("Sorted Array:");
        printArray(arr);
    }
}