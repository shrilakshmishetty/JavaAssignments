package com.shri.java;
import java.util.Arrays;
import java.util.stream.Collectors;
//Q1:Design an application that takes the type of sorting algorithm (like BUBBLE, QUICK, MERGE etc ) and integer values to sort from command line, there maybe few strings as well which are to be neglected by the program, and then sorts the values as per the algorithm and return the sorted values? Also find the time utilization for the sort? Which sort is better?	
public class Sorting1 {
 
	 public static void main(String[] args) {
	        if (args.length < 2) {
	            System.out.println("Usage: java SortingApp <algorithm> <numbers...>");
	            return;
	        }
 
	        String algorithm = args[0].toUpperCase();
	        int[] numbers = parseNumbers(args);
 
	        if (numbers.length == 0) {
	            System.out.println("No valid numbers provided for sorting.");
	            return;
	        }
 
	        long startTime = System.currentTimeMillis();
 
	        switch (algorithm) {
	            case "BUBBLE":
	                SortingAlgorithms.bubbleSort(numbers);
	                break;
	            case "QUICK":
	                SortingAlgorithms.quickSort(numbers, 0, numbers.length - 1);
	                break;
	            case "MERGE":
	                SortingAlgorithms.mergeSort(numbers, 0, numbers.length - 1);
	                break;
	            default:
	                System.out.println("Invalid sorting algorithm. Use BUBBLE, QUICK, or MERGE.");
	                return;
	        }
 
	        long endTime = System.currentTimeMillis();
	        long duration = endTime - startTime;
 
	        System.out.println("Sorted values: " + arrayToString(numbers));
	        System.out.println("Time taken: " + duration + " milliseconds");
	    }
 
	    private static int[] parseNumbers(String[] args) {
	        return Arrays.stream(args, 1, args.length)
	                .filter(arg -> arg.matches("-?\\d+"))
	                .mapToInt(Integer::parseInt)
	                .toArray();
	    }
 
	    private static String arrayToString(int[] arr) {
	        return Arrays.stream(arr)
	                .mapToObj(String::valueOf)
	                .collect(Collectors.joining(", "));
	    }
 
}
class SortingAlgorithms {
	 
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
 
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
 
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
 
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
 
    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
 