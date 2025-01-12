import java.util.*;

public class BinomialCoefficient {
    public static int fact(int n) {
        int fact = 1;
        for(int i=1;i<=n;i++) {
            fact *= i;
        }
        return fact;
    }

    public static float bin(int n, int r) {
        return fact(n) / (fact(r) * fact(n-r));
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(bin(n, r));
    }
}
