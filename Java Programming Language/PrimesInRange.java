public class PrimesInRange {
    public static boolean isPrime(int n) {
        
        // corner case
        if(n == 2) {
            return true;
        }
        
        //remaining cases
        for(int i=2;i<=Math.sqrt(n);i++) {
            if (n % i == 0) {
                return false;
            } 
        }
        return true;
    }

    public static void printPrimes(int range) {
        for (int i=2;i<=range;i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        printPrimes(200);    
    }
}
