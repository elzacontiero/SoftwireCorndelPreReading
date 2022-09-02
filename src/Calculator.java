import java.util.Scanner;
public class Calculator {

    /**
     * The method below gives 3 chances to the user to enter the right number.
     * @return integer collected from the user.
     */
    public static int safeIntCollect() {
        // Create a scanner instance to collect ints.
        Scanner s = new Scanner(System.in);
        // loop 3 times
        for(int i =0; i<=2; i++) {
            // makes an attempt to collect the next integer from the user.
            try {
                return s.nextInt(); // this might throw an exception!
                // if nextInt() above doesn't throw an Exception, everything is fine, so return the number.
            }
            catch(Exception e) {
                // If nextInt() throws an exception, ask the user to try again.
                System.out.println("sorry, invalid input. Try again!");
                // If the person entered a letter, that remains in the buffer to be collected.
                // Subsequent calls to nextInt will throw an exception on it, so we have to
                // empty the buffer before tying again.
                s.nextLine();
            }
        }
        throw new RuntimeException("You have exceeded the number of attempts");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator!");

        Scanner scan = new Scanner(System.in);

        // Initialise boolean to true as we want to keep looping until user decides to quit ('q').
        boolean keepRunning = true;
        while(keepRunning) {

            System.out.println("Please enter first number: ");
            int n1 = safeIntCollect();
            System.out.println("Please enter second number: ");
            int n2 =  safeIntCollect();
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
                    break; // This breaks the switch, not the loop. That's why I make keepRunning=false
                default: // if the user entered something not covered in the options above, inform the message below.
                    System.out.println("Sorry, we don't support this operation.");
            } // <-- break jumps here

            if (!operation.equals("q") ) {
                // If the operation is not 'q' (quit), print result.
                System.out.println("Result: " + result);
            }
        }
    }
}


