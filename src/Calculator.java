import java.util.Scanner;
import java.util.Random;
public class Calculator {

    /**
     * The method below gives 3 chances to the user to enter the right number.
     * @param s Scanner instance to provide us with input.
     * @return integer collected from the user.
     */
    public static int safeIntCollect(String message, Scanner s) {
        int i;
        // initialise n1
        int n1=0;
        // loop 3 times
        for(i =0; i<=2; i++) {
            // makes an attempt to collect the next integer from the user
            try {
                System.out.print(message);
                n1 = s.nextInt(); // this might throw an exception
                // if nextInt() above doesn't throw an Exception, everything is fine, so break the loop.
                break;
            }
            catch(Exception e) {
                // If nextInt() throws an exception, ask the user to try again.
                System.out.println("sorry, invalid input. Try again!");
                // we have to remove the character from the input,
                // otherwise nextInt() will fail again immediately on next attempt
                s.nextLine();
            }

        }
        if (i>2){

            throw new RuntimeException("You have exceeded the number of attempts");
        }
        return n1;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator!");

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        boolean keepRunning = true;
        while(keepRunning) {

            int n1 = safeIntCollect("Please enter first number: ", scan);
            int n2 =  safeIntCollect("Please enter second number: ", scan);
            int result = 0;

            System.out.println("The two numbers are: " + n1 + " and " + n2);

            // Create a scanner and collect the operator from the user:
            System.out.print("Please, enter the operator: ");
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


