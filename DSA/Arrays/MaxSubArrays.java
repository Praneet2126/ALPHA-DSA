package Arrays;

public class MaxSubArrays {
    public static int bruteForce(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<numbers.length; i++) {
            for(int j=i; j<numbers.length; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {
                    sum += numbers[k];
                }
                // System.out.println(sum);
                maxSum = maxSum > sum ? maxSum : sum;
            }
        }
        return maxSum;
    } 

    public static int prefixApproach(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        //calculate Prefix
        prefix[0] = numbers[0];
        for(int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + numbers[i];
        }

        for(int i=0; i<numbers.length; i++) {
            for(int j=i; j<numbers.length; j++) {
                int sum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                
                if(maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int kadanes(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i=0; i<numbers.length; i++) {
            cs += numbers[i];
            if(cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        return ms;
    }

    public static void main(String[] args) {
        int numbers[] = {-2,-3,4,-1,-2,1,5,-3};
        // System.out.println("Max sum = " + bruteForce(numbers));
        // System.out.println("Max sum = " + prefixApproach(numbers));
        System.out.println("Max sum = " + kadanes(numbers));
    }
}
