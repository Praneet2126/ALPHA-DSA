package Recursion;

public class RecursionBasics {
    public static void printNumbers(int n) {
        if(n == 0){
            return;
        }
        // System.out.print(n + " ");
        printNumbers(n-1);
        System.out.print(n + " ");
    }

    public static int fact(int n) {
        if(n == 0) {
            return 1; 
        }
        return n * fact(n-1);
    }

    // calculate nth term in fibonacci
    public static int fib(int n) {
        // base case
        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn; 
    }

    public static boolean isSorted(int[] arr, int i) {
        // base case
        if(i == arr.length - 1) {
            return true;
        }
        
        if(arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        // base case
        if(i == arr.length) {
            return -1;
        }
        
        if(arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        // base case
        if(i == arr.length) {
            return -1;
        }
        
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {
        if(n == 1) {
            return x;
        }
        return x * power(x, n-1);
    }

    public static int optimizedPower(int x, int n) {
        if(n == 1) {
            return x;
        }
        
        // still O(n)
        // if(n % 2 == 0) {    
        //     return optimizedPower(x, n/2) * optimizedPower(x, n/2);
        // } else {
        //     return x * optimizedPower(x, n/2) * optimizedPower(x, n/2);
        // }
        
        // Now O(logn)
        int halfPower = optimizedPower(x, n/2);
        if(n % 2 == 0) {    
            return halfPower * halfPower;
        } else {
            return x * halfPower * halfPower;
        }


    }

    public static void main(String[] args) {
        // printNumbers(10);
        // System.out.println(fact(6));

        // System.out.println(fib(6));

        // int array[] = {1,2,3,5,4};
        // System.out.println(isSorted(array, 0));

        // int arr[] = {8,3,6,9,5,10,2,5,3};
        // System.out.println(lastOccurence(arr, 5, 0));

        System.out.println(optimizedPower(2, 10));
        
    }
}
