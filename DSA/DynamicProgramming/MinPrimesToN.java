package DynamicProgramming;

import java.util.*;

public class MinPrimesToN {
    public static List<Integer> generateFirstMPrimes(int M) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < M) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
        return primes;
    }

    // Basic primality check
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static int minPrimesToSum(int N, int M) {
        List<Integer> primes = generateFirstMPrimes(M);
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int p : primes) {
                if (i - p >= 0 && dp[i - p] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - p] + 1);
                }
            }
        }

        return dp[N] == Integer.MAX_VALUE ? -1 : dp[N];
    }

    public static void main(String[] args) {
        System.out.println(minPrimesToSum(10, 1)); // Output: 5
        System.out.println(minPrimesToSum(11, 3)); // Output: 3
    }
}
