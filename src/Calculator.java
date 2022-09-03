import java.util.Scanner;
import java.util.HashMap;
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
        // Adding a HashMap containing all available calculations. The idea is to map user's selection of operators
        // into instances of calculations.

        // HashMap will map String (Key) to Calculation Interface.(Value)
        HashMap<String, Calculation> operations = new HashMap<>();
        // I associate the operator with the new instance Add that I'm creating.
        // Add implements Calculation, therefore, it is expected.(Principle of Polymorphism)
        operations.put("+", new Add());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiply());

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
            String operator = scan.next();
            // If the operator is 'q' (quit),quit
            if (operator.equals("q") ) {
                System.out.println("Good-bye. Have a nice day!");
                break;
            }

            // Create variable calc of type Calculation and from HashMap operations get the value corresponding to key operator.
            Calculation calc = operations.get(operator);

            if (calc==null) {
                System.out.println("invalid operation.Try again! ");
                continue;
            }
            // result is assigned with the outcome of calculate method from object calc.
            result = calc.calculate(n1,n2);
            System.out.println("Result: " + result);
        }
    }
}


