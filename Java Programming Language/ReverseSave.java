import java.util.Scanner;

public class ReverseSave {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number to be reversed:");
            int num = sc.nextInt();
            int digit, rev = 0;

            while (num > 0) {
                digit = num % 10;
                rev = (rev * 10) + digit;
                num /= 10;
            }
            System.out.println(rev);
        }
    }   
}
