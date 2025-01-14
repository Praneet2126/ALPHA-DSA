package Strings;

public class Direction {
    public static float shortestDistance(String str) {
        int x = 0, y = 0;

        for(int i=0; i<str.length(); i++) {
            switch (str.charAt(i)) {
                case 'W': x--; break;
                case 'E': x++; break;
                case 'N': y++; break;
                case 'S': y--; break;
            }
        }

        return (float) Math.sqrt(x*x + y*y);
    }

    public static void main(String[] args) {
        String directions = "WNEENESENNN";    
        System.out.println(shortestDistance(directions));
    }
}
