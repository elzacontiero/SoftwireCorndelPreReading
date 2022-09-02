import java.util.Scanner;
import java.util.Random;
public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator!");

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        boolean keepRunning = true;
        while(keepRunning) {
            int n1 = random.nextInt(100);
            int n2 = random.nextInt(100);
            int result = 0;

            System.out.println("The two random numbers are: " + n1 + " and " + n2);

            // Create a scanner and collect a string from the user:
            System.out.print("Enter the desired operation: ");
            String operation = scan.next();

            switch (operation) {
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "q":
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Sorry, we don't support this operation.");
            } // <-- break jumps here
            System.out.println("Result: " + result);
        }
    }
}


