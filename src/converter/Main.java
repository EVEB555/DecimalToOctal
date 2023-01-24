package converter;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Main {
    // Declare the GUI Elements
    public static JFrame frmMain;
    public static JLabel lblDecimal;
    public static JTextField textDecimal;
    public static JLabel lblOctal;
    public static JTextField textOctal;
    public static JButton btnCalculateDecToOct;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Set up the frame
        frmMain = new JFrame("Decimal to Octal Converter");
        frmMain.setSize(250, 300);
        frmMain.setLayout(new FlowLayout()); //automatically places the elements

        // Create GUI Elements
        lblDecimal = new JLabel("Decimal value:");
        textDecimal = new JTextField(10); //number refers to number of columns

        lblOctal = new JLabel("Octal value:");
        textOctal = new JTextField(10);

        btnCalculateDecToOct = new JButton("Convert");

        // Add ActionListener
        btnCalculateDecToOct.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Convert
                        String decimalInput = textDecimal.getText();
                        int decimalInputAsInt = Integer.parseInt(decimalInput);
                        Converter converter = new Converter(decimalInputAsInt);
                        //System.out.println(converter.convertDecimal());
                        String convertedOctal = converter.convertDecimal();
                        textOctal.setText(convertedOctal);
                    }
                }
        );


        // Add the GUI Elements to the frame
        frmMain.add(lblDecimal);
        frmMain.add(textDecimal);
        frmMain.add(lblOctal);
        frmMain.add(textOctal);
        frmMain.add(btnCalculateDecToOct);

        // Make the frame visible
        frmMain.setVisible(true);


       /* try{
            System.out.println("Enter decimal value");
            int input = sc.nextInt();

            Converter converter = new Converter(input);
            System.out.println(converter.convertDecimal());
        }catch (InputMismatchException e){
            System.err.println("Invalid input (try digits/shorter input)");
        }*/

    }
}
