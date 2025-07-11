package PatternWise.Strings.StringManipulation;

public class StringToInteger {
    public static int convertToNumber(String numbers, boolean isNegative) {
        int num = 0;
        for (int i = 0; i < numbers.length(); i++) {
            int digit = numbers.charAt(i) - '0';

            // Check for overflow before multiplying and adding
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + digit;
        }

        return isNegative ? -num : num;
    }

    public static int myAtoi(String s) {
        int i = 0;
        boolean isNegative = false;
        int n = s.length();
        StringBuilder sb = new StringBuilder(); 

        // initial any char
        if (s.charAt(i) != ' ' && s.charAt(i) != '+' && s.charAt(i) != '-' && (s.charAt(i) < '0' || s.charAt(i) > '9')) {
            return 0;
        }

        // leading white space
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // check for sign
        if (i < n) {
            if (s.charAt(i) == '-') {
                isNegative = true;
                i++;
            } else if (s.charAt(i) == '+') {
                isNegative = false;
                i++;
            }
        }

        // skip leading zeroes
        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        // extract numbers
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            sb.append(s.charAt(i));
            i++;
        }

        int ans = convertToNumber(sb.toString(), isNegative);
        return ans;
    }

    public static void main(String[] args) {
        String str = "-91283472332";
        System.out.println(myAtoi(str));  // Output: -2147483648
    }
}
