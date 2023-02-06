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

        // Set up the frame
        frmMain = new JFrame("Decimal to Octal Converter");
        frmMain.setSize(400, 250);
        frmMain.setLayout(null);
        //frmMain.setLayout(new GridLayout(3, 2,10,10)); //automatically places the elements

        //declaring panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2, 10, 10));
        panel.setSize(100, 100);
        panel.setBounds(50, 50, 300, 150);

        // Create GUI Elements
        lblDecimal = new JLabel("Decimal value:");
        textDecimal = new JTextField(10); //number refers to number of columns

        lblOctal = new JLabel("Octal value:");
        textOctal = new JTextField(20);
        textOctal.setEditable(false);

        btnCalculateDecToOct = new JButton("Convert");

        // Add ActionListener
        btnCalculateDecToOct.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            // Convert
                            String decimalInput = textDecimal.getText();
                            int decimalInputAsInt = Integer.parseInt(decimalInput);
                            Converter converter = new Converter(decimalInputAsInt);
                            String convertedOctal = converter.convertDecimal();
                            textOctal.setText(convertedOctal);
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(frmMain, "Invalid input.\n  *Try shorter number\n  *Enter only digits");
                        }
                    }
                }
        );

        // Add the GUI Elements to the frame
        panel.add(lblDecimal);
        panel.add(textDecimal);
        panel.add(lblOctal);
        panel.add(textOctal);
        panel.add(btnCalculateDecToOct);

        frmMain.add(panel);

        // Make the frame visible
        frmMain.setVisible(true);

    }
}
