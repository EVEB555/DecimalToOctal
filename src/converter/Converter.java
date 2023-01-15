package converter;

import java.util.ArrayList;
import java.util.Arrays;

//TODO reverse Arraylist
public class Converter {
    private int decimalValue;
    private float octalBase = 8f;

    public Converter(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public static float fractionOf(float x) {
        return x - (int) x;
    }
    public Object convertDecimal(){
        ArrayList<Object> octalValues = new ArrayList<>();

        do{
            float octalNumber = decimalValue/octalBase;
            float remainder = fractionOf(octalNumber);
            Integer convertedOctalValue = Math.round(remainder * 8);
            octalValues.add(convertedOctalValue);
            decimalValue = (int) octalNumber;
            } while (decimalValue > 0);
        return octalValues;
    }
}
