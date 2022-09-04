public class Multiply implements Calculation {

    public int calculate(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result *= numbers[i]; // result = n0 * n1 * n2...
        }
        return result;
    }

}