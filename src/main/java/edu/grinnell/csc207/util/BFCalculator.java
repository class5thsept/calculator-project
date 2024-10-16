package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * Util class that executes the calculator's operations.
 *
 * @author Leonardo Alves Nunes
 */
public class BFCalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  BigFraction lastValue;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  public BFCalculator(BigFraction lastValue) {
    this.lastValue = lastValue;
  } // BFCalculator(BigFraction)

  public BFCalculator() {
    this.lastValue = new BigFraction(0, 1);
  } // BFCalculator

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get the current value in the calculator.
   * 
   * @return BigFraction.
   */
  public BigFraction get() {
    return this.lastValue;
  } // get(BigFraction)

  /**
   * Add the fraction to a new one
   *
   * @param val The fraction to be added
   * 
   * @return void.
   */
  public void add(BigFraction val) {
    BigFraction result = lastValue.add(val);
    this.lastValue = result;
    printHelper(result);
  } // add(BigFraction)

  /**
   * Subtract the fraction to a new one.
   *
   * @param val The fraction to be suctracted.
   * 
   * @return void.
   */
  public void subtract(BigFraction val) {
    BigFraction result = lastValue.subtract(val);
    this.lastValue = result;
    printHelper(result);
  } // substract(BigFraction)

  /**
   * Multiply the fraction to a new one.
   *
   * @param val The fraction to be multiplied.
   * 
   * @return void.
   */
  public void multiply(BigFraction val) {
    BigFraction result = val.multiply(lastValue);
    this.lastValue = result;
    printHelper(result);
  } // multiply(BigFraction)

  /**
   * Divide the fraction to a new one
   *
   * @param val The fraction to be divided
   * 
   * @return void.
   */
  public void divide(BigFraction val) {
    BigFraction result = lastValue.divide(val);
    this.lastValue = result;
    printHelper(result);
  } // divide(BigFraction)

  public void clear() {
    this.lastValue.num = BigInteger.valueOf(0);
    this.lastValue.denom = BigInteger.valueOf(1);
  } // clear

  /**
   * Helper frunction that prints values calculates by the operations.
   *
   * @param result The result of the operation
   * 
   * @return void.
   */
  static void printHelper(BigFraction result) {
    if (result.denom.equals(BigInteger.valueOf(1))) {
      System.out.println(result.num);
    } else {
      System.out.println(result.num + "/" + result.denom);
    } // if else
  } // printHelper (BigFraction result)
} // class BFCalculator
