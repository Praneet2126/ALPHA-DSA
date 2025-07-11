package PatternWise.Strings.StringManipulation;

public class CountAndSay {
    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        String str;
        str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder("");
        int count = 1;
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == str.charAt(i-1)) {
                count++;
            } else {
                sb.append(String.valueOf(count));
                sb.append(str.charAt(i-1));
                count = 1;
            }
        }
        sb.append(String.valueOf(count));
        sb.append(str.charAt(str.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
    }
}
