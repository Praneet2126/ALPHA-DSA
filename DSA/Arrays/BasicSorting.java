package Arrays;
// import java.util.Arrays;
// import java.util.Collections;

public class BasicSorting {
    public static void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void bubbleSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int swaps = 0;
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0) {            // optimization to handle best case
                break;
            }
        }
    }

    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            int minPos = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            while (prev>=0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    public static void countingSort(int arr[]) {
        // getting the largest element to define count array size
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]); 
        }

        //count array
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++; 
        }

        //sorting
        int j = 0;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--; 
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {4,3,1,5,2};
        // bubbleSort(nums);
        // selectionSort(nums);
        // insertionSort(nums);
        // Arrays.sort(nums,0,3);  
        // Arrays.sort(nums, Collections.reverseOrder());  
        countingSort(nums);
        printArr(nums);      
    }    
}
