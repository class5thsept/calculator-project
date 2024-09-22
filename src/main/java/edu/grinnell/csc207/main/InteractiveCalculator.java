package edu.grinnell.csc207.main;

import java.util.Scanner;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BigFraction;

/**
 * Calculator that supports inputs (one expression per line).
 *
 * @author Leonardo Alves Nunes
 */
public class InteractiveCalculator {
  public static void main(String[] args) {
    int operator = 0;
    Scanner eyes = new Scanner(System.in);
    System.out.print("> ");
    String[] input = eyes.nextLine().split(" ");
    if (!input[0].equals("QUIT")) {
      while (!input[0].equals("QUIT")) {
        operator = 0;
        BigFraction bigElement = new BigFraction(input[0]);
        BFCalculator Calculator = new BFCalculator(bigElement);

        for (String element : input) {
          if (!element.equals("+") && !element.equals("-") && !element.equals("*")
              && !element.equals("/")) {
            bigElement = new BigFraction(element);
            switch (operator) {
              case 1:
                Calculator.add(bigElement);
                break;
              case 2:
                Calculator.subtract(bigElement);
                break;
              case 3:
                Calculator.multiply(bigElement);
                break;
              case 4:
                Calculator.divide(bigElement);
                break;
            } // switch
          } else {
            switch (element) {
              case "+":
                operator = 1;
                break;
              case "-":
                operator = 2;
                break;
              case "*":
                operator = 3;
                break;
              case "/":
                operator = 4;
                break;
            } // switch
          } // if else
        } // for
        Calculator.clear();
        System.out.print("> ");
        input = eyes.nextLine().split(" ");
      } // while
    } // if
    eyes.close();
  } // main(String[])
} // class InteractiveCalculator
