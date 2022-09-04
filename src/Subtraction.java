public class Subtraction implements Calculation {
    public int calculate(int[] numbers) {
        int result = numbers[0];// get the number the person entered at the first position.
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i]; // result = n0 - n1 - n2...
        }
        return result;
    }

}

