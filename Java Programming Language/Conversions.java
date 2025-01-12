import java.util.*;

public class Conversions {
    
    public static void binaryToDecimal(int binary) {
        int pow = 0;
        int decNum = 0;

        while (binary > 0) {
            int digit = binary % 10;
            decNum += digit * (int) Math.pow(2, pow);
            pow++; 
            binary /= 10;
        }

        System.out.println("Decimal number is " + decNum);
    }

    public static void decimalToBinary(int decimal) {
        int pow = 0;
        int binary = 0;

        while (decimal > 0) {
            int digit = decimal % 10;
            binary += digit * (int) Math.pow(10, pow);
            pow++; 
            binary /= 2;
        }

        System.out.println("Decimal number is " + binary);
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Give binary number:");
            int binary = sc.nextInt();
            binaryToDecimal(binary);
        }
    }
}
