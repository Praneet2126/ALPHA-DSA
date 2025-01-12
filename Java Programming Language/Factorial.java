import java.util.*;

public class Factorial {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fact = 1;

        int num = sc.nextInt();
        for (int i = num; i >= 1; i--) {
            fact *= i;
        }
        System.out.println(fact);
    }
}
