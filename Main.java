package com.company;

import java.util.*;

public class Main {
    static int leftChild(int i) {
        return 2 * i + 1;
    }
    static int rightChild(int i) {
        return 2 * i + 2;
    }
    static int parent(int i) {
        return (int)Math.floor((i - 1) / 2);
    }
    static void siftDown(int arr[], int i, int boundary) {
        int l = leftChild(i), r = rightChild(i), maxI = i;
        if (l <= boundary && arr[l] > arr[maxI])
            maxI = l;
        if (r <= boundary && arr[r] > arr[maxI])
            maxI = r;
        if (maxI != i) {
            int temp = arr[maxI];
            arr[maxI] = arr[i];
            arr[i] = temp;
            siftDown(arr, maxI, boundary);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        for (int i = (int)Math.floor((n - 1) / 2); i >= 0; --i) {
            siftDown(arr, i, n - 1);
        }
        int boundary = n - 1;
        while (boundary > 0) {
            int temp = arr[boundary];
            arr[boundary] = arr[0];
            arr[0] = temp;
            boundary--;
            siftDown(arr, 0, boundary);
        }
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
