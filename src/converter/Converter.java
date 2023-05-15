package converter;

import java.util.ArrayList;
import java.util.Collections;

public class Converter {
    private int decimalValue;

    public Converter(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public String printElements(ArrayList<Integer> list) {
        StringBuilder result = new StringBuilder();

        for (Integer integer : list) {
            result.append(integer);
        }

        return result.toString();
    }

    public String convertDecimal() {
        ArrayList<Integer> octalValues = new ArrayList<>();

        int decimal = decimalValue;
        int sign = 1;

        // If decimalValue is negative, changes decimal to its absolute value and sets sign to -1.

        if (decimalValue < 0) {
            decimal = -decimalValue;
            sign = -1;
        }

        // calculates the remainder of decimal divided by 8. This remainder represents the rightmost octal digit.
        while (decimal > 0) {
            int remainder = decimal % 8;
            octalValues.add(remainder * sign);
            decimal = decimal / 8;
        }

        //If list is empty, it means the input decimal value was 0, so it adds a single 0 to the list.
        if (octalValues.isEmpty()) {
            octalValues.add(0);
        }

        //Checks each element in the octalValues list and ensures that all negative values are converted to their absolute values, except for the last one.
        for (int i = 0; i < octalValues.size() - 1; ++i) {
            if (octalValues.get(i) < 0) {
                int absoluteValue = Math.abs(octalValues.get(i));
                octalValues.set(i, absoluteValue);
            }
        }

        Collections.reverse(octalValues);
        return printElements(octalValues);
    }

}
