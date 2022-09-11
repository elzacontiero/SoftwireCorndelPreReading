package learning.calculator;

import learning.calculator.Calculation;

import java.util.List;

public class Subtraction implements Calculation {
    public int calculate(int[] numbers) {
        int result = numbers[0];// get the number the person entered at the first position.
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i]; // result = n0 - n1 - n2...
        }
        return result;
    }
    public int calculate(List<Integer> numbers){
        int result = numbers.get(0);
        for(int i=1; i< numbers.size();i++) {
            result -= numbers.get(i);
        }
        return result;
    }
}

