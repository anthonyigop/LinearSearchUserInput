/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linearsearchuserinputlab;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class LinearSearchUserInputLab {

    /**
     * @param args the command line arguments
     */
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }
        return -1; 
    }
    
    public static boolean duple(int[] arr, int target) {
        int count = 0;
        for (int value : arr) {
            if (value == target) {
                count++;
            }
        }
        return count > 1; 
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Choose the array size (5, 10, 20) or enter 0 to exit:");
            int size = scanner.nextInt();

            if (size == 0) {
                System.out.println("Exiting...");
                break; 
            } else if (size != 5 && size != 10 && size != 20) {
                System.out.println("Invalid size. Please enter 5, 10, or 20.");
                continue; 
            }

            System.out.println("\nTesting with array size: " + size);
            int[] array = new int[size];
            System.out.println("Enter " + size + " elements for the array:");
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }

            int targetBeginning = array[0];
            System.out.println("Searching for an element at the beginning: " + targetBeginning);
            testSearch(array, targetBeginning);

            int targetMiddle = array[size / 2];
            System.out.println("\nSearching for an element in the middle: " + targetMiddle);
            testSearch(array, targetMiddle);

            int targetEnd = array[size - 1];
            System.out.println("\nSearching for an element at the end: " + targetEnd);
            testSearch(array, targetEnd);

            System.out.println("\nSearching for an element not in the array: 999");
            testSearch(array, 999);
        }

        scanner.close();
    }
    
    private static void testSearch(int[] array, int target) {
       long startTime = System.nanoTime();
        int index = linearSearch(array, target);
        long endTime = System.nanoTime();
        long timeTaken = (endTime - startTime) / 1_000_000; 

        if (index != -1) {
            System.out.println("Target value " + target + " found at index " + index + ".");
            if (duple(array, target)) {
                System.out.println("The target value " + target + " appears more than once in the array.");
            } else {
                System.out.println("The target value " + target + " is unique in the array.");
            }
        } else {
            System.out.println("Target value " + target + " not found in the array.");
        }

        System.out.println("Time taken for search: " + timeTaken + " milliseconds");
    }
    
}
