package Recursion;

public class Questions {
    // Q1:
    public static void printOccurences(int[] arr, int key, int i) {
        if(i == arr.length) {
            return;
        }

        if(arr[i] == key) {
            System.out.print(i + " ");
        }
        printOccurences(arr, key, i+1);
    }

    // Q2:
    public static String checkDigit(int digit) {
        switch(digit) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    public static void numberToString(int n, StringBuilder str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }

        int digit = n % 10;
        str.insert(0, checkDigit(digit) + " ");
        numberToString(n/10, str);
    }

    // Q3:
    public static int countLengthOfString(String str, int i, int count) {
        try {
            str.charAt(i);
        } catch(IndexOutOfBoundsException e) {
            return i;
        }
        return countLengthOfString(str, i+1, count+1);
    }

    // Q4:
    public static int countSubstrs(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }

        if(n <= 0) {
            return 0;
        }

        int res = countSubstrs(str, i+1, j, n-1) 
                + countSubstrs(str, i, j-1, n-1)
                - countSubstrs(str, i+1, j-1, n-2);

        if(str.charAt(i) == str.charAt(j)) {
            res++;
        }

        return res;
    }

    // Q5: 
    /* Trick to remember
        from - 1;  aux - 2; to - 3

        132
        123
        231
      
     */
    
    public static void tower_hanoi(int n, String from_rod, String to_rod, String aux_rod) {
        if(n == 1) {
            System.out.println("Move disc 1 from " + from_rod + " to " + to_rod);
        }
        else {
            tower_hanoi(n-1,from_rod,aux_rod,to_rod);
            System.out.println("Move disc " + n + " from " + from_rod + " to " + to_rod);
            tower_hanoi(n-1,aux_rod,to_rod,from_rod);
        }
    }
    
    // main
    public static void main(String[] args) {
        /* Question 1 */
        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // int key = 2;
        // printOccurences(arr, key, 0);

        /* Question 2 */
        // int number = 1947;
        // numberToString(number, new StringBuilder(""));

        /* Question 3 */
        // String str = "abcdefsrfthsrt";
        // System.out.println(countLengthOfString(str, 0, 0));

        /* Question 4 */
        // String str = "abcab";
        // int n = str.length();
        // System.out.println(countSubstrs(str, 0, n-1, n));     
        
        /* Question 5 */
        tower_hanoi(3, "A", "B", "C");
    }
}
