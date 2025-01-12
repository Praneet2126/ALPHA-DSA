package Arrays;

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

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        bubbleSort(nums);
        printArr(nums);        
    }    
}
