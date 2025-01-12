package Arrays;

public class SubArrays {
    public static void displaySubarray(int numbers[]) {
        int minSum = 9999, maxSum = 0;

        for(int i=0; i<numbers.length; i++) {
            for(int j=i; j<numbers.length; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {
                    System.out.print(numbers[k]+" ");
                    sum += numbers[k];
                }
                minSum = minSum < sum ? minSum : sum;
                maxSum = maxSum > sum ? maxSum : sum;
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("Min Sum = "+minSum+" & Max Sum = "+maxSum);
    } 

    public static void main(String[] args) {
        int numbers[] = {1,2,3};
        displaySubarray(numbers);
    }
}
