import java.util.*;

public class Patterns {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /* STAR PATTERN */
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        /*  INVERTED STAR PATTERN */
        // for(int i=1;i<=n;i++) {
        //     for(int j=n;j>=i;j--) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        /* HALF PYRAMID PATTERN */
        // for(int i=1;i<=n;i++) {
        //     for(int j=1;j<=i;j++) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        /* CHARACTER PATTERN */
        // char ch = 'A';
        // for(int i=1;i<= n;i++) {
        //     for(int j=1;j<=i;j++) {
        //         System.out.print(ch);
        //         ch++;
        //     }
        //     System.out.println();
        // }
    }
}
