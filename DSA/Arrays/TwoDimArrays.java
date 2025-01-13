package Arrays;

import java.util.Scanner;

public class TwoDimArrays {
    public static void search(int arr[][], int key) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j] == key) {
                    System.out.println("Found at " + i + "," + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[3][3];
        try (Scanner sc = new Scanner(System.in)) {
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr.length; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
        }
        search(arr, 5);
    }
}
