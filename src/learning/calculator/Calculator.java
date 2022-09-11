package learning.calculator;

import learning.calculator.Add;
import learning.calculator.Calculation;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
public class Calculator {
    static Scanner scan = new Scanner(System.in);

    static Calculation gettingCalculationsFromUsers() throws Exception {

        System.out.print(" Choose an operator: ");
        String operator = scan.nextLine();

        HashMap<String, Calculation> operations = new HashMap<>();
        operations.put("+", new Add());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiply());

        Calculation calc = operations.get(operator);
        if(calc== null){
            throw new Exception("Sorry, Invalid operator!");
        }
        return calc;
    }

    static public List<Integer> readNumbersFromFile() throws FileNotFoundException {
        System.out.print("Enter a file: ");
        String fileName = scan.nextLine();

        File fileInstance = new File(fileName);

        Scanner fileScanner = new Scanner(fileInstance);

        List<Integer> numbers = new ArrayList<>();

        while(fileScanner.hasNextInt()) {
            numbers.add(fileScanner.nextInt());
        }
        return numbers;
    }

    private static final String LOG_FILE = "calculator.log";

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Calculator!");
        System.out.println("========================= ");


        while(true) {

            Calculation calc;
            try {
                calc = gettingCalculationsFromUsers();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            List<Integer> numbers;
            try {
                numbers = readNumbersFromFile();
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found.");
                continue; // the loop
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


