import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            float pencil = sc.nextFloat();
            float pen = sc.nextFloat();
            float eraser = sc.nextFloat();
            float cost = pencil + pen + eraser;

            System.out.println(cost + cost * 0.18f);
        }
    }
}
