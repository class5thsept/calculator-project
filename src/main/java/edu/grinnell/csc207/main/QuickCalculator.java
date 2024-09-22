package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;

/**
 * Calculator that supports inputs in a single line.
 *
 * @author Leonardo Alves Nunes
 */
public class QuickCalculator {
  public static void main(String[] args) {
    int operator = 0;

    for (String expression : args) {
      operator = 0;

      String[] elements = expression.split(" ");

      BigFraction bigElement = new BigFraction(elements[0]);
      BFCalculator Calculator = new BFCalculator(bigElement);
      BFRegisterSet Register = new BFRegisterSet();

      for (String element : elements) {
        if (!element.equals("+") && !element.equals("-") && !element.equals("*")
            && !element.equals("/")) {
          if (Character.isLetter(element.charAt(0))) {
            bigElement = Register.get(element.charAt(0));
          } // if
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
    } //for
  } // main(String[])
} // class QuickCalculator
