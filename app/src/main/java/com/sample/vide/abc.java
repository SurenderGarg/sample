package com.sample.vide;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class abc {

    /*linked list is cyclic/linear*/
    /*how handler communicate ui from service*/

    public static void main(String[] arhs) {
        Boolean status = findDuplicate();
//        quikSort(0, arrayToSort.length-1);
        quickSort(arrayToSort,0,arrayToSort.length-1);
        System.out.println("arrayToSort = " + Arrays.toString(arrayToSort));
    }


    public static int[] arrayToSort = {1, 3, 7, 2, 4, 5};

    public static boolean findDuplicate() {

        Map<Integer, Integer> map = new HashMap<>();

        for (int value : arrayToSort) {
            if (map.get(value) != null) {
                System.out.println("element duplicate");
                return true;
            }
            map.put(value, value);
        }
        System.out.println("element duplicate");

        return false;
    }

    public static void quickSort(int[] items, int startIndex, int endIndex) {
        if (endIndex - startIndex < 1) {
            return;
        }
        int pivotIndex = partition(items, startIndex, endIndex);
        quickSort(items, startIndex, pivotIndex - 1);
        quickSort(items, pivotIndex + 1, endIndex);
    }

    public static void quikSort(int low, int high) {
        System.out.println("low = " + low + ", high = " + high);
        if (low < high) {
            int k = partition(arrayToSort,low, high);
            quikSort(low, k-1);
            quikSort(k + 1, high);
        }

    }


    public static int partition(int[] items, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex - 1;
        int pivot = items[endIndex];

        while (left <= right) {
            while ( items[left] <= pivot) {
                ++left;
            }
            while ( items[right] >= pivot) {
                --right;
            }
            if (left < right) {
                int temp_item = items[left];
                items[left] = items[right];
                items[right] = temp_item;
            }
        }

        //swap pivot to the new position

        int temp_item = items[left];
        items[left] = pivot;
        items[endIndex] = temp_item;

        return left;
    }

    public static final <T> void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}


