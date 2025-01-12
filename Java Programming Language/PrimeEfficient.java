import java.util.*;

public class PrimeEfficient {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number:");
        int num = sc.nextInt();
        
        if (num == 2) {
            System.out.println(num + "is prime");
        } else {
            boolean isPrime = true;
            for (int i=2; i<=Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                } 
            }

            if (isPrime) {
                System.out.println("It is prime");
            } else {
                System.out.println("It is not prime");
            }
        }
    }
}
