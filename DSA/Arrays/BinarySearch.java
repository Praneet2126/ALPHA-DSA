package Arrays;

public class BinarySearch {
    public static int binSearch(int array[], int ele) {
        int l = array[0], r = array.length - 1;
        int mid = l + (r-l) / 2;

        while (l <= r) {
            if(array[mid] == ele) {
                return mid;
            } else if(ele > array[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5,6,7,8,9};
        System.out.print("Element is at index " + binSearch(numbers, 5));
    }    
}
