package edu.grinnell.csc207.main;

import java.util.Scanner;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;

/**
 * Calculator that supports inputs (one expression per line).
 *
 * @author Leonardo Alves Nunes
 */
public class InteractiveCalculator {
  /**
   * UI for the interactive calculator.
   * @param args
   */
  public static void main(String[] args) {
    Scanner eyes = new Scanner(System.in);
    BFRegisterSet registers = new BFRegisterSet();
    BFCalculator calculator = null;
    System.out.print("> ");

    while (true) {
      String[] input = eyes.nextLine().split(" ");
      if (input[0].equals("QUIT")) {
        break;
      } // if else

      if (input[0].equals("STORE")) {
        char register = input[1].charAt(0);
        BigFraction value = calculator.get();
        registers.store(register, value);
        System.out.print("> ");
        continue;
      } // if else

      BigFraction bigElement;
      if (input[0].length() == 1 && Character.isLetter(input[0].charAt(0))) {
        bigElement = registers.get(input[0].charAt(0));
      } else {
        bigElement = new BigFraction(input[0]);
      } // if else

      calculator = new BFCalculator(bigElement);
      int operator = 0;

      for (String element : input) {
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
          } // if

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
      System.out.print("> ");
    } // while
    eyes.close();
  } // main(String[] arg)
} // class InteractiveCalculator
