import java.util.Scanner;

public class Multiple10 {
    @SuppressWarnings("resource")           // to disable sc warning
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your number:");
            int userInput = sc.nextInt();
            if (userInput % 10 == 0) {
                System.out.println(userInput + " is a multiple of 10");
                break;
            }
        }
    }   
}
