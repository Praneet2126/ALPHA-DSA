package Divide_and_Conquer;

public class RotatedSortedArray {
    public static int iterativeSearch(int arr[], int key, int si, int ei) {
        while(si <= ei) {
            int mid = si + (ei - si)/2;
            if(arr[mid] == key) {
                return mid;
            } 
            if (arr[si] <= arr[mid]) {
                if (key >= arr[si] && key <  arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else {
                if (key > arr[mid] && key <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int recursiveSearch(int arr[], int key, int si, int ei) {
        if(si > ei) {
            return -1;
        }
        
        int mid = si + (ei - si)/2;

        // case FOUND:
        if(key == arr[mid]) {
            return mid;
        }

        // mid on l1
        if(arr[si] <= arr[mid]) {
            // case a: 
            if(arr[si] <= key && key <=arr[mid]) {
                return recursiveSearch(arr, key, si, mid-1);
            } 
            // case b:
            else {
                return recursiveSearch(arr, key, mid+1, ei);
            }
        } 
        // mid on l2
        else {
            // case a:
            if (arr[mid] <= key && key <= arr[ei]) {
                return recursiveSearch(arr, key, mid+1, ei);
            } 
            // case b:
            else {
                return recursiveSearch(arr, key, si, mid-1);
            }
        }
        
    }
    
    public static void main(String[] args) {
        int arr[] = {6,7,8,1,2,3,4,5};
        System.out.println(recursiveSearch(arr, 8, 0, arr.length-1));
    }
}
