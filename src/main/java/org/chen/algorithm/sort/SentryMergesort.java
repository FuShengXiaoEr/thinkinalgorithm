package org.chen.algorithm.sort;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-08-01 07:29
 */
public class SentryMergesort {

    public static void main(String[] args) {
        int[] arr = {12,13,10,9,8,7,6,5,4,3,2,1};
        System.out.println("Given Array:");
        printArray(arr);
        merge_sort_c(arr,0,arr.length-1);
        System.out.println("Sorted Array:");
        printArray(arr);

    }

    static void merge_sort_c(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        merge_sort_c(arr, start, middle);
        merge_sort_c(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    //first subarray is arr[start...middle]
    //second subarray is arr[middle+1...end]
    static void merge(int[] arr, int start, int middle, int end) {
        int n1 = middle - start + 1;
        int n2 = end - middle;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }
        left[n1] = 9999;
        for (int i = 0; i < n2; i++) {
            right[i] = arr[middle + 1 + i];
        }
        right[n2] = 9999;

        int i=0,j=0;
        int k = start;
        while(left[i] != 9999 ){
            if (left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
    }

    static void printArray(int arr[]){
        for (int a : arr){
            System.out.println(a);
        }
        System.out.println();
    }
}
