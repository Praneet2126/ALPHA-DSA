package PatternWise.Strings.HashMaps;

public class StringCompression {
    public static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder("");
        int count = 0;

        int i = 0;
        while(i < chars.length) {
            int j = i;
            while(j < chars.length && chars[i] == chars[j]) {
                count++;
                j++;
            }
            if(count > 1) {
                sb.append(chars[i]);
                sb.append(count);
            } else {
                sb.append(chars[i]);
            }
            count = 0;
            i = j;
        }

        int len = sb.toString().length();

        for(int k=0; k<len; k++) {
            chars[k] = sb.charAt(k);
        }

        return len;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
        for(int i=0; i<chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
    }
}
