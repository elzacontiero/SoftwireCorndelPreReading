import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
public class Calculator {
    private static final String LOG_FILE = "calculator.log";

    public static void main(String[] args) throws Exception {

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
            String operator = scan.nextLine();
            // If the operator is 'q' (quit),quit
            if (operator.equals("q") ) {
                System.out.println("Good-bye. Have a nice day!");
                break;
            }
            // 'operations' below is a HashMap associating '+','-','*' to their Calculation objects.
            // Get the corresponding calculation given the 'operator' that user inputs.
            Calculation calc = operations.get(operator);

            if (calc==null) {
                System.out.println("invalid operation!");
                break;
            }

            // Read numbers from file. User will tell which file to read from.
            System.out.print("Enter a file: ");
            String fileName = scan.nextLine();
            // create Scanner to read numbers from fileName.
            Scanner fileScanner = new Scanner(new File(fileName));

            // Create an ArrayList of Integers to store user's numbers.
            List<Integer> numbers = new ArrayList<>();

            // Keep reading from fileScanner if there is a next integer available.
            while(fileScanner.hasNextInt()) {
                numbers.add(fileScanner.nextInt());
            }

            int result = calc.calculate(numbers);

            System.out.println("Result: " + result);
            logResult(result);
        }
    }

    private static void logResult(int result) throws IOException{
        FileWriter writer = new FileWriter(LOG_FILE, true);
        writer.write("Calculated result:" + result + "\n");
        writer.close();
    }
}


