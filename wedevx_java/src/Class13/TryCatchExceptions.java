package Class13;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TryCatchExceptions {


    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner sc = new Scanner(System.in);
        try {
            double input = sc.nextDouble();
            System.out.println("You entered: " + input);

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
        }
    }
}

