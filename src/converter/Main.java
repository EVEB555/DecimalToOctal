package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter decimal value");
        int input = sc.nextInt();

        Converter converter = new Converter(input);
        System.out.println(converter.convertDecimal());


    }
}
