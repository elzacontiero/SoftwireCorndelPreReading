package learning.calculator;

import java.util.List;

public class Add implements Calculation {
    public int calculate(int[] numbers) {
        int result = 0;
        for(int x: numbers) { // assign x to each element of the array.
           result += x; // add x to result
        }
       return result;
    }

    public int calculate(List<Integer> numbers) {
        int result = 0;
        for (int x: numbers){
            result += x;
        }
        return result;
    }

}
