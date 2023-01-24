package converter;

import java.util.ArrayList;

//TODO fix printElements()
public class Converter {
    private int decimalValue;
    private float octalBase = 8f;

    public Converter(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public static float fractionOf(float x) {
        return x - (int) x;
    }

    public ArrayList<Integer> reverseArrayList(ArrayList<Integer> list){
        for(int i = 0; i < list.size()/2; i++){
            Integer temp = list.get(i);
            list.set(i, list.get(list.size() - i -1));
            list.set(list.size() - i - 1, temp);
        }

        return list;
    }

    public String printElements(ArrayList<Integer> list){
        for (Integer integer : list) {
            System.out.print(integer);
        }
        return ""; //correct this for program to return value in GUI
    }


    public String convertDecimal(){
        ArrayList<Integer> octalValues = new ArrayList<>();

        if(decimalValue > 0){
            do{
                float octalNumber = decimalValue/octalBase;
                float remainder = fractionOf(octalNumber);
                Integer convertedOctalValue = Math.round(remainder * 8);
                octalValues.add(convertedOctalValue);
                decimalValue = (int) octalNumber;
            }while(decimalValue > 0);

        } else {
            do{
                float octalNumber = decimalValue/octalBase;
                float remainder = fractionOf(octalNumber);
                Integer convertedOctalValue = Math.round(remainder * 8);
                octalValues.add(convertedOctalValue);
                decimalValue = (int) octalNumber;
            } while (decimalValue < 0);

            for (int i = 0; i < octalValues.size() - 1; ++i){
                if (octalValues.get(i) < 0) {
                    int absoluteValue = Math.abs(octalValues.get(i));
                    octalValues.set(i, absoluteValue);
                }
            }
        }
        return printElements(reverseArrayList(octalValues));

    }
}
