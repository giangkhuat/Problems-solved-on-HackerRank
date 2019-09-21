import java.io.*;
import java.util.*;

class AbsoluteValueSort {
  
  static void swap (int[] arr, int pos1, int pos2) {
    int tmp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = tmp;
}
  
  static void quickSort (int[] arr, int start, int end) {
   if (start >= end) {
    return;
   } else {
     int pIndex = partition(arr, start, end);
     quickSort(arr, start, pIndex -1);
     quickSort(arr, pIndex+1, end);
   }
  }
  
  static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int pIndex = start;
    for (int i = start; i < end; i++) {
       if (Math.abs(arr[i]) < Math.abs(arr[pivot])) {
          swap (arr, i, pIndex);
          pIndex++ ;
        } else if (Math.abs(arr[i]) == Math.abs(arr[pivot])) {
          if ((arr[i] < 0 && arr[pivot] > 0) || (arr[i]/arr[pivot] == 1)) {
              swap(arr, i, pIndex); 
              pIndex++;
            System.out.print("Stuck here");
          }
       }     
    }
           swap(arr, pIndex, pivot);
    return pIndex;
  }

    static int[] absSort(int[] arr) {
        // your code goes here
    quickSort(arr, 0, arr.length - 1);
    return arr;
    }

    public static void main(String[] args) {
    int[] arr = {2, -7, -2, -2, 0};
    int[] newArr= absSort(arr);
    for (int i = 0;  i < newArr.length; i++) {
        System.out.print( newArr[i] + " ");
    }
    }
}