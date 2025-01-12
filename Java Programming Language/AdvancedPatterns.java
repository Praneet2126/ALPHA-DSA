public class AdvancedPatterns {
    public static void hollow_rectangle(int totRows, int totCols) {
        for(int i=1;i<=totRows;i++) {
            for(int j=1;j<=totCols;j++) {
                if(i == 1 || i == totRows || j == 1 || j == totCols) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void inverted_rotated_half_pyramid(int n) {
        for(int i=1; i<=n; i++) {
 
            // spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }

            // stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void inverted_half_pyramid(int n) {
        for(int i=0; i<n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void floyd_triangle(int n) {
        int counter = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int n) {
        int bit = 1;
        for(int i=1; i<=n; i++) {
            bit = i % 2 == 0 ? 0 : 1; 
            for(int j=1; j<=i; j++) {
                System.out.print(bit + " ");
                bit = bit == 1 ? 0 : 1;
            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {
        // first half
        for(int i=1; i<=n; i++) {
            //stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            //spaces
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print(" ");
            }

            //stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // second half
        for(int i=n; i>=1; i--) {
            //stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            //spaces
            for(int j=1; j<=2*(n-i); j++) {
                System.out.print(" ");
            }

            //stars
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void solid_rhombus(int n) {
        for(int i=1; i<=n; i++) {
            //spaces
            for(int j=1;j<=n-i; j++) {
                System.out.print(" ");
            }

            //stars
            for(int j=1; j<=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        for(int i=1; i<=n;i++) {
            //spaces
            for(int j=1;j<=n-i; j++) {
                System.out.print(" ");
            }

            // hollow rectangle
            for(int j=1; j<=n; j++) {
                if(i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        for(int i=1;i<=n;i++) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            //stars
            for(int j=1; j<=2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--) {
            //spaces
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            //stars
            for(int j=1; j<=2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // hollow_rectangle(10, 15);
        // inverted_rotated_half_pyramid(9);
        // inverted_half_pyramid(5);
        // floyd_triangle(5);
        // zero_one_triangle(5);
        // butterfly(8);
        // solid_rhombus(5);
        // hollow_rhombus(5);
        diamond(9);
    }
}
