import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
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
                // If the user entered a letter, that remains in the buffer to be collected.
                // Subsequent calls to nextInt will throw an exception, so empty the buffer before tying again.
                s.nextLine();
            }
        }
        throw new RuntimeException("You have exceeded the number of attempts");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // Scanner class to collect input from user.

        // I am adding a HashMap containing all available calculations.
        // The idea is to map user's selection of operators into instances of calculations.
        // This avoids the need of a switch statement that would otherwise grow as we add more operations.
        // HashMap will associate the String Key operator to Calculation Interface.(Value)

        HashMap<String, Calculation> operations = new HashMap<>();
        // I associate the operator with a new instance of calculations.
        operations.put("+", new Add());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiply());

        System.out.println("Welcome to the Calculator!");
        System.out.println("========================= ");

        while(true) {

            System.out.print(" Choose an operator: ");
            String operator = scan.next();
            // If the operator is 'q' (quit),quit
            if (operator.equals("q") ) {
                System.out.println("Good-bye. Have a nice day!");
                break;
            }
            // 'operations' below is a HashMap associating '+','-','*' to their Calculation instances.
            // Get the corresponding calculation given the 'operator' that user input.
            Calculation calc = operations.get(operator);

            if (calc==null) {
                System.out.println("invalid operation!");
                break;
            }

            // choosing numbers
            System.out.print("Enter a number: ");
            List<Integer> numbers = new ArrayList<>();

            while(scan.hasNextInt()) {
                numbers.add(scan.nextInt());
                System.out.print("Enter another number or type 'quit': " );
            }

            int result = 0; // initialise result of calculation to be used later.
            result = calc.calculate(numbers);

            System.out.println("Result: " + result);
        }
    }
}


