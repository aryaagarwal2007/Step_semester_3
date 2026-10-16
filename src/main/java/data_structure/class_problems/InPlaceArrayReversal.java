package data_structure.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {

    static int[] parseList(String line) {
        String s = line.replaceAll("[\\[\\]\\s]", "");
        if (s.isEmpty()) return new int[0];
        String[] parts = s.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
        return arr;
    }

    // Two-pointer swap: modifies the original array, no second array is created.
    static void reverseInPlace(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tokens = parseList(sc.nextLine());
        reverseInPlace(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
