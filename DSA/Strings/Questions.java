package Strings;

public class Questions {
    public static boolean checkVowel(char ch) {
        switch (ch) {
            case 'a': return true; 
            case 'e': return true; 
            case 'i': return true; 
            case 'o': return true; 
            case 'u': return true; 
            default: return false; 
        }
    }

    public static int lowerVowelCount(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(checkVowel(str.charAt(i))) {
                count++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        String str = "abcEdaio";
        System.out.println(lowerVowelCount(str));

        String str2 = "ApnlaCollegel".replace("l","");
        System.out.println(str2);


        //NOTE: .intern():-
    
        String s1 = new String("Hello");
        String s2 = "Hello";
        String s3 = s1.intern();

        System.out.println(s1 == s2); // Outputs: false
        System.out.println(s2 == s3); // Outputs: true

        // s1 is a new String object not in the pool.
        // s2 is a String literal, automatically interned.
        // s3 is the result of s1.intern(), which refers to the interned "Hello" in the pool.


        //NOTE: String Buffers:

        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println(sb); // Outputs: Hello World

        sb.insert(5, ",");
        System.out.println(sb); // Outputs: Hello, World

        sb.delete(5, 8);
        System.out.println(sb); // Outputs: Hello World

        sb.reverse();
        System.out.println(sb); // Outputs: dlroW olleH

    }
}
