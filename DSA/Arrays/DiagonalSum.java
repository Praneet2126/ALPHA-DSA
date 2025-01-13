package Arrays;

public class DiagonalSum {

    // Time - O(n²) 
    public static int diagSum(int matrix[][]) {
        int sum1 = 0;
        int sum2 = 0;
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(i == j) {
                    sum1 += matrix[i][j];
                }
            }
        }

        int j = matrix.length - 1;
        for(int i=0; i<matrix.length; i++) {
            sum2 += matrix[i][j];
            j--;
        }   

        return sum1 + sum2;
    }
    
    // Time - O(n)
    public static int optimized(int matrix[][]) {
        int sum = 0;

        for(int i=0; i<matrix.length; i++) {
            //pd
            sum += matrix[i][i];

            //sd
            if(i != matrix.length-i-1)    // overlapping condition for odd nxn to prevent extra addition
                sum += matrix[i][matrix.length-i-1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8}, 
                          {9,10,11,12},
                          {13,14,15,16}};

        System.out.println(optimized(matrix));
    }
}
