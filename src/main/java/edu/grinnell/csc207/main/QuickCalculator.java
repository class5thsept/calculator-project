package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;

/**
 * Quick Calculator that processes inputs in a single line and supports basic operations.
 *
 * @author Leonardo Alves Nunes
 */
public class QuickCalculator {
  public static void main(String[] args) {
    BFRegisterSet registers = new BFRegisterSet();
    BFCalculator calculator = null;
    int operator = 0;

    for (String expression : args) {
      operator = 0;
      String[] elements = expression.split(" ");

      if (elements[0].equals("STORE")) {
        char register = elements[1].charAt(0);
        BigFraction value = calculator.get();
        registers.store(register, value);
        continue;
      } // if

      BigFraction bigElement;
      if (Character.isLetter(elements[0].charAt(0))) {
        bigElement = registers.get(elements[0].charAt(0));
      } else {
        bigElement = new BigFraction(elements[0]);
      } // if

      calculator = new BFCalculator(bigElement);

      for (int i = 1; i < elements.length; i++) {
        String element = elements[i];

        if (element.equals("+")) {
          operator = 1;
        } else if (element.equals("-")) {
          operator = 2;
        } else if (element.equals("*")) {
          operator = 3;
        } else if (element.equals("/")) {
          operator = 4;
        } else {
          BigFraction nextElement;
          if (element.length() == 1 && Character.isLetter(element.charAt(0))) {
            nextElement = registers.get(element.charAt(0));
          } else {
            nextElement = new BigFraction(element);
          } // if else

          switch (operator) {
            case 1:
              calculator.add(nextElement);
              break;
            case 2:
              calculator.subtract(nextElement);
              break;
            case 3:
              calculator.multiply(nextElement);
              break;
            case 4:
              calculator.divide(nextElement);
              break;
            default:
              break;
          } // switch
        } // if else
      } // for

      System.out.println(expression + " -> " + calculator.get());
    } // for
    calculator.clear();
  } // main (String[] args)
} // class QuickCalculator
