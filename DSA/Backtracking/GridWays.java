package Backtracking;

public class GridWays {
    public static int gridWays(int i, int j, int n, int m) {
        if(i==n-1 && j==m-1) {
            return 1;
        } else if(i==n || j==n) {
            return 0;
        }

        int down = gridWays(i+1, j, n, m); 
        int right = gridWays(i, j+1, n, m);
        return right + down; 
    }

    public static int trick(int n, int m) {
        int nm1Fact = 1, mm1Fact = 1;
        int nm = 1;

        for(int i=1; i<=(n+m-2); i++) {
            nm *= i;
        }

        for(int i=1; i<=n-1; i++) {
            nm1Fact *= i;
        }

        for(int i=1; i<=m-1; i++) {
            mm1Fact *= i;
        }

        return (nm) / (nm1Fact * mm1Fact);
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        // System.out.println(gridWays(0,0,n,m));
        System.out.println(trick(n, m));
    }
}
