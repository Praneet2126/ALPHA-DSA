package Strings;

public class Strings {
    public static void printLetters(String str) {
        for(int i=0; i<str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean palindrome(String str) {
        int n = str.length();

        for(int i=0; i<n/2; i++) {
            if(str.charAt(i)!= str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static String getSubstring(String str, int si, int ei) {
        String substr = "";
        for(int i=si; i<ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }


    // Time - O(x.N)
    public static String getLargest(String array[]) {
        String largest = array[0];

        for(int i=0; i<array.length; i++) {
            if(largest.compareTo(array[i]) < 0 ) {
                largest = array[i];
            }
        }

        return largest;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        char strArray[] = {'a','b','c','d'};    // needs to be explicitly sent as an array.
        String s1 = "Tony Stark";
        String s2 = s1;
        System.out.println(s1);
        s1 = "Tony";        
        System.out.println(s2);
        System.out.println(s1 == s2);

        String str2 = new String("Steve Rogers");
        // printLetters(str2);

        String p = "racpar";
        // System.out.println(palindrome(p));

        // System.out.println(getSubstring(str2, 0, 3));

        // System.out.println(str2.substring(0, 4));

        String fruits[] = {"apple", "mango", "banana"};
        // System.out.println(getLargest(fruits));
    }
}
